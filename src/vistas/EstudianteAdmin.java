// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package vistas;

public class EstudianteAdmin extends javax.swing.JFrame {

    /**
     * @return the bontonAtrasEst
     */
    public javax.swing.JButton getBontonAtrasEst() {
        return bontonAtrasEst;
    }

    /**
     * @return the bontonCancelarEst
     */
    public javax.swing.JButton getBontonCancelarEst() {
        return bontonCancelarEst;
    }

    /**
     * @return the botonAgregarEst
     */
    public javax.swing.JButton getBotonAgregarEst() {
        return botonAgregarEst;
    }

    /**
     * @return the botonBuscarEst
     */
    public javax.swing.JButton getBotonBuscarEst() {
        return botonBuscarEst;
    }

    /**
     * @return the botonEliminarEst
     */
    public javax.swing.JButton getBotonEliminarEst() {
        return botonEliminarEst;
    }

    /**
     * @return the botonGuardarEst
     */
    public javax.swing.JButton getBotonGuardarEst() {
        return botonGuardarEst;
    }

    /**
     * @return the botonModificarEst
     */
    public javax.swing.JButton getBotonModificarEst() {
        return botonModificarEst;
    }

    /**
     * @return the campoApeEst
     */
    public javax.swing.JTextField getCampoApeEst() {
        return campoApeEst;
    }

    /**
     * @return the campoCedBusEst
     */
    public javax.swing.JTextField getCampoCedBusEst() {
        return campoCedBusEst;
    }

    /**
     * @return the campoCedEst
     */
    public javax.swing.JTextField getCampoCedEst() {
        return campoCedEst;
    }

    /**
     * @return the campoCorEst
     */
    public javax.swing.JTextField getCampoCorEst() {
        return campoCorEst;
    }

    /**
     * @return the campoDirEst
     */
    public javax.swing.JTextField getCampoDirEst() {
        return campoDirEst;
    }

    /**
     * @return the campoNomEst
     */
    public javax.swing.JTextField getCampoNomEst() {
        return campoNomEst;
    }

    /**
     * @return the campoTelEst
     */
    public javax.swing.JTextField getCampoTelEst() {
        return campoTelEst;
    }

    /**
     * @return the comboCarEst
     */
    public javax.swing.JComboBox<String> getComboCarEst() {
        return comboCarEst;
    }

    /**
     * @return the comboStaEst
     */
    public javax.swing.JComboBox<String> getComboStaEst() {
        return comboStaEst;
    }

    public EstudianteAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgEstudiante = new javax.swing.JPanel();
        tituloEst = new javax.swing.JLabel();
        textCedBusEst = new javax.swing.JLabel();
        campoCedBusEst = new javax.swing.JTextField();
        botonBuscarEst = new javax.swing.JButton();
        botonAgregarEst = new javax.swing.JButton();
        textCedEst = new javax.swing.JLabel();
        campoCedEst = new javax.swing.JTextField();
        textNomEst = new javax.swing.JLabel();
        campoNomEst = new javax.swing.JTextField();
        textApeEst = new javax.swing.JLabel();
        campoApeEst = new javax.swing.JTextField();
        textDirEst = new javax.swing.JLabel();
        campoDirEst = new javax.swing.JTextField();
        textCorEst = new javax.swing.JLabel();
        campoCorEst = new javax.swing.JTextField();
        textTelEst = new javax.swing.JLabel();
        campoTelEst = new javax.swing.JTextField();
        textCarEst = new javax.swing.JLabel();
        comboCarEst = new javax.swing.JComboBox<>();
        textStaEst = new javax.swing.JLabel();
        comboStaEst = new javax.swing.JComboBox<>();
        bontonAtrasEst = new javax.swing.JButton();
        bontonCancelarEst = new javax.swing.JButton();
        botonEliminarEst = new javax.swing.JButton();
        botonModificarEst = new javax.swing.JButton();
        botonGuardarEst = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estudiante");
        setResizable(false);

