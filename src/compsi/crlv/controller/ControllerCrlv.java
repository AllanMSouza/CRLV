/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.DAO.DAOCrlv;
import compsi.crlv.model.ModelCRLV;
import compsi.crlv.view.ViewCrlv;
import compsi.crlv.view.ViewGerenciarCrlvs;
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
    private ViewCrlv jifCrlv;
    private ModelCRLV crlv;
    private ViewGerenciarCrlvs gcrlv;

    public ControllerCrlv(ViewCrlv tela, ModelCRLV c, ViewGerenciarCrlvs g) {
        jifCrlv = tela;
        daoCrlv = new DAOCrlv();
        gcrlv = g;
        
        if(c == null)
            crlv = new ModelCRLV();
        
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
         ModelCRLV c = new ModelCRLV();
         c = jifCrlv.getModelCrlv(c, "adicionar");
         int result = daoCrlv.insert(c);
         gcrlv.addCrlv(c);
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
