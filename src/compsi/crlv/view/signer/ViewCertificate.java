/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view.signer;

import compsi.crlv.view.signer.utils.AnomalyMessageLevel;
import compsi.crlv.view.signer.utils.CertificateRenderer;
import compsi.crlv.view.signer.utils.CertificateTreeModel;
import compsi.crlv.view.signer.utils.CertificateTreeNode;
import compsi.crlv.view.signer.utils.MessageLevel;
import compsi.crlv.view.signer.utils.MessageLevelRenderer;
import compsi.crlv.view.signer.utils.SignatureRenderer;
import compsi.crlv.view.signer.utils.SignerRenderer;
import compsi.crlv.view.signer.utils.TimeStampRenderer;
import compsi.icpbrasil.cert.ICPBrasilCACertificate;
import compsi.icpbrasil.cert.ICPBrasilCertificate;
import compsi.icpbrasil.cert.ICPBrasilFinalUserCertificate;
import compsi.icpbrasil.cert.utils.CertificateAnomaly;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ListModel;
import javax.swing.tree.TreeModel;


/**
 *
 * @author ettore
 */
public abstract class ViewCertificate extends JFrame {

    public ViewCertificate(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }

    public ViewCertificate(String title) throws HeadlessException {
        super(title);
    }

    public ViewCertificate(GraphicsConfiguration gc) {
        super(gc);
    }

    public ViewCertificate() throws HeadlessException {
        super();
    }
    static CertificateRenderer certRenderer;
    static MessageLevelRenderer messageRenderer;
    static SignerRenderer signerRenderer;
    static SignatureRenderer signatureRenderer;
    static TimeStampRenderer timeStampRenderer;

    static {
        ViewCertificate.certRenderer = new CertificateRenderer();
        ViewCertificate.messageRenderer = new MessageLevelRenderer();
        ViewCertificate.signerRenderer = new SignerRenderer();
        ViewCertificate.signatureRenderer = new SignatureRenderer();
        ViewCertificate.timeStampRenderer = new TimeStampRenderer();
    }

    public abstract ICPBrasilCertificate getCertificate();

    public ListModel<ICPBrasilCertificate> getChainListModel() {
        DefaultListModel<ICPBrasilCertificate> lmodel = new DefaultListModel<>();
        for (ICPBrasilCertificate c : this.getCertificate().getChain()) {
            lmodel.addElement(c);
        }
        return lmodel;
    }

    public ListModel getValidations() {
        DefaultListModel<MessageLevel> lmodel = new DefaultListModel<>();
        for (CertificateAnomaly a : this.getCertificate().getAnomalys()) {
            lmodel.addElement(new AnomalyMessageLevel(a));
        }
        return lmodel;
    }

    public TreeModel getCertificatesTreeModel() {
        CertificateTreeNode root = new CertificateTreeNode(this.getCertificate());
        TreeModel tree = new CertificateTreeModel(root);
        return tree;
    }

    public static CertificateRenderer getCertificateRenderer() {
        return ViewCertificate.certRenderer;
    }

    public static MessageLevelRenderer getMessageRenderer() {
        return messageRenderer;
    }

    public static SignerRenderer getSignerRenderer() {
        return signerRenderer;
    }

    public static SignatureRenderer getSignatureRenderer() {
        return ViewCertificate.signatureRenderer;
    }

    public static TimeStampRenderer getTimeStampRenderer() {
        return ViewCertificate.timeStampRenderer;
    }

//    public static ViewCertificate getFrame(ICPBrasilCertificate certificate) {
//        if (certificate instanceof ICPBrasilFinalUserCertificate) {
//            return new JFUserCertificate((ICPBrasilFinalUserCertificate) certificate);
//        }
//        else if (certificate instanceof ICPBrasilCACertificate) {
//            return new JFCACertificate((ICPBrasilCACertificate) certificate);
//        }
//        else {
//            return null;
//        }
//    }

//    public static void openFrame(ICPBrasilCertificate certificate) {
//        ViewCertificate frame = ViewCertificate.getFrame(certificate);
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setVisible(true);
    //}
}
