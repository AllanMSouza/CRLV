/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.DAO.DAOCrlv;
import compsi.crlv.view.ViewGerenciarCrlvs;
import compsi.crlv.view.ViewGravarRecuperar;
import compsi.crlv.view.ViewMainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FreeBlue
 */
public class ControllerGravarRecuperar implements ActionListener{

    private ViewGravarRecuperar gr;
    private ViewMainFrame mf;
    public ControllerGravarRecuperar(ViewGravarRecuperar g, ViewMainFrame m) {
    
        this.gr = g;
        this.mf = m;
        
        gr.getBtGravar().addActionListener(this);
        gr.getBtRecuperar().addActionListener(this);
    }   
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String op = e.getActionCommand();
            
            switch(op){
                case "Gravar":
                    this.showViewGerenciarCrlvs();
                    break;
                    
                case "Recuperar":
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerGravarRecuperar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerGravarRecuperar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showViewGerenciarCrlvs() throws SQLException, ClassNotFoundException{
        DAOCrlv daoCrlv = new DAOCrlv();
        ViewGerenciarCrlvs gCrlvs = new ViewGerenciarCrlvs(daoCrlv.getListCrlvs());
        ControllerGerenciaCrlvs conTableCrlv = new ControllerGerenciaCrlvs(gCrlvs, mf);
        mf.getDesktop().add(gCrlvs);
        gCrlvs.setVisible(true);
    }
    
}
