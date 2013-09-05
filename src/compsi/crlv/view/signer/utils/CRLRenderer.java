/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view.signer.utils;

import compsi.icpbrasil.crl.ICPBrasilCRL;
import java.awt.Component;
import java.text.SimpleDateFormat;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ettore
 */
public class CRLRenderer implements ListCellRenderer<ICPBrasilCRL> {

    ListCellRenderer cellRenderer;
    SimpleDateFormat dateFormat = new SimpleDateFormat("kk:mm:ss dd/MM/yyyy");

    public CRLRenderer() {
        cellRenderer = new JList<>().getCellRenderer();
    }


    @Override
    public Component getListCellRendererComponent(JList<? extends ICPBrasilCRL> jlist, ICPBrasilCRL e, int i, boolean isSelected, boolean bln1) {
        String text = null;
        String[] split = e.getIssuerX500Principal().toString().split(",");
        for (String s : split) {
            if (s.contains("CN")) {
                text = s.split("=")[1] + " (" + dateFormat.format(e.getThisUpdate()) + ")";
            }
        }
        return cellRenderer.getListCellRendererComponent(jlist,text, i, bln1, bln1);
    }
}
