/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller.signer;

import compsi.crlv.controller.ControllerSmartCard;
import compsi.crlv.model.ModelLeitora;
import compsi.crlv.prompt.CommandProcessor;
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
    private boolean wirzzard;
    
    public ControllerSigner(ViewSigner vs, String renavam, boolean wizzard) {
        this.s = vs;
        this.codRenavam = renavam;
        this.wirzzard = wizzard;
        
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
        File f = new File("assinados/"+codRenavam+".p7s");
        if(f.exists())
            f.delete();
        
        FileOutputStream assinado =  new FileOutputStream(new File("assinados/"+codRenavam+".p7s"));
        
        assinado.write(command.execute(SignType.ADRB1V0));
        assinado.close();
        
        if(wirzzard){
            this.conectarLeitora();
            
            ControllerSmartCard cs = new ControllerSmartCard(null, null);
            String result = cs.gravar("assinados/"+codRenavam+".p7s");
            System.out.println(result);
        }
                
    }
    
    public void conectarLeitora() throws Exception{
        CommandProcessor.process("connect " + 0 + " " + "T=0");
        ModelLeitora leitora = new ModelLeitora();
        String result = leitora.Select_APPL();
    }
}
