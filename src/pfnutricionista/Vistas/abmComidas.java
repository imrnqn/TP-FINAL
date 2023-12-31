/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfnutricionista.Vistas;

import javax.swing.JOptionPane;
import pfnutricionista.AccesoADatos.ComidaData;
import pfnutricionista.AccesoADatos.PacienteData;
import pfnutricionista.entidades.Comida;
import pfnutricionista.entidades.Horario;
import pfnutricionista.entidades.Paciente;
import static java.awt.GridBagConstraints.BOTH;

/**
 *
 * @author ivanm
 */
public class abmComidas extends javax.swing.JInternalFrame {

    /**
     * Creates new form abmPacientes
     */
    public abmComidas() {
        initComponents();
        llenarJcbHorario();
        
        
       
        
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
        jtCalorias = new javax.swing.JTextField();
        jbAlta = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBaja = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbHorario = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDetalle = new javax.swing.JTextArea();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ficha de Comidas");
        setToolTipText("");
        setDoubleBuffered(true);
        setMaximumSize(new java.awt.Dimension(640, 556));
        setNormalBounds(new java.awt.Rectangle(80, 100, 122, 0));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setText("Detalle");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 0));
        jLabel4.setText("Calorias");

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

        jtCalorias.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtCalorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtCaloriasKeyTyped(evt);
            }
        });

        jbAlta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbAlta.setForeground(new java.awt.Color(51, 153, 0));
        jbAlta.setText("Alta");
        jbAlta.setToolTipText("");
        jbAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAltaActionPerformed(evt);
            }
        });

        jbBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbBuscar.setForeground(new java.awt.Color(51, 153, 0));
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbModificar.setForeground(new java.awt.Color(51, 153, 0));
        jbModificar.setText("Modificar");
        jbModificar.setActionCommand("jbModificar");
        jbModificar.setAutoscrolls(true);
        jbModificar.setEnabled(false);
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbBaja.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbBaja.setForeground(new java.awt.Color(51, 153, 0));
        jbBaja.setText("Baja");
        jbBaja.setEnabled(false);
        jbBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBajaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("COMIDA");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 153, 0));
        jLabel5.setText("Horario");

        jcbHorario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcbHorario.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jcbHorarioComponentAdded(evt);
            }
        });

        jtaDetalle.setColumns(20);
        jtaDetalle.setRows(5);
        jtaDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtaDetalleKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jtaDetalle);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(189, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        Comida comida = new Comida();
        ComidaData comidaData = new ComidaData();
        if (jtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Error. El campo Nombre no puede estar vacio.");
            jtNombre.requestFocus();
        }else{
            if (jtCalorias.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Error. El campo Calorias no puede estar vacio.");
                jtCalorias.requestFocus();
            } else {
               if (jcbHorario.getSelectedItem().equals("")) {
                    JOptionPane.showMessageDialog(null, "Error. El campo Horario no puede estar vacio.");
                    jcbHorario.requestFocus();
               } else {
                    comida.setNombre(jtNombre.getText());
                    comida.setDetalle(jtaDetalle.getText());
                    comida.setHorario((String) jcbHorario.getSelectedItem());
                    comida.setCantCalorias(Integer.parseInt(jtCalorias.getText()));
                    comidaData.modificarComida(comida);
                    jtaDetalle.setText(null); jtNombre.setText(null); jtCalorias.setText(null); jcbHorario.setSelectedIndex(-1);
                }
            }
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        Comida comida = new Comida();
        ComidaData comidaData = new ComidaData();
        if (jtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Error. Ingrese el nombre de una comida.");
            jtNombre.requestFocus();
        } else {
            comida = comidaData.buscarComida(jtNombre.getText());
            if (comida==null){
                jtaDetalle.setText(null); jtNombre.setText(null); jtCalorias.setText(" "); jcbHorario.setSelectedIndex(-1);
                jtNombre.requestFocus();
            } else {
                jtaDetalle.setText(comida.getDetalle());
                jtNombre.setText(comida.getNombre());
                jtCalorias.setText(Integer.toString(comida.getCantCalorias()));
                jcbHorario.setSelectedItem(comida.getHorario());
                jbBaja.setEnabled(true);
                jbModificar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaActionPerformed
        Comida comida = new Comida();
        ComidaData comidaData = new ComidaData();
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
        Comida comida = new Comida();
        ComidaData comidaData = new ComidaData();
        if (jtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Error. El campo Nombre no puede estar vacio.");
            jtNombre.requestFocus();
        } else {
            comida = comidaData.buscarComida(jtNombre.getText());
            comidaData.eliminarComida(comida.getIdComida());
            jtaDetalle.setText(null); jtNombre.setText(null); jtCalorias.setText(null); jcbHorario.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_jbBajaActionPerformed

    private void llenarJcbHorario(){
        for (Horario r :Horario.values()) {
            jcbHorario.addItem(r.toString());
            jcbHorario.setSelectedIndex(-1);
        }
    }    
    
    
    private void jtCaloriasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCaloriasKeyTyped
        
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros){
            evt.consume();
        }
        if(jtCalorias.getText().length() >= 4){
            evt.consume();
        }
    }//GEN-LAST:event_jtCaloriasKeyTyped

    private void jtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyTyped
        jtNombre.setText (jtNombre.getText().toUpperCase());
    }//GEN-LAST:event_jtNombreKeyTyped

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreActionPerformed

    private void jcbHorarioComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jcbHorarioComponentAdded
       
    }//GEN-LAST:event_jcbHorarioComponentAdded

    private void jtaDetalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaDetalleKeyTyped
        jtaDetalle.setText (jtaDetalle.getText().toUpperCase());
    }//GEN-LAST:event_jtaDetalleKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlta;
    private javax.swing.JButton jbBaja;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JComboBox<String> jcbHorario;
    private javax.swing.JTextField jtCalorias;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextArea jtaDetalle;
    // End of variables declaration//GEN-END:variables
}
