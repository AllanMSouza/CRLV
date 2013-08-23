/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.DAO.DAOCrlv;
import compsi.crlv.view.ViewGerenciarCrlvs;
import compsi.crlv.view.ViewMainFrame;
import compsi.crlv.view.signer.ViewSigner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allan
 */
public class ControllerMainFrame implements ActionListener{
    
    ViewMainFrame mw;

    public ControllerMainFrame(ViewMainFrame m) {
        mw = m;
        
        mw.getMiListarDocumentos().addActionListener(this);
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
                    ViewSigner viewSigner = new ViewSigner();
                    mw.getDesktop().add(viewSigner);
                    viewSigner.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
