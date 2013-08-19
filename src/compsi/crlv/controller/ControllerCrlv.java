/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.DAO.DAOCrlv;
import compsi.crlv.model.CRLV;
import compsi.crlv.view.JIFCrlv;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allan
 */
public class ControllerCrlv implements ActionListener {

    private DAOCrlv daoCrlv;
    private JIFCrlv jifCrlv;

    public ControllerCrlv(JIFCrlv tela) {
        jifCrlv = tela;
        daoCrlv = new DAOCrlv();
        
        jifCrlv.getBtSalvar().addActionListener(this);
    }  
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            CRLV c = new CRLV();
            jifCrlv.getModelCrlv(c);
            daoCrlv.insert(c);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerCrlv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCrlv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
