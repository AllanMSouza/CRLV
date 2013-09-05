/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view.signer.utils;

import compsi.icpbrasil.ICPBrasilSigner;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ettore
 */
public class SignerRenderer implements ListCellRenderer<ICPBrasilSigner> {

    Icon keyIcon;
    Icon smartCardIcon;

    Color normal = Color.WHITE;
    Color alert = new Color(255,255,138);

    public SignerRenderer(){
        this.keyIcon = IconLoader.getKeyIcon(16);
        this.smartCardIcon = IconLoader.getSmartCardIcon(16);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends ICPBrasilSigner> jlist, ICPBrasilSigner e, int i, boolean isSelected, boolean hasFocus) {
        JLabel label = new JLabel(e.getAlias() + "("+e.getCertificate().getX509Certificate().getSigAlgName()+")");
        label.setIcon(this.getIcon(e));
        label.setOpaque(true);
        if(e.getCertificate().countAnomalys() > 0){
            label.setBackground(alert);
        }
        else{
            label.setBackground(normal);
        }
        if (isSelected){
            label.setBackground(label.getBackground().darker());
        }
        return label;
    }

    private Icon getIcon(ICPBrasilSigner signer){
        String type = signer.getCertificate().getICPBrasilVersion();
        switch (type){
            case "A3":
            case "A4":
            case "S3":
            case "S4":
                return this.smartCardIcon;
            default:
                return this.keyIcon;
        }
    }

}
