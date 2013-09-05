/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view.signer.utils;

import compsi.icpbrasil.cert.ICPBrasilCertificate;
import compsi.icpbrasil.cert.utils.CertificateAnomaly;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.*;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author ettore
 */
public class CertificateRenderer implements ListCellRenderer<ICPBrasilCertificate>, TreeCellRenderer {

    Icon sucessIcon;
    Icon alertIcon;
    Icon errorIcon;
    Icon keyIcon;
    Icon anchorIcon;
    Icon caIcon;
    Icon timeIcon;
    Color alertColor;

    ListCellRenderer<Object> cellRenderer;
    TreeCellRenderer treeRenderer;

    public CertificateRenderer() {
        //this.sucessIcon = IconLoader.getSucessIcon(16);
        //this.alertIcon = IconLoader.getAlertIcon(16);
        //this.errorIcon = IconLoader.getErrorIcon(16);
        //this.keyIcon = IconLoader.getKeyIcon(16);
        //this.anchorIcon = IconLoader.getAnchorIcon(16);
        //this.caIcon = IconLoader.getCertificateIcon(16);
        //this.timeIcon = IconLoader.getClockIcon(16);
        //this.alertColor = new Color(255, 255, 138);
        cellRenderer =  new JList<>().getCellRenderer();
        //treeRenderer = new JTree().getCellRenderer();
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends ICPBrasilCertificate> jlist, ICPBrasilCertificate e, int i, boolean isSelected, boolean isHasFocus) {
        JLabel label = (JLabel) cellRenderer.getListCellRendererComponent(jlist,"", i, isSelected, isSelected);
        //JLabel label = new JLabel(e.getSubjectSimpleName());
        label.setText(e.getSubjectSimpleName());
        //label.setOpaque(true);
        //label.setBackground(Color.WHITE);
        if (e.isICPBrasil()) {
            label.setIcon(sucessIcon);
        }
        else {
            label.setText(label.getText() + " (" + e.countAnomalys() + " Anomalys)");
            label.setIcon(alertIcon);
        }
        /*if (isSelected) {
            label.setBackground(label.getBackground().darker());
        }*/
        return label;
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        JLabel label = (JLabel) treeRenderer.getTreeCellRendererComponent(tree, value, leaf, leaf, leaf, row, leaf);
        if (value instanceof CertificateTreeNode) {
            CertificateTreeNode node = (CertificateTreeNode) value;
            ICPBrasilCertificate cert = (ICPBrasilCertificate) node.getUserObject();
            //label = new JLabel(cert.getSubjectSimpleName());
            label.setText(cert.getSubjectSimpleName());
            label.setForeground(Color.DARK_GRAY);
            switch (cert.getICPBrasilVersion()) {
                case "A1":
                case "A2":
                case "A3":
                case "A4":
                    label.setIcon(keyIcon);
                    break;
                case "ROOT":
                    label.setIcon(anchorIcon);
                    break;
                case "CA":
                    label.setIcon(caIcon);
                    break;
                case "T3":
                case "T4":
                    label.setIcon(timeIcon);
                    break;
                default:
                    label.setIcon(errorIcon);
            }
            if (cert.countAnomalys() > 0) {
                //label.setOpaque(true);
                //label.setBackground(this.alertColor);
                List<CertificateAnomaly> anomalys = cert.getAnomalys();
                for (CertificateAnomaly anomaly : anomalys) {
                    if (anomaly.getIdentifier() == CertificateAnomaly.FAKE_CERTIFICATE) {
                        label.setIcon(errorIcon);
                        break;
                    }
                    if (anomaly.getIdentifier() == CertificateAnomaly.REVOKED) {
                        label.setIcon(errorIcon);
                        break;
                    }
                }
            }
        }
        return label;
    }
}
