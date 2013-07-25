/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv;
import compsi.crlv.controller.ControllerLeitora;
import compsi.crlv.view.MainWondow;
/**
 *
 * @author allan
 */
public class CompsiCRLV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String setProperty = System.setProperty("sun.security.smartcardio.t0GetResponse", "false");
        // TODO code application logic here
        MainWondow m = new MainWondow();
        
        m.setLocationRelativeTo(null);
        m.setVisible(true);
    }
}
