/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import compsi.crlv.DAO.DAOCrlv;
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
public class ControllerTableCrlv implements ActionListener{

    MainWindow mw;
    JIFGerenciarCrlvs gCrlv;
    
    public ControllerTableCrlv(JIFGerenciarCrlvs c, MainWindow m) {
        gCrlv = c;
        mw = m;
        gCrlv.getBtEditarCrlv().addActionListener(this);
        gCrlv.getBtAdicionarCrlv().addActionListener(this);
        gCrlv.getBtExcluirCrlv().addActionListener(this);
        
    }    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
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
        
    }
    
    protected void editarCrlv(){
        int index = gCrlv.getTableGerenciarCrlvs().getSelectionModel().getLeadSelectionIndex();
        //gCrlv.getCrlv().get(index);
        JIFCrlv jifCrlv = new JIFCrlv();
        ControllerCrlv conCrlv = new ControllerCrlv(jifCrlv, gCrlv.getCrlv().get(index));
        jifCrlv.setVisible(true);
        mw.getDesktop().add(jifCrlv);
        jifCrlv.getBtSalvar().setText("Salvar Alterações");        
    }
    
    protected void adicionarCrlv(){
        JIFCrlv jifCrlv = new JIFCrlv();
        jifCrlv.setVisible(true);
        mw.getDesktop().add(jifCrlv);
    }
    
    protected void deletarCrlv(){
        int index = gCrlv.getTableGerenciarCrlvs().getSelectionModel().getLeadSelectionIndex();
        if(index > -1){
            int teste = JOptionPane.showConfirmDialog(mw, "Deseja realmente excluir o documento selecionado?");
            System.out.println(teste);
        }
        else{
            JOptionPane.showMessageDialog(mw, "Selecione um documento para ser excluido!");
        }
    }
    
}
