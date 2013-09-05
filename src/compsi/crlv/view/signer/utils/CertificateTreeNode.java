/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view.signer.utils;

import compsi.icpbrasil.cert.ICPBrasilCACertificate;
import compsi.icpbrasil.cert.ICPBrasilCertificate;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

/**
 *
 * @author ettore
 */
public class CertificateTreeNode extends DefaultMutableTreeNode {

    private void initChildrens(ICPBrasilCertificate cert) {
        if ((cert.getBasicConstraints() != null && !cert.getBasicConstraints().isCA()) || cert.getBasicConstraints() == null) {
            return;
        }
        ICPBrasilCACertificate ca = (ICPBrasilCACertificate) cert;
        try {
            for (ICPBrasilCertificate c : ca.getChildren()) {
                this.add(new CertificateTreeNode(c));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(CertificateTreeNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (CertificateException ex) {
            Logger.getLogger(CertificateTreeNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(CertificateTreeNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CertificateTreeNode(ICPBrasilCertificate cert) {
        super(cert);
        this.initChildrens(cert);
    }

    public CertificateTreeNode(MutableTreeNode parent, ICPBrasilCertificate cert) {
        this(cert);
        this.setParent(parent);
    }

    public ICPBrasilCertificate getCertificate() {
        return (ICPBrasilCertificate) this.getUserObject();
    }

    @Override
    public String toString() {
        return super.getUserObject().getClass().getName();
    }
}
