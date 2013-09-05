/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.DAO.DAOCrlv;
import compsi.crlv.controller.signer.ControllerSigner;
import compsi.crlv.model.ModelSigner;
import compsi.crlv.view.ViewGerenciarCrlvs;
import compsi.crlv.view.ViewMainFrame;
import compsi.crlv.view.signer.ViewSigner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.security.KeyStoreException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class ControllerMainFrame implements ActionListener{
    
    ViewMainFrame mw;

    public ControllerMainFrame(ViewMainFrame m) {
        mw = m;
        
        mw.getMiListarDocumentos().addActionListener(this);
        mw.getMiAssinaturaADRB().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String op = ae.getActionCommand();
            
            switch(op) {
                case "Listar Documentos":
                    DAOCrlv daoCrlv = new DAOCrlv();
                    ViewGerenciarCrlvs gCrlvs = new ViewGerenciarCrlvs(daoCrlv.getListCrlvs());
                    ControllerGerenciaCrlvs conTableCrlv = new ControllerGerenciaCrlvs(gCrlvs, mw);
                    mw.getDesktop().add(gCrlvs);
                    gCrlvs.setVisible(true);
                    break;
                    
                case "AD_RB":
                    ModelSigner model = new ModelSigner();
                    ViewSigner viewSigner = new ViewSigner(model);
                    String renavam = requestCrlv();
                    
                    if(this.existeCrlv(renavam)){
                         mw.getDesktop().add(viewSigner);
                         ControllerSigner conSigner = new ControllerSigner(viewSigner, renavam);
                         viewSigner.setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Documento não existe");
                    }
                        
        
            }
        } catch (KeyStoreException ex) {
            Logger.getLogger(ControllerMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String requestCrlv(){
        return JOptionPane.showInputDialog("Informe o RENAVAM");
    }
    
    public boolean existeCrlv(String renavam){
    
        return new File("xmls/"+renavam+".xml").exists();
    }
    
}
