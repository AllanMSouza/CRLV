/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view;

import compsi.crlv.model.CRLV;
import java.util.LinkedList;

/**
 *
 * @author allan
 */
public class JIFGerenciarCrlvs extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFGerenciarCrlvs
     */
    public JIFGerenciarCrlvs(LinkedList<CRLV> crlvs) {
        initComponents();
//        tableGerenciarCrlvs.setModel(null);
        for(int i = 0; i < crlvs.size(); i++ ){
            tableGerenciarCrlvs.setValueAt(crlvs.get(i).getVia(), i, 0);
            tableGerenciarCrlvs.setValueAt(crlvs.get(i).getCodRenavam(), i, 1);
            tableGerenciarCrlvs.setValueAt(crlvs.get(i).getNome(), i, 2);
            tableGerenciarCrlvs.setValueAt(crlvs.get(i).getCpfCnpj(), i, 3);
            
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableGerenciarCrlvs = new javax.swing.JTable();
        btAdicionarCrlv = new javax.swing.JButton();
        btEditarCrlv = new javax.swing.JButton();
        btExcluirCrlv = new javax.swing.JButton();
        btVizualizarCrlv = new javax.swing.JButton();
        btGerarXml = new javax.swing.JButton();

        tableGerenciarCrlvs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Via", "Código RENAVAM", "Nome", "CPF/CNPJ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableGerenciarCrlvs.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tableGerenciarCrlvs);
        tableGerenciarCrlvs.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableGerenciarCrlvs.getColumnModel().getColumn(0).setMinWidth(1);
        tableGerenciarCrlvs.getColumnModel().getColumn(0).setPreferredWidth(1);
        tableGerenciarCrlvs.getColumnModel().getColumn(3).setPreferredWidth(10);

        btAdicionarCrlv.setText("Adicionar CRLV");
        btAdicionarCrlv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarCrlvActionPerformed(evt);
            }
        });

        btEditarCrlv.setText("Editar CRLV");

        btExcluirCrlv.setText("Excluir CRLV");

        btVizualizarCrlv.setText("Vizualizar CRLV");
        btVizualizarCrlv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVizualizarCrlvActionPerformed(evt);
            }
        });

        btGerarXml.setText("Gerar XML");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAdicionarCrlv, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEditarCrlv, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluirCrlv, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btVizualizarCrlv, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btGerarXml, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdicionarCrlv)
                    .addComponent(btEditarCrlv)
                    .addComponent(btExcluirCrlv)
                    .addComponent(btVizualizarCrlv)
                    .addComponent(btGerarXml))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarCrlvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarCrlvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAdicionarCrlvActionPerformed

    private void btVizualizarCrlvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVizualizarCrlvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btVizualizarCrlvActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarCrlv;
    private javax.swing.JButton btEditarCrlv;
    private javax.swing.JButton btExcluirCrlv;
    private javax.swing.JButton btGerarXml;
    private javax.swing.JButton btVizualizarCrlv;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableGerenciarCrlvs;
    // End of variables declaration//GEN-END:variables

    

}

