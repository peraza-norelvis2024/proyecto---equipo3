// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package vistas;

public class CarreraAdmin extends javax.swing.JFrame {

    /**
     * @return the bontonAtrasCar
     */
    public javax.swing.JButton getBontonAtrasCar() {
        return bontonAtrasCar;
    }

    /**
     * @return the bontonCancelarCar
     */
    public javax.swing.JButton getBontonCancelarCar() {
        return bontonCancelarCar;
    }

    /**
     * @return the botonAgregarCar
     */
    public javax.swing.JButton getBotonAgregarCar() {
        return botonAgregarCar;
    }

    /**
     * @return the botonBuscarCar
     */
    public javax.swing.JButton getBotonBuscarCar() {
        return botonBuscarCar;
    }

    /**
     * @return the botonEliminarCar
     */
    public javax.swing.JButton getBotonEliminarCar() {
        return botonEliminarCar;
    }

    /**
     * @return the botonGuardarCar
     */
    public javax.swing.JButton getBotonGuardarCar() {
        return botonGuardarCar;
    }

    /**
     * @return the botonModificarCar
     */
    public javax.swing.JButton getBotonModificarCar() {
        return botonModificarCar;
    }

    /**
     * @return the campoDesCar
     */
    public javax.swing.JTextField getCampoDesCar() {
        return campoDesCar;
    }

    /**
     * @return the campoNomCar
     */
    public javax.swing.JTextField getCampoNomCar() {
        return campoNomCar;
    }

    /**
     * @return the comboDecCar
     */
    public javax.swing.JComboBox<String> getComboDecCar() {
        return comboDecCar;
    }

    /**
     * @return the comboNomBusCar
     */
    public javax.swing.JComboBox<String> getComboNomBusCar() {
        return comboNomBusCar;
    }

    /**
     * @return the comboStaCar
     */
    public javax.swing.JComboBox<String> getComboStaCar() {
        return comboStaCar;
    }

    public CarreraAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCarrera = new javax.swing.JPanel();
        tituloCar = new javax.swing.JLabel();
        textNomBusCar = new javax.swing.JLabel();
        comboNomBusCar = new javax.swing.JComboBox<>();
        botonBuscarCar = new javax.swing.JButton();
        botonAgregarCar = new javax.swing.JButton();
        textNomCar = new javax.swing.JLabel();
        campoNomCar = new javax.swing.JTextField();
        textDesCar = new javax.swing.JLabel();
        campoDesCar = new javax.swing.JTextField();
        textDecCar = new javax.swing.JLabel();
        comboDecCar = new javax.swing.JComboBox<>();
        textStaCar = new javax.swing.JLabel();
        comboStaCar = new javax.swing.JComboBox<>();
        bontonAtrasCar = new javax.swing.JButton();
        bontonCancelarCar = new javax.swing.JButton();
        botonEliminarCar = new javax.swing.JButton();
        botonModificarCar = new javax.swing.JButton();
        botonGuardarCar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carrera");
        setResizable(false);

        bgCarrera.setBackground(new java.awt.Color(41, 144, 159));

        tituloCar.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        tituloCar.setForeground(new java.awt.Color(255, 255, 255));
        tituloCar.setText("GESTIONAR CARRERA");

        textNomBusCar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textNomBusCar.setForeground(new java.awt.Color(255, 255, 255));
        textNomBusCar.setText("Nombre");

        botonBuscarCar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonBuscarCar.setText("BUSCAR");
        botonBuscarCar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botonAgregarCar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAgregarCar.setText("AGREGAR");
        botonAgregarCar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        textNomCar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textNomCar.setForeground(new java.awt.Color(255, 255, 255));
        textNomCar.setText("Nombre");

        campoNomCar.setEditable(false);
        campoNomCar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textDesCar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textDesCar.setForeground(new java.awt.Color(255, 255, 255));
        textDesCar.setText("Descripción");

        campoDesCar.setEditable(false);
        campoDesCar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textDecCar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textDecCar.setForeground(new java.awt.Color(255, 255, 255));
        textDecCar.setText("Decanato");

        comboDecCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDecCarActionPerformed(evt);
            }
        });

        textStaCar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textStaCar.setForeground(new java.awt.Color(255, 255, 255));
        textStaCar.setText("Estado");

        bontonAtrasCar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonAtrasCar.setText("ATRAS");
        bontonAtrasCar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonAtrasCar.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonAtrasCar.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonAtrasCar.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonAtrasCar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonAtrasCarMouseClicked(evt);
            }
        });
        bontonAtrasCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonAtrasCarActionPerformed(evt);
            }
        });

        bontonCancelarCar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonCancelarCar.setText("CANCELAR");
        bontonCancelarCar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonCancelarCar.setEnabled(false);
        bontonCancelarCar.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonCancelarCar.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonCancelarCar.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonCancelarCar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonCancelarCarMouseClicked(evt);
            }
        });
        bontonCancelarCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonCancelarCarActionPerformed(evt);
            }
        });

        botonEliminarCar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEliminarCar.setText("ELIMINAR");
        botonEliminarCar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarCar.setEnabled(false);

        botonModificarCar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonModificarCar.setText("MODIFICAR");
        botonModificarCar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonModificarCar.setEnabled(false);

        botonGuardarCar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonGuardarCar.setText("GUARDAR");
        botonGuardarCar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardarCar.setEnabled(false);

        javax.swing.GroupLayout bgCarreraLayout = new javax.swing.GroupLayout(bgCarrera);
        bgCarrera.setLayout(bgCarreraLayout);
        bgCarreraLayout.setHorizontalGroup(
            bgCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgCarreraLayout.createSequentialGroup()
                .addGroup(bgCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgCarreraLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(bgCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgCarreraLayout.createSequentialGroup()
                                .addComponent(textNomBusCar)
                                .addGap(18, 18, 18)
                                .addComponent(comboNomBusCar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonBuscarCar)
                                .addGap(18, 18, 18)
                                .addComponent(botonAgregarCar))
                            .addGroup(bgCarreraLayout.createSequentialGroup()
                                .addGroup(bgCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNomCar)
                                    .addComponent(bontonAtrasCar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(bgCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(bgCarreraLayout.createSequentialGroup()
                                        .addComponent(bontonCancelarCar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonEliminarCar)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonModificarCar)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonGuardarCar))
                                    .addGroup(bgCarreraLayout.createSequentialGroup()
                                        .addGroup(bgCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campoNomCar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboDecCar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(54, 54, 54)
                                        .addGroup(bgCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textDesCar)
                                            .addComponent(textStaCar))
                                        .addGap(45, 45, 45)
                                        .addGroup(bgCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campoDesCar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboStaCar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(textDecCar)))
                    .addGroup(bgCarreraLayout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(tituloCar)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        bgCarreraLayout.setVerticalGroup(
            bgCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgCarreraLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(tituloCar)
                .addGap(41, 41, 41)
                .addGroup(bgCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomBusCar)
                    .addComponent(botonBuscarCar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregarCar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboNomBusCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(bgCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomCar)
                    .addComponent(campoNomCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDesCar)
                    .addComponent(campoDesCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(bgCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDecCar)
                    .addGroup(bgCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboDecCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textStaCar)
                        .addComponent(comboStaCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addGroup(bgCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardarCar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonModificarCar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bontonAtrasCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarCar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bontonCancelarCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bontonAtrasCarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonAtrasCarMouseClicked

    }//GEN-LAST:event_bontonAtrasCarMouseClicked

    private void bontonAtrasCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonAtrasCarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonAtrasCarActionPerformed

    private void bontonCancelarCarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonCancelarCarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarCarMouseClicked

    private void bontonCancelarCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonCancelarCarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarCarActionPerformed

    private void comboDecCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDecCarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDecCarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarreraAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgCarrera;
    private javax.swing.JButton bontonAtrasCar;
    private javax.swing.JButton bontonCancelarCar;
    private javax.swing.JButton botonAgregarCar;
    private javax.swing.JButton botonBuscarCar;
    private javax.swing.JButton botonEliminarCar;
    private javax.swing.JButton botonGuardarCar;
    private javax.swing.JButton botonModificarCar;
    private javax.swing.JTextField campoDesCar;
    private javax.swing.JTextField campoNomCar;
    private javax.swing.JComboBox<String> comboDecCar;
    private javax.swing.JComboBox<String> comboNomBusCar;
    private javax.swing.JComboBox<String> comboStaCar;
    private javax.swing.JLabel textDecCar;
    private javax.swing.JLabel textDesCar;
    private javax.swing.JLabel textNomBusCar;
    private javax.swing.JLabel textNomCar;
    private javax.swing.JLabel textStaCar;
    private javax.swing.JLabel tituloCar;
    // End of variables declaration//GEN-END:variables
}
