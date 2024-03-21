// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package vistas;

public class PeriodoAcademicoAdmin extends javax.swing.JFrame {

    /**
     * @return the bontonAtrasPerAcad
     */
    public javax.swing.JButton getBontonAtrasPerAcad() {
        return bontonAtrasPerAcad;
    }

    /**
     * @return the bontonCancelarPerAca
     */
    public javax.swing.JButton getBontonCancelarPerAca() {
        return bontonCancelarPerAca;
    }

    /**
     * @return the botonAgregarPerAcad
     */
    public javax.swing.JButton getBotonAgregarPerAcad() {
        return botonAgregarPerAcad;
    }

    /**
     * @return the botonBuscarPerAcad
     */
    public javax.swing.JButton getBotonBuscarPerAcad() {
        return botonBuscarPerAcad;
    }

    /**
     * @return the botonEliminarPerAcad
     */
    public javax.swing.JButton getBotonEliminarPerAcad() {
        return botonEliminarPerAcad;
    }

    /**
     * @return the botonGuardarPerAcad
     */
    public javax.swing.JButton getBotonGuardarPerAcad() {
        return botonGuardarPerAcad;
    }

    /**
     * @return the botonModificarPerAcad
     */
    public javax.swing.JButton getBotonModificarPerAcad() {
        return botonModificarPerAcad;
    }

    /**
     * @return the campoDesPerAcad
     */
    public javax.swing.JTextField getCampoDesPerAcad() {
        return campoDesPerAcad;
    }

    /**
     * @return the campoFecCulPerAcad
     */
    public javax.swing.JFormattedTextField getCampoFecCulPerAcad() {
        return campoFecCulPerAcad;
    }

    /**
     * @return the campoFecIngPerAcad
     */
    public javax.swing.JFormattedTextField getCampoFecIngPerAcad() {
        return campoFecIngPerAcad;
    }

    /**
     * @return the campoNomPerAcad
     */
    public javax.swing.JTextField getCampoNomPerAcad() {
        return campoNomPerAcad;
    }

    /**
     * @return the comboActPerAcad
     */
    public javax.swing.JComboBox<String> getComboActPerAcad() {
        return comboActPerAcad;
    }

    /**
     * @return the comboNomBusPerAcad
     */
    public javax.swing.JComboBox<String> getComboNomBusPerAcad() {
        return comboNomBusPerAcad;
    }

    /**
     * @return the comboStaPerAcad
     */
    public javax.swing.JComboBox<String> getComboStaPerAcad() {
        return comboStaPerAcad;
    }


    public PeriodoAcademicoAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPeriodoAcademico = new javax.swing.JPanel();
        tituloPerAcad = new javax.swing.JLabel();
        textNomBusPerAcad = new javax.swing.JLabel();
        comboNomBusPerAcad = new javax.swing.JComboBox<>();
        botonBuscarPerAcad = new javax.swing.JButton();
        botonAgregarPerAcad = new javax.swing.JButton();
        textNomPerAcad = new javax.swing.JLabel();
        campoNomPerAcad = new javax.swing.JTextField();
        textDesPerAcad = new javax.swing.JLabel();
        campoDesPerAcad = new javax.swing.JTextField();
        textFecIngPerAcad = new javax.swing.JLabel();
        campoFecIngPerAcad = new javax.swing.JFormattedTextField();
        textFecCulPerAcad = new javax.swing.JLabel();
        campoFecCulPerAcad = new javax.swing.JFormattedTextField();
        textActPerAcad = new javax.swing.JLabel();
        comboActPerAcad = new javax.swing.JComboBox<>();
        textStaPerAcad = new javax.swing.JLabel();
        comboStaPerAcad = new javax.swing.JComboBox<>();
        bontonAtrasPerAcad = new javax.swing.JButton();
        bontonCancelarPerAca = new javax.swing.JButton();
        botonEliminarPerAcad = new javax.swing.JButton();
        botonModificarPerAcad = new javax.swing.JButton();
        botonGuardarPerAcad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Período Académico");
        setResizable(false);

