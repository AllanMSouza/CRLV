/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv;
import compsi.crlv.controller.ControllerLeitora;
import compsi.crlv.controller.ControllerSmartCard;
import compsi.crlv.view.JIFLeitora;
import compsi.crlv.view.MainWondow;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.security.NoSuchAlgorithmException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author allan
 */
public class CompsiCRLV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, NoSuchAlgorithmException {
        String setProperty = System.setProperty("sun.security.smartcardio.t0GetResponse", "false");
        // TODO code application logic here
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        UIManager.setLookAndFeel(looks[1].getClassName());
        
        MainWondow m = new MainWondow();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();   
        JIFLeitora con = new JIFLeitora();
                
        ControllerLeitora conl = new ControllerLeitora(con);       
        ControllerSmartCard csc = new ControllerSmartCard(m,con);
        
        m.getLblLsitec().setBounds(0, tela.height/2, tela.width, 200);
        m.getDesktop().add(con);
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        m.setSize(tela.width, tela.height);
        m.setExtendedState(m.MAXIMIZED_BOTH);
        
        
        
        
    }
}
