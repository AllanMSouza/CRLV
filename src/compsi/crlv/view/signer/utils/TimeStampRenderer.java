/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view.signer.utils;

import compsi.icpbrasil.cert.ICPBrasilCertificate;
import compsi.icpbrasil.cms.ICPBrasilTimeStamp;
import java.awt.Component;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ettore
 */
public class TimeStampRenderer implements ListCellRenderer<ICPBrasilTimeStamp> {

    SimpleDateFormat dateFormat = new SimpleDateFormat("kk:mm dd/MM/yyyy");
    ListCellRenderer listRenderer = new JList<>().getCellRenderer();

    @Override
    public Component getListCellRendererComponent(JList<? extends ICPBrasilTimeStamp> jlist, ICPBrasilTimeStamp e, int i, boolean bln, boolean bln1) {
        ICPBrasilCertificate cert = null;
        String label = null;
        try {
            cert = e.getSignerCertificate();
        }
        catch (CertificateException | IOException ex) {
            Logger.getLogger(TimeStampRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(cert != null){
            label = cert.getSubjectSimpleName() + "("+dateFormat.format(e.getSignedTime())+")";
        }
        else{
            label = dateFormat.format(e.getSignedTime());
        }
        JLabel l = (JLabel) listRenderer.getListCellRendererComponent(jlist, label, i, bln, bln1);
        return l;
    }

}
