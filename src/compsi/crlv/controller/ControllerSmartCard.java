/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.model.SmartCard;
import compsi.crlv.view.MainWondow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.CardException;
import javax.swing.JOptionPane;
import pkcs11_lea.util.Hex;

/**
 *
 * @author allan
 */
public class ControllerSmartCard implements ActionListener {

    private SmartCard sc;
    private MainWondow mw;

    public ControllerSmartCard(MainWondow m) {
        sc = new SmartCard();    
        mw = m;
        
        mw.getMiVersao().addActionListener(this);
    }    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            //throw new UnsupportedOperationException("Not supported yet.");
            String result = getVersion();
            System.out.println(result);
            JOptionPane.showMessageDialog(null, "Versão: " + result);
        } catch (CardException ex) {
            Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControllerSmartCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String getVersion() throws CardException, FileNotFoundException, IOException{
        PCSCManager.LOGAR("Obter a versão do Applet");
        sc.setResponse(PCSCManager.sendAPDU("8007000000"));
        sc.setResultado(Hex.printBytesHexa(sc.getResponse()));
        return sc.getResultado().substring(0, sc.getResultado().length() - 4 );        
    }
    
}
