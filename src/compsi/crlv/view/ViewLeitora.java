/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view;

import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author allan
 */
public class ViewLeitora extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFConectarLeitora
     */
    public ViewLeitora() {
        initComponents();
       
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pcscProtocolTransportGroup = new javax.swing.ButtonGroup();
        pcscReadersComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaConsole = new javax.swing.JTextArea();
        protocolT0Radio = new javax.swing.JRadioButton();
        protocolT1Radio = new javax.swing.JRadioButton();
        btConectar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Leitora Manager");

        pcscReadersComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcscReadersComboBoxActionPerformed(evt);
            }
        });

        jTextAreaConsole.setColumns(20);
        jTextAreaConsole.setRows(5);
        jScrollPane1.setViewportView(jTextAreaConsole);

        pcscProtocolTransportGroup.add(protocolT0Radio);
        protocolT0Radio.setSelected(true);
        protocolT0Radio.setText("T=0");
        protocolT0Radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                protocolT0RadioActionPerformed(evt);
            }
        });

        pcscProtocolTransportGroup.add(protocolT1Radio);
        protocolT1Radio.setText("T=1");
        protocolT1Radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                protocolT1RadioActionPerformed(evt);
            }
        });

        btConectar.setText("Conectar");
        btConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pcscReadersComboBox, 0, 342, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(protocolT0Radio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(protocolT1Radio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btConectar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pcscReadersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(protocolT0Radio)
                    .addComponent(protocolT1Radio)
                    .addComponent(btConectar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-586)/2, (screenSize.height-324)/2, 586, 324);
    }// </editor-fold>//GEN-END:initComponents

    
    private void pcscReadersComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcscReadersComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcscReadersComboBoxActionPerformed

    private void protocolT1RadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_protocolT1RadioActionPerformed
        // TODO add your handling code here:
        protocolT1Radio.setSelected(true);
        protocolT0Radio.setSelected(false);
    }//GEN-LAST:event_protocolT1RadioActionPerformed

    private void protocolT0RadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_protocolT0RadioActionPerformed
        // TODO add your handling code here:
        protocolT0Radio.setSelected(true);
        protocolT1Radio.setSelected(false);
    }//GEN-LAST:event_protocolT0RadioActionPerformed

    private void btConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConectarActionPerformed
  
    }//GEN-LAST:event_btConectarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConectar;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextAreaConsole;
    private javax.swing.ButtonGroup pcscProtocolTransportGroup;
    private javax.swing.JComboBox pcscReadersComboBox;
    private javax.swing.JRadioButton protocolT0Radio;
    private javax.swing.JRadioButton protocolT1Radio;
    // End of variables declaration//GEN-END:variables

    public static JTextArea getConsole() {
        return jTextAreaConsole;
    }

    public JButton getBtConectar() {
        return btConectar;
    }

    public void setBtConectar(JButton btConectar) {
        this.btConectar = btConectar;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public static JTextArea getjTextAreaConsole() {
        return jTextAreaConsole;
    }

    public static void setjTextAreaConsole(JTextArea jTextAreaConsole) {
        ViewLeitora.jTextAreaConsole = jTextAreaConsole;
    }

    public ButtonGroup getPcscProtocolTransportGroup() {
        return pcscProtocolTransportGroup;
    }

    public void setPcscProtocolTransportGroup(ButtonGroup pcscProtocolTransportGroup) {
        this.pcscProtocolTransportGroup = pcscProtocolTransportGroup;
    }

    public JComboBox getPcscReadersComboBox() {
        return pcscReadersComboBox;
    }

    public void setPcscReadersComboBox(JComboBox pcscReadersComboBox) {
        this.pcscReadersComboBox = pcscReadersComboBox;
    }

    public JRadioButton getProtocolT0Radio() {
        return protocolT0Radio;
    }

    public void setProtocolT0Radio(JRadioButton protocolT0Radio) {
        this.protocolT0Radio = protocolT0Radio;
    }

    public JRadioButton getProtocolT1Radio() {
        return protocolT1Radio;
    }

    public void setProtocolT1Radio(JRadioButton protocolT1Radio) {
        this.protocolT1Radio = protocolT1Radio;
    }
    
    

}
