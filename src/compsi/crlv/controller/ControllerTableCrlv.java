/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.DAO.DAOCrlv;
import compsi.crlv.view.JIFGerenciarCrlvs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import compsi.crlv.view.MainWindow;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allan
 */
public class ControllerTableCrlv implements ActionListener{

    MainWindow mw;
    
    public ControllerTableCrlv(MainWindow m) {
        mw = m;
        
        mw.getMiListarDocumentos().addActionListener(this);
    }    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            DAOCrlv db = new DAOCrlv();
            JIFGerenciarCrlvs gCrlvs = new JIFGerenciarCrlvs(db.getListCrlvs());
            gCrlvs.setVisible(true);
            mw.getDesktop().add(gCrlvs);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTableCrlv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerTableCrlv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