        bgEstudiante.setBackground(new java.awt.Color(41, 144, 159));

        tituloEst.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        tituloEst.setForeground(new java.awt.Color(255, 255, 255));
        tituloEst.setText("GESTIONAR ESTUDIANTE");

        textCedBusEst.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textCedBusEst.setForeground(new java.awt.Color(255, 255, 255));
        textCedBusEst.setText("Cédula");

        campoCedBusEst.setEditable(false);
        campoCedBusEst.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        botonBuscarEst.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonBuscarEst.setText("BUSCAR");
        botonBuscarEst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botonAgregarEst.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAgregarEst.setText("AGREGAR");
        botonAgregarEst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        textCedEst.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textCedEst.setForeground(new java.awt.Color(255, 255, 255));
        textCedEst.setText("Cédula");

        campoCedEst.setEditable(false);
        campoCedEst.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textNomEst.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textNomEst.setForeground(new java.awt.Color(255, 255, 255));
        textNomEst.setText("Nombre");

        campoNomEst.setEditable(false);
        campoNomEst.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textApeEst.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textApeEst.setForeground(new java.awt.Color(255, 255, 255));
        textApeEst.setText("Apellido");

        campoApeEst.setEditable(false);
        campoApeEst.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoApeEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoApeEstActionPerformed(evt);
            }
        });

        textDirEst.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textDirEst.setForeground(new java.awt.Color(255, 255, 255));
        textDirEst.setText("Dirección");

        campoDirEst.setEditable(false);
        campoDirEst.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textCorEst.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textCorEst.setForeground(new java.awt.Color(255, 255, 255));
        textCorEst.setText("Correo");

        campoCorEst.setEditable(false);
        campoCorEst.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textTelEst.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textTelEst.setForeground(new java.awt.Color(255, 255, 255));
        textTelEst.setText("Teléfono");

        campoTelEst.setEditable(false);
        campoTelEst.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textCarEst.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textCarEst.setForeground(new java.awt.Color(255, 255, 255));
        textCarEst.setText("Carrera");

        textStaEst.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textStaEst.setForeground(new java.awt.Color(255, 255, 255));
        textStaEst.setText("Estatus");

        bontonAtrasEst.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonAtrasEst.setText("ATRAS");
        bontonAtrasEst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonAtrasEst.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonAtrasEst.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonAtrasEst.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonAtrasEst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonAtrasEstMouseClicked(evt);
            }
        });
        bontonAtrasEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonAtrasEstActionPerformed(evt);
            }
        });

        bontonCancelarEst.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonCancelarEst.setText("CANCELAR");
        bontonCancelarEst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonCancelarEst.setEnabled(false);
        bontonCancelarEst.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonCancelarEst.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonCancelarEst.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonCancelarEst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonCancelarEstMouseClicked(evt);
            }
        });
        bontonCancelarEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonCancelarEstActionPerformed(evt);
            }
        });

        botonEliminarEst.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEliminarEst.setText("ELIMINAR");
        botonEliminarEst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarEst.setEnabled(false);

        botonModificarEst.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonModificarEst.setText("MODIFICAR");
        botonModificarEst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonModificarEst.setEnabled(false);

        botonGuardarEst.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonGuardarEst.setText("GUARDAR");
        botonGuardarEst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardarEst.setEnabled(false);

        javax.swing.GroupLayout bgEstudianteLayout = new javax.swing.GroupLayout(bgEstudiante);
        bgEstudiante.setLayout(bgEstudianteLayout);
        bgEstudianteLayout.setHorizontalGroup(
            bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgEstudianteLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgEstudianteLayout.createSequentialGroup()
                        .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bgEstudianteLayout.createSequentialGroup()
                                .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgEstudianteLayout.createSequentialGroup()
                                        .addComponent(textCedEst)
                                        .addGap(40, 40, 40)
                                        .addComponent(campoCedEst, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(71, 71, 71)
                                        .addComponent(textNomEst))
                                    .addGroup(bgEstudianteLayout.createSequentialGroup()
                                        .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(bgEstudianteLayout.createSequentialGroup()
                                                .addComponent(textApeEst)
                                                .addGap(31, 31, 31)
                                                .addComponent(campoApeEst, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(bgEstudianteLayout.createSequentialGroup()
                                                .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textCorEst)
                                                    .addComponent(textCarEst))
                                                .addGap(34, 34, 34)
                                                .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(comboCarEst, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(campoCorEst, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(71, 71, 71)
                                        .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textTelEst)
                                            .addComponent(textDirEst)
                                            .addComponent(textStaEst))))
                                .addGap(39, 39, 39)
                                .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoDirEst, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoNomEst, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoTelEst, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboStaEst, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(bgEstudianteLayout.createSequentialGroup()
                                .addComponent(bontonAtrasEst, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bontonCancelarEst, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonEliminarEst)
                                .addGap(18, 18, 18)
                                .addComponent(botonModificarEst)
                                .addGap(18, 18, 18)
                                .addComponent(botonGuardarEst)))
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addGroup(bgEstudianteLayout.createSequentialGroup()
                        .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgEstudianteLayout.createSequentialGroup()
                                .addComponent(textCedBusEst)
                                .addGap(28, 28, 28)
                                .addComponent(campoCedBusEst, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonBuscarEst)
                                .addGap(18, 18, 18)
                                .addComponent(botonAgregarEst))
                            .addGroup(bgEstudianteLayout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addComponent(tituloEst)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        bgEstudianteLayout.setVerticalGroup(
            bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgEstudianteLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tituloEst)
                .addGap(33, 33, 33)
                .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCedBusEst)
                    .addComponent(campoCedBusEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarEst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregarEst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCedEst)
                    .addComponent(campoCedEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNomEst)
                    .addComponent(campoNomEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textApeEst, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoApeEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDirEst)
                    .addComponent(campoDirEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCorEst)
                    .addComponent(campoCorEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTelEst)
                    .addComponent(campoTelEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCarEst)
                    .addComponent(comboCarEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textStaEst)
                    .addComponent(comboStaEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(bgEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardarEst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonModificarEst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarEst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bontonAtrasEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bontonCancelarEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bontonAtrasEstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonAtrasEstMouseClicked

    }//GEN-LAST:event_bontonAtrasEstMouseClicked

    private void bontonAtrasEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonAtrasEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonAtrasEstActionPerformed

    private void bontonCancelarEstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonCancelarEstMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarEstMouseClicked

    private void bontonCancelarEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonCancelarEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarEstActionPerformed

    private void campoApeEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoApeEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoApeEstActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstudianteAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgEstudiante;
    private javax.swing.JButton bontonAtrasEst;
    private javax.swing.JButton bontonCancelarEst;
    private javax.swing.JButton botonAgregarEst;
    private javax.swing.JButton botonBuscarEst;
    private javax.swing.JButton botonEliminarEst;
    private javax.swing.JButton botonGuardarEst;
    private javax.swing.JButton botonModificarEst;
    private javax.swing.JTextField campoApeEst;
    private javax.swing.JTextField campoCedBusEst;
    private javax.swing.JTextField campoCedEst;
    private javax.swing.JTextField campoCorEst;
    private javax.swing.JTextField campoDirEst;
    private javax.swing.JTextField campoNomEst;
    private javax.swing.JTextField campoTelEst;
    private javax.swing.JComboBox<String> comboCarEst;
    private javax.swing.JComboBox<String> comboStaEst;
    private javax.swing.JLabel textApeEst;
    private javax.swing.JLabel textCarEst;
    private javax.swing.JLabel textCedBusEst;
    private javax.swing.JLabel textCedEst;
    private javax.swing.JLabel textCorEst;
    private javax.swing.JLabel textDirEst;
    private javax.swing.JLabel textNomEst;
    private javax.swing.JLabel textStaEst;
    private javax.swing.JLabel textTelEst;
    private javax.swing.JLabel tituloEst;
    // End of variables declaration//GEN-END:variables
}
