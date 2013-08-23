/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.controller;

import com.thoughtworks.xstream.XStream;
import compsi.crlv.DAO.DAOCrlv;
import compsi.crlv.model.ModelCRLV;
import compsi.crlv.view.ViewCrlv;
import compsi.crlv.view.ViewGerenciarCrlvs;
import compsi.crlv.view.ViewXMLViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import compsi.crlv.view.ViewMainFrame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class ControllerGerenciaCrlvs implements ActionListener{

    ViewMainFrame mw;
    ViewGerenciarCrlvs gCrlv;
    
    public ControllerGerenciaCrlvs(ViewGerenciarCrlvs c, ViewMainFrame m) {
        gCrlv = c;
        mw = m;
        gCrlv.getBtEditarCrlv().addActionListener(this);
        gCrlv.getBtAdicionarCrlv().addActionListener(this);
        gCrlv.getBtExcluirCrlv().addActionListener(this);
        gCrlv.getBtGerarXml().addActionListener(this);
        
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
                    
                case "Gerar XML":
                    gerarXml();
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
            ViewCrlv jifCrlv = new ViewCrlv();
            ControllerCrlv conCrlv = new ControllerCrlv(jifCrlv, gCrlv.getCrlv().get(index));
            jifCrlv.setVisible(true);
            mw.getDesktop().add(jifCrlv);
            jifCrlv.getBtSalvar().setText("Salvar Alterações");
        }
        else 
            JOptionPane.showMessageDialog(mw, "Selecione um documento para ser editado!");
    }
    
    protected void adicionarCrlv(){
        ViewCrlv jifCrlv = new ViewCrlv();
        ControllerCrlv conCrlv = new ControllerCrlv(jifCrlv, null);
        mw.getDesktop().add(jifCrlv);
        jifCrlv.setVisible(true);
    }
    
    protected void deletarCrlv() throws ClassNotFoundException, SQLException{
        int index = gCrlv.getTableGerenciarCrlvs().getSelectionModel().getLeadSelectionIndex();
        if(index > -1){
            int resp = JOptionPane.showConfirmDialog(mw, "Deseja realmente excluir o documento selecionado?");
            if(resp == 0){
                ModelCRLV tempCrlv = gCrlv.getCrlv().get(index);
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
    
    protected void gerarXml(){
        int index = gCrlv.getTableGerenciarCrlvs().getSelectionModel().getLeadSelectionIndex();
        if(index > -1){
            XStream xstream = new XStream();
            ModelCRLV c = gCrlv.getCrlv().get(index);
            String xml = xstream.toXML(c);
            
            ViewXMLViewer jifXmlViewer = new ViewXMLViewer();
            ControllerXMLViewer conXml = new ControllerXMLViewer(jifXmlViewer, xml, c.getCodRenavam());
            jifXmlViewer.getTxtAreaXmlViewer().setText(xml);
            mw.getDesktop().add(jifXmlViewer);
            jifXmlViewer.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(mw, "Selecione um documento para gerar o XML!");
    }
    
}
