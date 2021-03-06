/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controller.ControllerDueno;
import Controller.ControllerMascota;
import Controller.ControllerUsuario;
import Controller.ControllerVeterinario;

/**
 *
 * @author nicol
 */
public class frmVentanaPrincipal extends javax.swing.JFrame {
    
    
     public void permisoAdministradores(String tipoUsuario){
   
        if("ADMINISTRADOR".equals(tipoUsuario)){
        btnRegistroCitas.setVisible(false);   
        }
        
    }
     
     public void permisoAsistentes(String tipoUsuario){
     
         if ("ASISTENTE".equals(tipoUsuario)) {
            btnVeterinario.setVisible(false);
            btnUsuario.setVisible(false);
         }
         
     }
    
    

    /**
     * Creates new form frmVentanaPrincipal
     */
    public frmVentanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        setTitle("Sistem de registro de una veterinaria");
       /* lblIdUsuario.setText();
        lblNombreUsuario.setText();*/
       // permisoAdministradores(tipoUsuario);
       
    }

   
    
    /*
    public void permisoUsuario(String tipoUsuario){
    
        if ("ASISTENTE".equals(tipoUsuario)) {
            btnUsuarios.setVisible(false);
            btnVehiculos.setVisible(false);
        }
    
    }
    */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        lblIdUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        btnSalir = new javax.swing.JMenuItem();
        menuCatalogoDeDatos = new javax.swing.JMenu();
        btnUsuario = new javax.swing.JMenuItem();
        btnDueno = new javax.swing.JMenuItem();
        btnVeterinario = new javax.swing.JMenuItem();
        btnMascota = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        btnRegistroCitas = new javax.swing.JMenuItem();
        btnAnularCitas = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        btnCitasFecha = new javax.swing.JMenuItem();
        btnCitasDueno = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        btnCreditos = new javax.swing.JMenuItem();
        btnManual = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblIdUsuario.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblIdUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblIdUsuario.setText("Id Usuario");

        lblTipoUsuario.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTipoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoUsuario.setText("Tipo de Usuario");

        lblNombreUsuario.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("Nombre de Usuario");

        desktopPane.setLayer(lblIdUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(lblTipoUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(lblNombreUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desktopPaneLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(desktopPaneLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(desktopPaneLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lblTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(697, Short.MAX_VALUE))
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblIdUsuario)
                .addGap(18, 18, 18)
                .addComponent(lblNombreUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTipoUsuario)
                .addContainerGap(276, Short.MAX_VALUE))
        );

        menuArchivo.setText("Archivo");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(btnSalir);

        jMenuBar1.add(menuArchivo);

        menuCatalogoDeDatos.setText("Catalogo de datos");

        btnUsuario.setText("Usuario");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        menuCatalogoDeDatos.add(btnUsuario);

        btnDueno.setText("Due??o");
        btnDueno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuenoActionPerformed(evt);
            }
        });
        menuCatalogoDeDatos.add(btnDueno);

        btnVeterinario.setText("Veterinario");
        btnVeterinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVeterinarioActionPerformed(evt);
            }
        });
        menuCatalogoDeDatos.add(btnVeterinario);

        btnMascota.setText("Mascota");
        menuCatalogoDeDatos.add(btnMascota);

        jMenuBar1.add(menuCatalogoDeDatos);

        menuAyuda.setText("Gesti??n de Procesos");

        btnRegistroCitas.setText("Registro de Citas");
        menuAyuda.add(btnRegistroCitas);

        btnAnularCitas.setText("Anular Citas");
        menuAyuda.add(btnAnularCitas);

        jMenuBar1.add(menuAyuda);

        menuReportes.setText("Reportes");

        btnCitasFecha.setText("Citas por Fecha");
        btnCitasFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasFechaActionPerformed(evt);
            }
        });
        menuReportes.add(btnCitasFecha);

        btnCitasDueno.setText("Citas por Due??o");
        btnCitasDueno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasDuenoActionPerformed(evt);
            }
        });
        menuReportes.add(btnCitasDueno);

        jMenuBar1.add(menuReportes);

        jMenu1.setText("Acerca de");

        btnCreditos.setText("Creditos");
        jMenu1.add(btnCreditos);

        btnManual.setText("Manual de Usuario");
        jMenu1.add(btnManual);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        frmUsuario frmU = new frmUsuario();
        desktopPane.add(frmU);
        ControllerUsuario con = new ControllerUsuario(frmU);
        con.iniciar();
        frmU.toFront();
        setLocation(desktopPane.getWidth() / 2 - frmU.getWidth() / 2, desktopPane.getHeight() / 2 - frmU.getHeight() / 2);
        frmU.setVisible(true);

    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnDuenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuenoActionPerformed
        frmDueno frmD = new frmDueno();
        desktopPane.add(frmD);
        ControllerDueno con = new ControllerDueno(frmD);
        con.iniciar();
        frmD.toFront();
        setLocation(desktopPane.getWidth() / 2 - frmD.getWidth() / 2, desktopPane.getHeight() / 2 - frmD.getHeight() / 2);
        frmD.setVisible(true);
    }//GEN-LAST:event_btnDuenoActionPerformed

    private void btnVeterinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeterinarioActionPerformed
        frmVeterinario frmV = new frmVeterinario();
        desktopPane.add(frmV);
        ControllerVeterinario con = new ControllerVeterinario(frmV);
        con.iniciar();
        frmV.toFront();
        setLocation(desktopPane.getWidth() / 2 - frmV.getWidth() / 2, desktopPane.getHeight() / 2 - frmV.getHeight() / 2);
        frmV.setVisible(true);

    }//GEN-LAST:event_btnVeterinarioActionPerformed

    private void btnCitasFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCitasFechaActionPerformed

    private void btnCitasDuenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasDuenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCitasDuenoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(frmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAnularCitas;
    private javax.swing.JMenuItem btnCitasDueno;
    private javax.swing.JMenuItem btnCitasFecha;
    private javax.swing.JMenuItem btnCreditos;
    private javax.swing.JMenuItem btnDueno;
    private javax.swing.JMenuItem btnManual;
    private javax.swing.JMenuItem btnMascota;
    private javax.swing.JMenuItem btnRegistroCitas;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JMenuItem btnUsuario;
    private javax.swing.JMenuItem btnVeterinario;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JLabel lblIdUsuario;
    public static javax.swing.JLabel lblNombreUsuario;
    public static javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuCatalogoDeDatos;
    private javax.swing.JMenu menuReportes;
    // End of variables declaration//GEN-END:variables
}
