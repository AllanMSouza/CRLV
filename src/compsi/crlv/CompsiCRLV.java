/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv;
import compsi.crlv.controller.ControllerLeitora;
import compsi.crlv.controller.ControllerMainFrame;
import compsi.crlv.controller.ControllerSmartCard;
import compsi.crlv.controller.ControllerGerenciaCrlvs;
import compsi.crlv.view.ViewLeitora;
import compsi.crlv.view.ViewMainFrame;
import compsi.icpbrasil.ICPBrasilCRLStore;
import compsi.icpbrasil.ICPBrasilStore;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
/**
 *
 * @author allan
 */
public class CompsiCRLV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, NoSuchAlgorithmException, KeyStoreException {
        String setProperty = System.setProperty("sun.security.smartcardio.t0GetResponse", "false");
        //Security.addProvider(new BouncyCastleProvider());
        // TODO code application logic here
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        UIManager.setLookAndFeel(looks[1].getClassName());
        
        ViewMainFrame m = new ViewMainFrame();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();   
        ViewLeitora con = new ViewLeitora();
                
        ControllerLeitora conl = new ControllerLeitora(con);       
        ControllerSmartCard csc = new ControllerSmartCard(m,con);
        ControllerMainFrame comMain = new ControllerMainFrame(m);
        
        m.getLblLsitec().setBounds(0, tela.height/2, tela.width, 200);
        m.getDesktop().add(con);
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        m.setSize(tela.width, tela.height);
        m.setExtendedState(m.MAXIMIZED_BOTH);
        
        ICPBrasilStore.getInstance();
        
        
        
    }
}
