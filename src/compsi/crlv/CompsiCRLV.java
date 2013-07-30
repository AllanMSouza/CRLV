/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv;
import compsi.crlv.controller.ControllerLeitora;
import compsi.crlv.controller.ControllerSmartCard;
import compsi.crlv.view.MainWondow;
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
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String setProperty = System.setProperty("sun.security.smartcardio.t0GetResponse", "false");
        // TODO code application logic here
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        UIManager.setLookAndFeel(looks[1].getClassName());
        
        MainWondow m = new MainWondow();
        ControllerSmartCard csc = new ControllerSmartCard(m);
        m.setLocationRelativeTo(null);
        m.setVisible(true);
    }
}
