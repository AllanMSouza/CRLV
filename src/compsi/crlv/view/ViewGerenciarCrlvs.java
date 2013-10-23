/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view;

import compsi.crlv.model.ModelCRLV;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;


/**
 *
 * @author allan
 */
public class ViewGerenciarCrlvs extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFGerenciarCrlvs
     */
    protected List<ModelCRLV> crlv;

    public List<ModelCRLV> getCrlv() {
        return crlv;
    }

    public JTable getTableGerenciarCrlvs() {
        return tableGerenciarCrlvs;
    }

    public void setTableGerenciarCrlvs(JTable tableGerenciarCrlvs) {
        this.tableGerenciarCrlvs = tableGerenciarCrlvs;
    }

    public JButton getBtAdicionarCrlv() {
        return btAdicionarCrlv;
    }

    public void setBtAdicionarCrlv(JButton btAdicionarCrlv) {
        this.btAdicionarCrlv = btAdicionarCrlv;
    }

    public JButton getBtEditarCrlv() {
        return btEditarCrlv;
    }

    public void setBtEditarCrlv(JButton btEditarCrlv) {
        this.btEditarCrlv = btEditarCrlv;
    }

    public JButton getBtExcluirCrlv() {
        return btExcluirCrlv;
    }

    public void setBtExcluirCrlv(JButton btExcluirCrlv) {
        this.btExcluirCrlv = btExcluirCrlv;
    }

    public JButton getBtGerarXml() {
        return btGerarXml;
    }

    public void setBtGerarXml(JButton btGerarXml) {
        this.btGerarXml = btGerarXml;
    }

    public JButton getBtVizualizarCrlv() {
        return btGravarCrlv;
    }

    public void setBtVizualizarCrlv(JButton btVizualizarCrlv) {
        this.btGravarCrlv = btVizualizarCrlv;
    }

    public JButton getBtGravarCrlv() {
        return btGravarCrlv;
    }
    
    
    
    public ViewGerenciarCrlvs(LinkedList<ModelCRLV> crlvs) {
        crlv = org.jdesktop.observablecollections.ObservableCollections.observableList(crlvs);
        initComponents();
    }
    
    public void addCrlv(ModelCRLV c){
        crlv.add(c);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        btAdicionarCrlv = new javax.swing.JButton();
        btEditarCrlv = new javax.swing.JButton();
        btExcluirCrlv = new javax.swing.JButton();
        btGravarCrlv = new javax.swing.JButton();
        btGerarXml = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableGerenciarCrlvs = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gerenciar Lista de Documentos");
        setToolTipText("");

        btAdicionarCrlv.setText("Adicionar CRLV");
        btAdicionarCrlv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarCrlvActionPerformed(evt);
            }
        });

        btEditarCrlv.setText("Editar CRLV");

        btExcluirCrlv.setText("Excluir CRLV");

        btGravarCrlv.setText("Assinar & Gravar");
        btGravarCrlv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarCrlvActionPerformed(evt);
            }
        });

        btGerarXml.setText("Gerar XML");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${crlv}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tableGerenciarCrlvs);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${via}"));
        columnBinding.setColumnName("Via");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${chassi}"));
        columnBinding.setColumnName("Chassi");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codRenavam}"));
        columnBinding.setColumnName("Cod Renavam");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cpfCnpj}"));
        columnBinding.setColumnName("Cpf Cnpj");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${rntrc}"));
        columnBinding.setColumnName("Rntrc");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(tableGerenciarCrlvs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAdicionarCrlv, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEditarCrlv, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluirCrlv, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(btGerarXml, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btGravarCrlv, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdicionarCrlv)
                    .addComponent(btEditarCrlv)
                    .addComponent(btExcluirCrlv)
                    .addComponent(btGravarCrlv)
                    .addComponent(btGerarXml))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-720)/2, (screenSize.height-434)/2, 720, 434);
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarCrlvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarCrlvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAdicionarCrlvActionPerformed

    private void btGravarCrlvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarCrlvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btGravarCrlvActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarCrlv;
    private javax.swing.JButton btEditarCrlv;
    private javax.swing.JButton btExcluirCrlv;
    private javax.swing.JButton btGerarXml;
    private javax.swing.JButton btGravarCrlv;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableGerenciarCrlvs;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables


    

}