        bgPeriodoAcademico.setBackground(new java.awt.Color(41, 144, 159));

        tituloPerAcad.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        tituloPerAcad.setForeground(new java.awt.Color(255, 255, 255));
        tituloPerAcad.setText("GESTIONAR PERIODO ACADÉMICO");

        textNomBusPerAcad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textNomBusPerAcad.setForeground(new java.awt.Color(255, 255, 255));
        textNomBusPerAcad.setText("Nombre");

        botonBuscarPerAcad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonBuscarPerAcad.setText("BUSCAR");
        botonBuscarPerAcad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botonAgregarPerAcad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAgregarPerAcad.setText("AGREGAR");
        botonAgregarPerAcad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        textNomPerAcad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textNomPerAcad.setForeground(new java.awt.Color(255, 255, 255));
        textNomPerAcad.setText("Nombre");

        campoNomPerAcad.setEditable(false);
        campoNomPerAcad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textDesPerAcad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textDesPerAcad.setForeground(new java.awt.Color(255, 255, 255));
        textDesPerAcad.setText("Descripción");

        campoDesPerAcad.setEditable(false);
        campoDesPerAcad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textFecIngPerAcad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textFecIngPerAcad.setForeground(new java.awt.Color(255, 255, 255));
        textFecIngPerAcad.setText("Fecha de Ingreso");

        campoFecIngPerAcad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        textFecCulPerAcad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textFecCulPerAcad.setForeground(new java.awt.Color(255, 255, 255));
        textFecCulPerAcad.setText("Fecha de Culminación");

        campoFecCulPerAcad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        textActPerAcad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textActPerAcad.setForeground(new java.awt.Color(255, 255, 255));
        textActPerAcad.setText("Activo");

        textStaPerAcad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textStaPerAcad.setForeground(new java.awt.Color(255, 255, 255));
        textStaPerAcad.setText("Estatus");

