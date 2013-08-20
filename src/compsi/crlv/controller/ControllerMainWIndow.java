/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.DAO.DAOCrlv;
import compsi.crlv.view.JIFGerenciarCrlvs;
import compsi.crlv.view.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allan
 */
public class ControllerMainWIndow implements ActionListener{
    
    MainWindow mw;

    public ControllerMainWIndow(MainWindow m) {
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
                    JIFGerenciarCrlvs gCrlvs = new JIFGerenciarCrlvs(daoCrlv.getListCrlvs());
                    ControllerGerenciaCrlvs conTableCrlv = new ControllerGerenciaCrlvs(gCrlvs, mw);
                    mw.getDesktop().add(gCrlvs);
                    gCrlvs.setVisible(true);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMainWIndow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerMainWIndow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
