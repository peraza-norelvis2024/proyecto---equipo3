// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package vistas;

public class AsignaturaAdmin extends javax.swing.JFrame {

    /**
     * @return the bontonAtrasAsig
     */
    public javax.swing.JButton getBontonAtrasAsig() {
        return bontonAtrasAsig;
    }

    /**
     * @return the bontonCancelarEst
     */
    public javax.swing.JButton getBontonCancelarAsig() {
        return bontonCancelarAsig;
    }

    /**
     * @return the botonAgregarAsig
     */
    public javax.swing.JButton getBotonAgregarAsig() {
        return botonAgregarAsig;
    }

    /**
     * @return the botonBuscarAsig
     */
    public javax.swing.JButton getBotonBuscarAsig() {
        return botonBuscarAsig;
    }

    /**
     * @return the botonEliminarAsig
     */
    public javax.swing.JButton getBotonEliminarAsig() {
        return botonEliminarAsig;
    }

    /**
     * @return the botonGuardarAsig
     */
    public javax.swing.JButton getBotonGuardarAsig() {
        return botonGuardarAsig;
    }

    /**
     * @return the botonModificarAsig
     */
    public javax.swing.JButton getBotonModificarAsig() {
        return botonModificarAsig;
    }

    /**
     * @return the campoDesAsig
     */
    public javax.swing.JTextField getCampoDesAsig() {
        return campoDesAsig;
    }

    /**
     * @return the campoNomAsig
     */
    public javax.swing.JTextField getCampoNomAsig() {
        return campoNomAsig;
    }

    /**
     * @return the comboCarAsig
     */
    public javax.swing.JComboBox<String> getComboCarAsig() {
        return comboCarAsig;
    }

    /**
     * @return the comboNomBusAsig
     */
    public javax.swing.JComboBox<String> getComboNomBusAsig() {
        return comboNomBusAsig;
    }

    /**
     * @return the comboSemAsig
     */
    public javax.swing.JComboBox<String> getComboSemAsig() {
        return comboSemAsig;
    }

    /**
     * @return the comboStaAsig
     */
    public javax.swing.JComboBox<String> getComboStaAsig() {
        return comboStaAsig;
    }

    public AsignaturaAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgAsignatura = new javax.swing.JPanel();
        tituloAsig = new javax.swing.JLabel();
        textNomBusAsig = new javax.swing.JLabel();
        comboNomBusAsig = new javax.swing.JComboBox<>();
        botonBuscarAsig = new javax.swing.JButton();
        botonAgregarAsig = new javax.swing.JButton();
        textNomAsig = new javax.swing.JLabel();
        campoNomAsig = new javax.swing.JTextField();
        textDesAsig = new javax.swing.JLabel();
        campoDesAsig = new javax.swing.JTextField();
        textSemAsig = new javax.swing.JLabel();
        comboSemAsig = new javax.swing.JComboBox<>();
        textCarAsig = new javax.swing.JLabel();
        comboCarAsig = new javax.swing.JComboBox<>();
        textStaAsig = new javax.swing.JLabel();
        comboStaAsig = new javax.swing.JComboBox<>();
        bontonAtrasAsig = new javax.swing.JButton();
        bontonCancelarAsig = new javax.swing.JButton();
        botonEliminarAsig = new javax.swing.JButton();
        botonModificarAsig = new javax.swing.JButton();
        botonGuardarAsig = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asignatura");
        setResizable(false);

        bgAsignatura.setBackground(new java.awt.Color(41, 144, 159));

        tituloAsig.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        tituloAsig.setForeground(new java.awt.Color(255, 255, 255));
        tituloAsig.setText("GESTIONAR ASIGNACIÓN");

        textNomBusAsig.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textNomBusAsig.setForeground(new java.awt.Color(255, 255, 255));
        textNomBusAsig.setText("Nombre");

        botonBuscarAsig.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonBuscarAsig.setText("BUSCAR");
        botonBuscarAsig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botonAgregarAsig.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAgregarAsig.setText("AGREGAR");
        botonAgregarAsig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        textNomAsig.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textNomAsig.setForeground(new java.awt.Color(255, 255, 255));
        textNomAsig.setText("Nombre");

        campoNomAsig.setEditable(false);
        campoNomAsig.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textDesAsig.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textDesAsig.setForeground(new java.awt.Color(255, 255, 255));
        textDesAsig.setText("Descripción");

        campoDesAsig.setEditable(false);
        campoDesAsig.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textSemAsig.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textSemAsig.setForeground(new java.awt.Color(255, 255, 255));
        textSemAsig.setText("Semestre");

        textCarAsig.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textCarAsig.setForeground(new java.awt.Color(255, 255, 255));
        textCarAsig.setText("Carrera");

        comboCarAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCarAsigActionPerformed(evt);
            }
        });

        textStaAsig.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textStaAsig.setForeground(new java.awt.Color(255, 255, 255));
        textStaAsig.setText("Estado");

        bontonAtrasAsig.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonAtrasAsig.setText("ATRAS");
        bontonAtrasAsig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonAtrasAsig.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonAtrasAsig.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonAtrasAsig.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonAtrasAsig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonAtrasAsigMouseClicked(evt);
            }
        });
        bontonAtrasAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonAtrasAsigActionPerformed(evt);
            }
        });

        bontonCancelarAsig.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonCancelarAsig.setText("CANCELAR");
        bontonCancelarAsig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonCancelarAsig.setEnabled(false);
        bontonCancelarAsig.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonCancelarAsig.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonCancelarAsig.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonCancelarAsig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonCancelarAsigMouseClicked(evt);
            }
        });
        bontonCancelarAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonCancelarAsigActionPerformed(evt);
            }
        });

        botonEliminarAsig.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEliminarAsig.setText("ELIMINAR");
        botonEliminarAsig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarAsig.setEnabled(false);

        botonModificarAsig.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonModificarAsig.setText("MODIFICAR");
        botonModificarAsig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonModificarAsig.setEnabled(false);

        botonGuardarAsig.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonGuardarAsig.setText("GUARDAR");
        botonGuardarAsig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardarAsig.setEnabled(false);

        javax.swing.GroupLayout bgAsignaturaLayout = new javax.swing.GroupLayout(bgAsignatura);
        bgAsignatura.setLayout(bgAsignaturaLayout);
        bgAsignaturaLayout.setHorizontalGroup(
            bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgAsignaturaLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgAsignaturaLayout.createSequentialGroup()
                        .addComponent(bontonAtrasAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bontonCancelarAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(bgAsignaturaLayout.createSequentialGroup()
                        .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgAsignaturaLayout.createSequentialGroup()
                                .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textSemAsig)
                                    .addComponent(textStaAsig))
                                .addGap(18, 18, 18)
                                .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboSemAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboStaAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(bgAsignaturaLayout.createSequentialGroup()
                                .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNomAsig, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textNomBusAsig))
                                .addGap(32, 32, 32)
                                .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboNomBusAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoNomAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgAsignaturaLayout.createSequentialGroup()
                                        .addComponent(botonBuscarAsig)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(botonAgregarAsig))
                                    .addGroup(bgAsignaturaLayout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(bgAsignaturaLayout.createSequentialGroup()
                                                .addComponent(botonEliminarAsig)
                                                .addGap(18, 18, 18)
                                                .addComponent(botonModificarAsig)
                                                .addGap(18, 18, 18)
                                                .addComponent(botonGuardarAsig))
                                            .addGroup(bgAsignaturaLayout.createSequentialGroup()
                                                .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textDesAsig)
                                                    .addComponent(textCarAsig))
                                                .addGap(30, 30, 30)
                                                .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(comboCarAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(campoDesAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgAsignaturaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloAsig)
                .addGap(296, 296, 296))
        );
        bgAsignaturaLayout.setVerticalGroup(
            bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgAsignaturaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(tituloAsig)
                .addGap(41, 41, 41)
                .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomBusAsig)
                    .addComponent(botonBuscarAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregarAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboNomBusAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomAsig)
                    .addComponent(campoNomAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDesAsig)
                    .addComponent(campoDesAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSemAsig)
                    .addComponent(comboSemAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCarAsig)
                    .addComponent(comboCarAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStaAsig)
                    .addComponent(comboStaAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(bgAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bontonAtrasAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardarAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonModificarAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bontonCancelarAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgAsignatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgAsignatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bontonAtrasAsigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonAtrasAsigMouseClicked

    }//GEN-LAST:event_bontonAtrasAsigMouseClicked

    private void bontonAtrasAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonAtrasAsigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonAtrasAsigActionPerformed

    private void bontonCancelarAsigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonCancelarAsigMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarAsigMouseClicked

    private void bontonCancelarAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonCancelarAsigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarAsigActionPerformed

    private void comboCarAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCarAsigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCarAsigActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignaturaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgAsignatura;
    private javax.swing.JButton bontonAtrasAsig;
    private javax.swing.JButton bontonCancelarAsig;
    private javax.swing.JButton botonAgregarAsig;
    private javax.swing.JButton botonBuscarAsig;
    private javax.swing.JButton botonEliminarAsig;
    private javax.swing.JButton botonGuardarAsig;
    private javax.swing.JButton botonModificarAsig;
    private javax.swing.JTextField campoDesAsig;
    private javax.swing.JTextField campoNomAsig;
    private javax.swing.JComboBox<String> comboCarAsig;
    private javax.swing.JComboBox<String> comboNomBusAsig;
    private javax.swing.JComboBox<String> comboSemAsig;
    private javax.swing.JComboBox<String> comboStaAsig;
    private javax.swing.JLabel textCarAsig;
    private javax.swing.JLabel textDesAsig;
    private javax.swing.JLabel textNomAsig;
    private javax.swing.JLabel textNomBusAsig;
    private javax.swing.JLabel textSemAsig;
    private javax.swing.JLabel textStaAsig;
    private javax.swing.JLabel tituloAsig;
    // End of variables declaration//GEN-END:variables
}