        bontonAtrasPerAcad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonAtrasPerAcad.setText("ATRAS");
        bontonAtrasPerAcad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonAtrasPerAcad.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonAtrasPerAcad.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonAtrasPerAcad.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonAtrasPerAcad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonAtrasPerAcadMouseClicked(evt);
            }
        });
        bontonAtrasPerAcad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonAtrasPerAcadActionPerformed(evt);
            }
        });

        bontonCancelarPerAca.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonCancelarPerAca.setText("CANCELAR");
        bontonCancelarPerAca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonCancelarPerAca.setEnabled(false);
        bontonCancelarPerAca.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonCancelarPerAca.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonCancelarPerAca.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonCancelarPerAca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonCancelarPerAcaMouseClicked(evt);
            }
        });
        bontonCancelarPerAca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonCancelarPerAcaActionPerformed(evt);
            }
        });

        botonEliminarPerAcad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEliminarPerAcad.setText("ELIMINAR");
        botonEliminarPerAcad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarPerAcad.setEnabled(false);

        botonModificarPerAcad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonModificarPerAcad.setText("MODIFICAR");
        botonModificarPerAcad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonModificarPerAcad.setEnabled(false);

        botonGuardarPerAcad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonGuardarPerAcad.setText("GUARDAR");
        botonGuardarPerAcad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardarPerAcad.setEnabled(false);

        javax.swing.GroupLayout bgPeriodoAcademicoLayout = new javax.swing.GroupLayout(bgPeriodoAcademico);
        bgPeriodoAcademico.setLayout(bgPeriodoAcademicoLayout);
        bgPeriodoAcademicoLayout.setHorizontalGroup(
            bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPeriodoAcademicoLayout.createSequentialGroup()
                .addGroup(bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgPeriodoAcademicoLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgPeriodoAcademicoLayout.createSequentialGroup()
                                .addComponent(botonEliminarPerAcad)
                                .addGap(18, 18, 18)
                                .addComponent(botonModificarPerAcad)
                                .addGap(18, 18, 18)
                                .addComponent(botonGuardarPerAcad))
                            .addGroup(bgPeriodoAcademicoLayout.createSequentialGroup()
                                .addGroup(bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(bgPeriodoAcademicoLayout.createSequentialGroup()
                                        .addComponent(bontonAtrasPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bontonCancelarPerAca, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(textActPerAcad)
                                    .addGroup(bgPeriodoAcademicoLayout.createSequentialGroup()
                                        .addGroup(bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(bgPeriodoAcademicoLayout.createSequentialGroup()
                                                    .addComponent(textNomBusPerAcad)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(comboNomBusPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(comboActPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(bgPeriodoAcademicoLayout.createSequentialGroup()
                                                    .addComponent(textFecIngPerAcad)
                                                    .addGap(24, 24, 24)
                                                    .addComponent(campoFecIngPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(bgPeriodoAcademicoLayout.createSequentialGroup()
                                                .addComponent(textNomPerAcad)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(campoNomPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(bgPeriodoAcademicoLayout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textStaPerAcad)
                                                    .addComponent(textFecCulPerAcad)
                                                    .addComponent(textDesPerAcad)))
                                            .addGroup(bgPeriodoAcademicoLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(botonBuscarPerAcad)
                                                .addGap(18, 18, 18)
                                                .addComponent(botonAgregarPerAcad)))))
                                .addGap(18, 18, 18)
                                .addGroup(bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboStaPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoFecCulPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoDesPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(bgPeriodoAcademicoLayout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(tituloPerAcad)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        bgPeriodoAcademicoLayout.setVerticalGroup(
            bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPeriodoAcademicoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(tituloPerAcad)
                .addGap(34, 34, 34)
                .addGroup(bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomBusPerAcad)
                    .addComponent(botonBuscarPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregarPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboNomBusPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomPerAcad)
                    .addComponent(campoNomPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDesPerAcad)
                    .addComponent(campoDesPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFecIngPerAcad)
                    .addComponent(textFecCulPerAcad)
                    .addComponent(campoFecCulPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoFecIngPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboActPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textActPerAcad)
                    .addComponent(textStaPerAcad)
                    .addComponent(comboStaPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(bgPeriodoAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardarPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonModificarPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bontonAtrasPerAcad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bontonCancelarPerAca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPeriodoAcademico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPeriodoAcademico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bontonAtrasPerAcadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonAtrasPerAcadMouseClicked

    }//GEN-LAST:event_bontonAtrasPerAcadMouseClicked

    private void bontonAtrasPerAcadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonAtrasPerAcadActionPerformed

    }//GEN-LAST:event_bontonAtrasPerAcadActionPerformed

    private void bontonCancelarPerAcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonCancelarPerAcaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarPerAcaMouseClicked

    private void bontonCancelarPerAcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonCancelarPerAcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarPerAcaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeriodoAcademicoAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPeriodoAcademico;
    private javax.swing.JButton bontonAtrasPerAcad;
    private javax.swing.JButton bontonCancelarPerAca;
    private javax.swing.JButton botonAgregarPerAcad;
    private javax.swing.JButton botonBuscarPerAcad;
    private javax.swing.JButton botonEliminarPerAcad;
    private javax.swing.JButton botonGuardarPerAcad;
    private javax.swing.JButton botonModificarPerAcad;
    private javax.swing.JTextField campoDesPerAcad;
    private javax.swing.JFormattedTextField campoFecCulPerAcad;
    private javax.swing.JFormattedTextField campoFecIngPerAcad;
    private javax.swing.JTextField campoNomPerAcad;
    private javax.swing.JComboBox<String> comboActPerAcad;
    private javax.swing.JComboBox<String> comboNomBusPerAcad;
    private javax.swing.JComboBox<String> comboStaPerAcad;
    private javax.swing.JLabel textActPerAcad;
    private javax.swing.JLabel textDesPerAcad;
    private javax.swing.JLabel textFecCulPerAcad;
    private javax.swing.JLabel textFecIngPerAcad;
    private javax.swing.JLabel textNomBusPerAcad;
    private javax.swing.JLabel textNomPerAcad;
    private javax.swing.JLabel textStaPerAcad;
    private javax.swing.JLabel tituloPerAcad;
    // End of variables declaration//GEN-END:variables
}
