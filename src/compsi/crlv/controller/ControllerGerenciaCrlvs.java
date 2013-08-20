/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.DAO.DAOCrlv;
import compsi.crlv.model.CRLV;
import compsi.crlv.view.JIFCrlv;
import compsi.crlv.view.JIFGerenciarCrlvs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import compsi.crlv.view.MainWindow;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class ControllerGerenciaCrlvs implements ActionListener{

    MainWindow mw;
    JIFGerenciarCrlvs gCrlv;
    
    public ControllerGerenciaCrlvs(JIFGerenciarCrlvs c, MainWindow m) {
        gCrlv = c;
        mw = m;
        gCrlv.getBtEditarCrlv().addActionListener(this);
        gCrlv.getBtAdicionarCrlv().addActionListener(this);
        gCrlv.getBtExcluirCrlv().addActionListener(this);
        
    }    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String op = ae.getActionCommand();
            switch(op){
                case "Editar CRLV":
                    editarCrlv();
                    break;
                    
                case "Adicionar CRLV":
                    adicionarCrlv();
                    break;
                    
                case "Excluir CRLV":
                    deletarCrlv();
                    break;       
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerGerenciaCrlvs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerGerenciaCrlvs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    protected void editarCrlv(){
        int index = gCrlv.getTableGerenciarCrlvs().getSelectionModel().getLeadSelectionIndex();
        if(index > -1){
            //gCrlv.getCrlv().get(index);
            JIFCrlv jifCrlv = new JIFCrlv();
            ControllerCrlv conCrlv = new ControllerCrlv(jifCrlv, gCrlv.getCrlv().get(index));
            jifCrlv.setVisible(true);
            mw.getDesktop().add(jifCrlv);
            jifCrlv.getBtSalvar().setText("Salvar Alterações");
        }
        else 
            JOptionPane.showMessageDialog(mw, "Selecione um documento para ser editado!");
    }
    
    protected void adicionarCrlv(){
        JIFCrlv jifCrlv = new JIFCrlv();
        ControllerCrlv conCrlv = new ControllerCrlv(jifCrlv, null);
        mw.getDesktop().add(jifCrlv);
        jifCrlv.setVisible(true);
    }
    
    protected void deletarCrlv() throws ClassNotFoundException, SQLException{
        int index = gCrlv.getTableGerenciarCrlvs().getSelectionModel().getLeadSelectionIndex();
        if(index > -1){
            int resp = JOptionPane.showConfirmDialog(mw, "Deseja realmente excluir o documento selecionado?");
            if(resp == 0){
                CRLV tempCrlv = gCrlv.getCrlv().get(index);
                DAOCrlv daoCrlv = new DAOCrlv();
                int result = daoCrlv.destroy(tempCrlv.getIdCrlv());
                
                if(result == 1){
                    JOptionPane.showMessageDialog(mw, "Registro excluido com sucesso!");
                }
                else {
                    JOptionPane.showMessageDialog(mw, "Erro ao excluir registro!");
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(mw, "Selecione um documento para ser excluido!");
        }
    }
    
}
