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
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class ControllerCrlv implements ActionListener {

    private DAOCrlv daoCrlv;
    private JIFCrlv jifCrlv;
    private CRLV crlv;

    public ControllerCrlv(JIFCrlv tela, CRLV c) {
        jifCrlv = tela;
        daoCrlv = new DAOCrlv();
        
        if(c == null)
            crlv = new CRLV();
        
        else{
            crlv = c;
            jifCrlv.setModelCrlv(crlv);
        }
        
        jifCrlv.getBtSalvar().addActionListener(this);
    }  
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String op = ae.getActionCommand();
            
            switch(op){
                case "Salvar":
                    execSalvarCrlv();
                    break;
                    
                case "Salvar Alterações":
                    execSalvarAlteracoesCrlv();
                    break;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerCrlv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCrlv.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    private void execSalvarCrlv() throws ClassNotFoundException, SQLException{
         CRLV c = new CRLV();
         c = jifCrlv.getModelCrlv(c, "adicionar");
         int result = daoCrlv.insert(c);
         if(result == 1){
             JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
             jifCrlv.dispose();
         }
         else {
             JOptionPane.showMessageDialog(null, "Erro ao inserir registro!");
             jifCrlv.dispose();
         }
    }
    
    private void execSalvarAlteracoesCrlv() throws ClassNotFoundException, SQLException{
         crlv = jifCrlv.getModelCrlv(crlv, "editar");
         int result = daoCrlv.update(crlv);
         if(result == 1){
             JOptionPane.showMessageDialog(null, "Registro Atualizado com sucesso!");
             jifCrlv.dispose();
         }
         else {
             JOptionPane.showMessageDialog(null, "Erro ao atualizar registro!");
             jifCrlv.dispose();
         }
    }
    
}
