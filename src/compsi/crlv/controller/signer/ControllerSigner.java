/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller.signer;

import compsi.crlv.view.signer.ViewSigner;
import compsi.icpbrasil.ICPBrasilSigner;
import compsi.icpbrasil.command.FirstSignature;
import compsi.icpbrasil.command.SignType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class ControllerSigner implements ActionListener{

    private ViewSigner s;
    private String codRenavam;
    
    public ControllerSigner(ViewSigner vs, String renavam) {
        this.s = vs;
        this.codRenavam = renavam;
        
        s.getBtAssinar().addActionListener(this);
        s.getBtCancelar().addActionListener(this);
    }   

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String op = ae.getActionCommand();
            
            switch(op){
                case "Assinar":
                    this.assinar();
                    s.dispose();
                    JOptionPane.showMessageDialog(null, "Arquivo assinado com sucesso!");
                    break;
                    
                case "Cancelar":
                    s.dispose();
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ControllerSigner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControllerSigner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void assinar() throws IOException, Exception{
        int index = s.getCertificateList().getSelectionModel().getLeadSelectionIndex();
        //System.out.println(s.getSigners().get(index));
        ICPBrasilSigner signer = s.getSigners().get(index);
//        System.out.println(new File("xmls/1.xml").exists());
        FirstSignature command = new FirstSignature(new File("xmls/"+codRenavam+".xml"), signer);
        FileOutputStream assinado =  new FileOutputStream(new File("assinados/"+codRenavam+".p7s"));
        assinado.write(command.execute(SignType.ADRB1V0));
        assinado.close();
        
        
    }
}
