/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.model.Leitora;
import compsi.crlv.prompt.CommandProcessor;
import compsi.crlv.view.JIFLeitora;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.logging.Level;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import pkcs11_lea.JDialog_Docs_Manager;
import pkcs11_lea.MainGui;


/**
 *
 * @author allan
 */
public class ControllerLeitora implements ActionListener{

    private Leitora leitora;
    private JIFLeitora telaLeitora;
    
    public ControllerLeitora(JIFLeitora con) {
        CommandProcessor.init();
        leitora = new Leitora();
        telaLeitora = con;
        
        telaLeitora.getPcscReadersComboBox().setModel(new DefaultComboBoxModel(leitora.getReaders()));
        telaLeitora.getBtConectar().addActionListener(this);
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) {
         String transportProtocol = "";
        String resultado;

        if (telaLeitora.getBtConectar().getText().equals("Conectar")) {

            Enumeration<AbstractButton> elements = telaLeitora.getPcscProtocolTransportGroup().getElements();

            while (elements.hasMoreElements()) {
                JRadioButton radio = (JRadioButton) elements.nextElement();

                if (radio.isSelected()) {
                    transportProtocol = radio.getText();
                }
            }
            try {

                CommandProcessor.process("connect " + telaLeitora.getPcscReadersComboBox().getSelectedIndex() + " " + transportProtocol);

                telaLeitora.getBtConectar().setText("Desconectar");

                Cursor hourglassCursor = new Cursor(Cursor.WAIT_CURSOR);
                telaLeitora.setCursor(hourglassCursor);

                resultado = leitora.Select_APPL();
               // telaLeitora.setVisible(false);
//                JDialog_Docs_Manager jDialog_Docs_Manager = new JDialog_Docs_Manager(this,true);
//                jDialog_Docs_Manager.setLocationRelativeTo(null);
//                jDialog_Docs_Manager.setVisible(true);
                

                Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
                telaLeitora.setCursor(normalCursor);

            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
                ex.getMessage();
                ex.getLocalizedMessage();
            }

        } else if (telaLeitora.getBtConectar().getText().equals("Desconectar")) {
            try {
                CommandProcessor.process("disconnect");
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
            }

            telaLeitora.getBtConectar().setText("Conectar");
        }
    }
    
}
