/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfnutricionista.Vistas;

import javax.swing.JOptionPane;
import pfnutricionista.AccesoADatos.PacienteData;
import pfnutricionista.entidades.Paciente;

/**
 *
 * @author ivanm
 */
public class abmPacientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form abmPacientes
     */
    public abmPacientes() {
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtDni = new javax.swing.JTextField();
        jtDomicilio = new javax.swing.JTextField();
        jtTelefono = new javax.swing.JTextField();
        jbAlta = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBaja = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ficha de Pacientes");
        setToolTipText("");
        setDoubleBuffered(true);
        setMaximumSize(new java.awt.Dimension(640, 499));
        setNormalBounds(new java.awt.Rectangle(0, 0, 640, 499));
        setOpaque(true);
        setRequestFocusEnabled(false);
        setVisible(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setText("Nombres");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 0));
        jLabel4.setText("DNI");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 153, 0));
        jLabel5.setText("Domicilio");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 153, 0));
        jLabel6.setText("Telefono");

        jtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombreKeyTyped(evt);
            }
        });

        jtApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtApellidoActionPerformed(evt);
            }
        });
        jtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtApellidoKeyTyped(evt);
            }
        });

        jtDni.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDniKeyTyped(evt);
            }
        });

        jtDomicilio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtDomicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDomicilioKeyTyped(evt);
            }
        });

        jtTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtTelefonoKeyTyped(evt);
            }
        });

        jbAlta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbAlta.setText("Alta");
        jbAlta.setToolTipText("");
        jbAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAltaActionPerformed(evt);
            }
        });

        jbBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbModificar.setText("Modificar");
        jbModificar.setActionCommand("jbModificar");
        jbModificar.setAutoscrolls(true);
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbBaja.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbBaja.setText("Baja");
        jbBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBajaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PACIENTE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbAlta, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtNombre)
                                .addComponent(jtApellido)
                                .addComponent(jtDomicilio)
                                .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jbAlta.getAccessibleContext().setAccessibleDescription("Alta del paciente según datos cargados...");
        jbBuscar.getAccessibleContext().setAccessibleDescription("Buscar por DNI...");
        jbModificar.getAccessibleContext().setAccessibleDescription("Guardar datos modificados del paciente...");
        jbBaja.getAccessibleContext().setAccessibleDescription("Baja del paciente en el sistema...");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtApellidoActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        Paciente paciente = new Paciente();
        PacienteData pacienteData = new PacienteData();
        if (jtDni.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Error. El campo DNI no puede estar vacio.");
            jtDni.requestFocus();
        }
        paciente.setApellido(jtApellido.getText());
        paciente.setNombre(jtNombre.getText());
        paciente.setDni(Integer.parseInt(jtDni.getText()));
        paciente.setDomicilio(jtDomicilio.getText());
        paciente.setTelefono(jtTelefono.getText());
        pacienteData.modificarPaciente(paciente);
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        Paciente paciente = new Paciente();
        PacienteData pacienteData = new PacienteData();
        if (jtDni.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Error. El campo DNI no puede estar vacio.");
            jtDni.requestFocus();
            
        } else {
            paciente = pacienteData.buscarPaciente(Integer.parseInt(jtDni.getText()));
            if (paciente==null){
                jtApellido.setText(null); jtNombre.setText(null); jtDni.setText(null); jtDomicilio.setText(null); jtTelefono.setText(null);
                jtNombre.requestFocus();
            } else {
                jtApellido.setText(paciente.getApellido());
                jtNombre.setText(paciente.getNombre());
                jtDni.setText(Integer.toString(paciente.getDni()));
                jtDomicilio.setText(paciente.getDomicilio());
                jtTelefono.setText((paciente.getTelefono()));
            }
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaActionPerformed
        Paciente paciente = new Paciente();
        PacienteData pacienteData = new PacienteData();
        if (jtDni.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Error. El campo DNI no puede estar vacio.");
        }
        paciente.setApellido(jtApellido.getText());
        paciente.setNombre(jtNombre.getText());
        paciente.setDni(Integer.parseInt(jtDni.getText()));
        paciente.setDomicilio(jtDomicilio.getText());
        paciente.setTelefono(jtTelefono.getText());
        pacienteData.guardarPaciente(paciente);
    }//GEN-LAST:event_jbAltaActionPerformed

    private void jbBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBajaActionPerformed
        Paciente paciente = new Paciente();
        PacienteData pacienteData = new PacienteData();
        if (jtDni.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Error. El campo DNI no puede estar vacio.");
        }
        paciente = pacienteData.buscarPaciente(Integer.parseInt(jtDni.getText()));
        pacienteData.eliminarPaciente(paciente.getIdPaciente());
    }//GEN-LAST:event_jbBajaActionPerformed

    private void jtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDniKeyTyped
        
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros){
            evt.consume();
        }
        if(jtDni.getText().length() >= 8){
            evt.consume();
        }
    }//GEN-LAST:event_jtDniKeyTyped

    private void jtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyTyped
        jtNombre.setText (jtNombre.getText().toUpperCase());
    }//GEN-LAST:event_jtNombreKeyTyped

    private void jtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApellidoKeyTyped
        jtApellido.setText (jtApellido.getText().toUpperCase());
    }//GEN-LAST:event_jtApellidoKeyTyped

    private void jtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTelefonoKeyTyped
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57 || key == 45;
        if (!numeros){
            evt.consume();
        }
    }//GEN-LAST:event_jtTelefonoKeyTyped

    private void jtDomicilioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDomicilioKeyTyped
        jtDomicilio.setText (jtDomicilio.getText().toUpperCase());
    }//GEN-LAST:event_jtDomicilioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbAlta;
    private javax.swing.JButton jbBaja;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtDomicilio;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtTelefono;
    // End of variables declaration//GEN-END:variables
}
