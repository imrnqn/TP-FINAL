/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfnutricionista.Vistas;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import pfnutricionista.AccesoADatos.ComidaData;
import pfnutricionista.AccesoADatos.DietaData;
import pfnutricionista.AccesoADatos.PacienteData;
import pfnutricionista.entidades.Horario;
import pfnutricionista.entidades.Paciente;
import pfnutricionista.entidades.Dieta;

/**
 *
 * @author ivanm
 */
public class abmDietas extends javax.swing.JInternalFrame {

    /**
     * Creates new form abmPacientes
     */
    public abmDietas() {
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
        jtNombre = new javax.swing.JTextField();
        jbAlta = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBaja = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtPaciente = new javax.swing.JTextField();
        jtFechaInicial = new javax.swing.JTextField();
        jtFechaFinal = new javax.swing.JTextField();
        jtPesoInicial = new javax.swing.JTextField();
        jtPesoFinal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ficha de Dietas");
        setToolTipText("");
        setDoubleBuffered(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setText("Peso Inicial");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 0));
        jLabel4.setText("Paciente");

        jtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreActionPerformed(evt);
            }
        });
        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombreKeyTyped(evt);
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
        jLabel7.setText("PLAN DE DIETA");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 153, 0));
        jLabel5.setText("Fecha de Inicio");

        jtPaciente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPacienteActionPerformed(evt);
            }
        });

        jtFechaInicial.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jtFechaFinal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jtPesoFinal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 153, 0));
        jLabel6.setText("Fecha de Fin");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 153, 0));
        jLabel8.setText("Peso Final");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtPaciente, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtPesoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtFechaFinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtPesoFinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtPesoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtPesoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        Dieta dieta = new Dieta();
        DietaData dietaData = new DietaData();
        if (jtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Error. El campo Nombre no puede estar vacio.");
            jtNombre.requestFocus();
        } else {
                    dieta.setNombre(jtNombre.getText());
                    //dieta.setPacinte(jtaDetalle.getText());
                    dieta.setFechaInicial(LocalDate.parse(jtFechaInicial.getText()));
                    dieta.setFechaFinal(LocalDate.parse(jtFechaFinal.getText()));
                    dieta.setPesoInicial(Double.valueOf(jtPesoInicial.getText()));
                    dieta.setPesoFinal(Double.valueOf(jtPesoFinal.getText()));
                    dietaData.modificarDieta(dieta);
                    jtNombre.setText(null); jtPaciente.setText(null); jtFechaInicial.setText(null); 
                    jtFechaFinal.setText(null); jtPesoInicial.setText(null); jtPesoFinal.setText(null);
                    jtNombre.requestFocus();
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        Dieta dieta = new Dieta();
        DietaData dietaData = new DietaData();
        if (jtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Error. Ingrese el nombre de una dieta.");
            jtNombre.requestFocus();
        } else {
            dieta = dietaData.buscarDieta(jtNombre.getText());
            if (dieta==null){
                jtNombre.setText(null); jtPaciente.setText(null); jtFechaInicial.setText(null); 
                jtFechaFinal.setText(null); jtPesoInicial.setText(null); jtPesoFinal.setText(null);
                jtNombre.requestFocus();
            } else {
                jtNombre.setText(dieta.getNombre());
                jtPaciente .setText;
                jtFechaInicial.setText(String.valueOf(dieta.getFechaInicial()));
                jtFechaFinal.setText(String.valueOf(dieta.getPesoFinal()));
                jtPesoInicial.setText(Double.toString(dieta.getPesoInicial()));
                jtPesoFinal.setText(Double.toString(dieta.getPesoFinal()));
            }
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaActionPerformed
        Dieta dieta = new Dieta();
        DietaData dietaData = new DietaData();
        if (jtCalorias.getText().equals("") && jtNombre.getText().equals("") && jtaDetalle.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Error. Los campos no pueden estar vacio.");
            jtNombre.requestFocus();
        }
        comida.setNombre(jtNombre.getText());
        comida.setCantCalorias(Integer.parseInt(jtCalorias.getText()));
        comida.setDetalle(jtaDetalle.getText());
        comida.setHorario((String) jcbHorario.getSelectedItem());
        comidaData.guardarComida(comida);
        jtaDetalle.setText(null); jtNombre.setText(null); jtCalorias.setText(" "); jcbHorario.setSelectedIndex(-1);
        jtNombre.requestFocus();
        
    }//GEN-LAST:event_jbAltaActionPerformed

    private void jbBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBajaActionPerformed
        Dieta dieta = new Dieta();
        DietaData dietaData = new DietaData();
        if (jtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Error. El campo Nombre no puede estar vacio.");
            jtNombre.requestFocus();
        } else {
            dieta = dietaData.buscarDieta(jtNombre.getText());
            dietaData.eliminarDieta(dieta.getIdDieta());
            jtNombre.setText(null); jtPaciente.setText(null); jtFechaInicial.setText(null); jtFechaFinal.setText(null); 
            jtPesoInicial.setText(null); jtPesoFinal.setText(null);
        }
    }//GEN-LAST:event_jbBajaActionPerformed

    
    private void jtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyTyped
        jtNombre.setText (jtNombre.getText().toUpperCase());
    }//GEN-LAST:event_jtNombreKeyTyped

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        
    }//GEN-LAST:event_jtNombreActionPerformed

    private void jtPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPacienteActionPerformed
        jtPaciente.setText (jtPaciente.getText().toUpperCase());
    }//GEN-LAST:event_jtPacienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jbAlta;
    private javax.swing.JButton jbBaja;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JTextField jtFechaFinal;
    private javax.swing.JTextField jtFechaInicial;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPaciente;
    private javax.swing.JTextField jtPesoFinal;
    private javax.swing.JTextField jtPesoInicial;
    // End of variables declaration//GEN-END:variables
}
