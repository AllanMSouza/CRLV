/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view;

import compsi.crlv.controller.ControllerLeitora;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import pkcs11_lea.MainGui;

/**
 *
 * @author allan
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWondow
     */
    public MainWindow() {
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

        desktop = new javax.swing.JDesktopPane();
        lblLsitec = new javax.swing.JLabel();
        mbMainWindow = new javax.swing.JMenuBar();
        menuLeitora = new javax.swing.JMenu();
        menuConectarLeitora = new javax.swing.JMenuItem();
        menuCrlv = new javax.swing.JMenu();
        miFormularioCrlv = new javax.swing.JMenuItem();
        miListarDocumentos = new javax.swing.JMenuItem();
        miGerarXML = new javax.swing.JMenuItem();
        miVizualizarDocumento = new javax.swing.JMenuItem();
        menuAssinador = new javax.swing.JMenu();
        menuSmartCard = new javax.swing.JMenu();
        menuConfiguracoesSmartCard = new javax.swing.JMenu();
        miInicializarCartao = new javax.swing.JMenuItem();
        miVersao = new javax.swing.JMenuItem();
        miDesbloquearPIN = new javax.swing.JMenuItem();
        miTrocarPUK = new javax.swing.JMenuItem();
        miTrocarPIN = new javax.swing.JMenuItem();
        miVerificarDocumento = new javax.swing.JMenuItem();
        miGravarDocumento = new javax.swing.JMenuItem();
        miRecuperarDocumento = new javax.swing.JMenuItem();
        miDeletarDocumento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLsitec.setBackground(new java.awt.Color(254, 254, 254));
        lblLsitec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLsitec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compsi/crlv/view/lsitec.jpg"))); // NOI18N
        lblLsitec.setLabelFor(desktop);
        lblLsitec.setOpaque(true);
        lblLsitec.setBounds(0, 240, 442, 120);
        desktop.add(lblLsitec, javax.swing.JLayeredPane.DEFAULT_LAYER);

        menuLeitora.setText("Leitora");

        menuConectarLeitora.setText("Conectar");
        menuConectarLeitora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConectarLeitoraActionPerformed(evt);
            }
        });
        menuLeitora.add(menuConectarLeitora);

        mbMainWindow.add(menuLeitora);

        menuCrlv.setText("CRLV");

        miFormularioCrlv.setText("Formulário CRLV");
        miFormularioCrlv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFormularioCrlvActionPerformed(evt);
            }
        });
        menuCrlv.add(miFormularioCrlv);

        miListarDocumentos.setText("Listar Documentos");
        miListarDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miListarDocumentosActionPerformed(evt);
            }
        });
        menuCrlv.add(miListarDocumentos);

        miGerarXML.setText("Gerar XML");
        menuCrlv.add(miGerarXML);

        miVizualizarDocumento.setText("Vizualizar Documento");
        menuCrlv.add(miVizualizarDocumento);

        mbMainWindow.add(menuCrlv);

        menuAssinador.setText("Assinador");
        mbMainWindow.add(menuAssinador);

        menuSmartCard.setText("Smart Card");

        menuConfiguracoesSmartCard.setText("Configurações");

        miInicializarCartao.setText("Inicializar Cartão");
        menuConfiguracoesSmartCard.add(miInicializarCartao);

        miVersao.setText("Versão");
        menuConfiguracoesSmartCard.add(miVersao);

        miDesbloquearPIN.setText("Desbloquear PIN");
        menuConfiguracoesSmartCard.add(miDesbloquearPIN);

        miTrocarPUK.setText("Trocar PUK");
        menuConfiguracoesSmartCard.add(miTrocarPUK);

        miTrocarPIN.setText("Trocar PIN");
        menuConfiguracoesSmartCard.add(miTrocarPIN);

        menuSmartCard.add(menuConfiguracoesSmartCard);

        miVerificarDocumento.setText("Verificar Documento");
        menuSmartCard.add(miVerificarDocumento);

        miGravarDocumento.setText("Gravar Documento");
        menuSmartCard.add(miGravarDocumento);

        miRecuperarDocumento.setText("Recuperar Documento");
        menuSmartCard.add(miRecuperarDocumento);

        miDeletarDocumento.setText("Deletar Documento");
        menuSmartCard.add(miDeletarDocumento);

        mbMainWindow.add(menuSmartCard);

        setJMenuBar(mbMainWindow);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miFormularioCrlvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFormularioCrlvActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_miFormularioCrlvActionPerformed

    private void menuConectarLeitoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConectarLeitoraActionPerformed
        // TODO add your handling code here:
        //String setProperty = System.setProperty("sun.security.smartcardio.t0GetResponse", "false");
        JIFLeitora con = new JIFLeitora();
        ControllerLeitora conl = new ControllerLeitora(con);
        desktop.add(con);
        //con.setLocation(null);
        con.setVisible(true);
    }//GEN-LAST:event_menuConectarLeitoraActionPerformed

    private void miListarDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miListarDocumentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miListarDocumentosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    public JDesktopPane getDesktop() {
        return desktop;
    }

    public void setDesktop(JDesktopPane desktop) {
        this.desktop = desktop;
    }

    public JMenuBar getMbMainWindow() {
        return mbMainWindow;
    }

    public void setMbMainWindow(JMenuBar mbMainWindow) {
        this.mbMainWindow = mbMainWindow;
    }

    public JMenu getMenuAssinador() {
        return menuAssinador;
    }

    public void setMenuAssinador(JMenu menuAssinador) {
        this.menuAssinador = menuAssinador;
    }

    public JMenuItem getMenuConectarLeitora() {
        return menuConectarLeitora;
    }

    public void setMenuConectarLeitora(JMenuItem menuConectarLeitora) {
        this.menuConectarLeitora = menuConectarLeitora;
    }

    public JMenu getMenuConfiguracoesSmartCard() {
        return menuConfiguracoesSmartCard;
    }

    public void setMenuConfiguracoesSmartCard(JMenu menuConfiguracoesSmartCard) {
        this.menuConfiguracoesSmartCard = menuConfiguracoesSmartCard;
    }

    public JMenu getMenuCrlv() {
        return menuCrlv;
    }

    public void setMenuCrlv(JMenu menuCrlv) {
        this.menuCrlv = menuCrlv;
    }

    public JMenu getMenuLeitora() {
        return menuLeitora;
    }

    public void setMenuLeitora(JMenu menuLeitora) {
        this.menuLeitora = menuLeitora;
    }

    public JMenu getMenuSmartCard() {
        return menuSmartCard;
    }

    public void setMenuSmartCard(JMenu menuSmartCard) {
        this.menuSmartCard = menuSmartCard;
    }

    public JMenuItem getMiFormularioCrlv() {
        return miFormularioCrlv;
    }

    public void setMiFormularioCrlv(JMenuItem miFormularioCrlv) {
        this.miFormularioCrlv = miFormularioCrlv;
    }

    public JMenuItem getMiInicializarCartao() {
        return miInicializarCartao;
    }

    public void setMiInicializarCartao(JMenuItem miInicializarCartao) {
        this.miInicializarCartao = miInicializarCartao;
    }

    public JMenuItem getMiVersao() {
        return miVersao;
    }

    public void setMiVersao(JMenuItem miVersao) {
        this.miVersao = miVersao;
    }

    public JMenuItem getMiDesbloquearPIN() {
        return miDesbloquearPIN;
    }

    public void setMiDesbloquearPIN(JMenuItem miDesbloquearPIN) {
        this.miDesbloquearPIN = miDesbloquearPIN;
    }

    public JMenuItem getMiTrocarPIN() {
        return miTrocarPIN;
    }

    public void setMiTrocarPIN(JMenuItem miTrocarPIN) {
        this.miTrocarPIN = miTrocarPIN;
    }

    public JMenuItem getMiTrocarPUK() {
        return miTrocarPUK;
    }

    public void setMiTrocarPUK(JMenuItem miTrocarPUK) {
        this.miTrocarPUK = miTrocarPUK;
    }

    public JMenuItem getMiVerificarDocumento() {
        return miVerificarDocumento;
    }

    public void setMiVerificarDocumento(JMenuItem miVerificarDocumento) {
        this.miVerificarDocumento = miVerificarDocumento;
    }

    public JMenuItem getMiDeletarDocumento() {
        return miDeletarDocumento;
    }

    public void setMiDeletarDocumento(JMenuItem miDeletarDocumento) {
        this.miDeletarDocumento = miDeletarDocumento;
    }

    public JMenuItem getMiGravarDocumento() {
        return miGravarDocumento;
    }

    public void setMiGravarDocumento(JMenuItem miGravarDocumento) {
        this.miGravarDocumento = miGravarDocumento;
    }

    public JMenuItem getMiRecuperarDocumento() {
        return miRecuperarDocumento;
    }

    public void setMiRecuperarDocumento(JMenuItem miRecuperarDocumento) {
        this.miRecuperarDocumento = miRecuperarDocumento;
    }

    public JLabel getLblLsitec() {
        return lblLsitec;
    }

    public void setLblLsitec(JLabel lblLsitec) {
        this.lblLsitec = lblLsitec;
    }

    public JMenuItem getMiGerarXML() {
        return miGerarXML;
    }

    public void setMiGerarXML(JMenuItem miGerarXML) {
        this.miGerarXML = miGerarXML;
    }

    public JMenuItem getMiListarDocumentos() {
        return miListarDocumentos;
    }

    public void setMiListarDocumentos(JMenuItem miListarDocumentos) {
        this.miListarDocumentos = miListarDocumentos;
    }

    public JMenuItem getMiVizualizarDocumento() {
        return miVizualizarDocumento;
    }

    public void setMiVizualizarDocumento(JMenuItem miVizualizarDocumento) {
        this.miVizualizarDocumento = miVizualizarDocumento;
    }   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel lblLsitec;
    private javax.swing.JMenuBar mbMainWindow;
    private javax.swing.JMenu menuAssinador;
    private javax.swing.JMenuItem menuConectarLeitora;
    private javax.swing.JMenu menuConfiguracoesSmartCard;
    private javax.swing.JMenu menuCrlv;
    private javax.swing.JMenu menuLeitora;
    private javax.swing.JMenu menuSmartCard;
    private javax.swing.JMenuItem miDeletarDocumento;
    private javax.swing.JMenuItem miDesbloquearPIN;
    private javax.swing.JMenuItem miFormularioCrlv;
    private javax.swing.JMenuItem miGerarXML;
    private javax.swing.JMenuItem miGravarDocumento;
    private javax.swing.JMenuItem miInicializarCartao;
    private javax.swing.JMenuItem miListarDocumentos;
    private javax.swing.JMenuItem miRecuperarDocumento;
    private javax.swing.JMenuItem miTrocarPIN;
    private javax.swing.JMenuItem miTrocarPUK;
    private javax.swing.JMenuItem miVerificarDocumento;
    private javax.swing.JMenuItem miVersao;
    private javax.swing.JMenuItem miVizualizarDocumento;
    // End of variables declaration//GEN-END:variables
}