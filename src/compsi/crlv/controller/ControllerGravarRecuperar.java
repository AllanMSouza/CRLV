/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.DAO.DAOCrlv;
import compsi.crlv.view.ViewGerenciarCrlvs;
import compsi.crlv.view.ViewGravarRecuperar;
import compsi.crlv.view.ViewLeitora;
import compsi.crlv.view.ViewMainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.smartcardio.CardException;

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
                    ControllerSmartCard cs = new ControllerSmartCard(mf, null);
                    cs.conectarLeitora();
                    
                    this.execRecuperar(cs);
                    break;
            }
        } catch (Exception ex) {
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
    
    protected void execRecuperar(ControllerSmartCard c){
        try {
            c.recuperar();
        } catch (CardException ex) {
            Logger.getLogger(ControllerGravarRecuperar.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerGravarRecuperar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControllerGravarRecuperar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(ControllerGravarRecuperar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ControllerGravarRecuperar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(ControllerGravarRecuperar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(ControllerGravarRecuperar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(ControllerGravarRecuperar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(ControllerGravarRecuperar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(ControllerGravarRecuperar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
