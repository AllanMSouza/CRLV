/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view.signer.utils;

import compsi.icpbrasil.cert.ICPBrasilCertificate;
import compsi.icpbrasil.cms.ICPBrasilSignature;
import java.awt.Component;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ettore
 */
public class SignatureRenderer implements ListCellRenderer<ICPBrasilSignature> {

    SimpleDateFormat dateFormat;

    ListCellRenderer<Object> cellRenderer;

    public SignatureRenderer() {
        this.cellRenderer = new JList<>().getCellRenderer();
        this.dateFormat = new SimpleDateFormat("( kk:mm - dd/MM/yyyy)");
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends ICPBrasilSignature> jlist, ICPBrasilSignature e, int i, boolean bln, boolean bln1) {
        ICPBrasilCertificate cert = e.getSignerCertificate();
        String text = null;
        if(cert != null){
            text = cert.getSubjectSimpleName() +" "+cert.getICPBrasilVersion()+" " + dateFormat.format(e.getSignedTime());
        }
        else{
            text =  e.getICPVersion();
        }
        JLabel label = (JLabel) cellRenderer.getListCellRendererComponent(jlist, text, i, bln, bln1);
        return label;
    }

}
