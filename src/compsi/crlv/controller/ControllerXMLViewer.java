/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.view.ViewXMLViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class ControllerXMLViewer implements ActionListener{
    private ViewXMLViewer jifXmlViewer;
    private String conteudo;
    private String renavam;

    public ControllerXMLViewer(ViewXMLViewer xmlViewer, String xml, String codRenavam) {
        jifXmlViewer = xmlViewer;
        conteudo = xml;
        renavam = codRenavam;
        
        jifXmlViewer.getBtSalvar().addActionListener(this);
        jifXmlViewer.getBtCancelar().addActionListener(this);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {      
            String op = ae.getActionCommand();
            switch(op){
                case "Salvar":
                    execSalvarXml();
                    break;
                    
                case "Cancelar":
                    jifXmlViewer.dispose();
                    break;
            }   
        } catch (IOException ex) {
            Logger.getLogger(ControllerXMLViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean salvarXml() throws IOException{
        boolean status;
        File f = new File("xmls/", renavam+".xml");
        if(f.exists())
            f.delete();
        
        status = f.createNewFile();
        
        FileWriter x = new FileWriter(f, true);
        x.write("<?xml version =  \"1.0\" encoding=\"UTF-8\"?>\n" + conteudo);
        x.close();
        return status;
    
    }
    
    private void execSalvarXml() throws IOException{
        boolean status = salvarXml();
        if(status){
            JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso!");
            jifXmlViewer.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo!");
            jifXmlViewer.dispose();
        }
    }   
    
}
