// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package vistas;

public class DecanatoAdmin extends javax.swing.JFrame {

    /**
     * @return the bontonCancelarDec
     */
    public javax.swing.JButton getBontonCancelarDec() {
        return bontonCancelarDec;
    }

    /**
     * @return the botonAgregarDec
     */
    public javax.swing.JButton getBotonAgregarDec() {
        return botonAgregarDec;
    }

    /**
     * @return the botonBuscarDec
     */
    public javax.swing.JButton getBotonBuscarDec() {
        return botonBuscarDec;
    }

    /**
     * @return the botonEliminarDec
     */
    public javax.swing.JButton getBotonEliminarDec() {
        return botonEliminarDec;
    }

    /**
     * @return the botonGuardarDec
     */
    public javax.swing.JButton getBotonGuardarDec() {
        return botonGuardarDec;
    }

    /**
     * @return the botonModificarDec
     */
    public javax.swing.JButton getBotonModificarDec() {
        return botonModificarDec;
    }

    /**
     * @return the campoDesDec
     */
    public javax.swing.JTextField getCampoDesDec() {
        return campoDesDec;
    }

    /**
     * @return the campoNomDec
     */
    public javax.swing.JTextField getCampoNomDec() {
        return campoNomDec;
    }

    /**
     * @return the comboNombBusDec
     */
    public javax.swing.JComboBox<String> getComboNombBusDec() {
        return comboNombBusDec;
    }

    /**
     * @return the comboStaDec
     */
    public javax.swing.JComboBox<String> getComboStaDec() {
        return comboStaDec;
    }

    /**
     * @return the comboUniDec
     */
    public javax.swing.JComboBox<String> getComboUniDec() {
        return comboUniDec;
    }

    /**
     * @return the bontonAtrasDec
     */
    public javax.swing.JButton getBontonAtrasDec() {
        return bontonAtrasDec;
    }

    public DecanatoAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgDecanato = new javax.swing.JPanel();
        tituloDec = new javax.swing.JLabel();
        textNomBusDec = new javax.swing.JLabel();
        comboNombBusDec = new javax.swing.JComboBox<>();
        botonBuscarDec = new javax.swing.JButton();
        botonAgregarDec = new javax.swing.JButton();
        textNomDec = new javax.swing.JLabel();
        campoNomDec = new javax.swing.JTextField();
        textDesDec = new javax.swing.JLabel();
        campoDesDec = new javax.swing.JTextField();
        textUniDec = new javax.swing.JLabel();
        comboUniDec = new javax.swing.JComboBox<>();
        textStaDec = new javax.swing.JLabel();
        comboStaDec = new javax.swing.JComboBox<>();
        bontonAtrasDec = new javax.swing.JButton();
        bontonCancelarDec = new javax.swing.JButton();
        botonEliminarDec = new javax.swing.JButton();
        botonModificarDec = new javax.swing.JButton();
        botonGuardarDec = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Decanato");
        setResizable(false);

        bgDecanato.setBackground(new java.awt.Color(41, 144, 159));

        tituloDec.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        tituloDec.setForeground(new java.awt.Color(255, 255, 255));
        tituloDec.setText("GESTIONAR DECANATO");

        textNomBusDec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textNomBusDec.setForeground(new java.awt.Color(255, 255, 255));
        textNomBusDec.setText("Nombre");

        botonBuscarDec.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonBuscarDec.setText("BUSCAR");
        botonBuscarDec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botonAgregarDec.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAgregarDec.setText("AGREGAR");
        botonAgregarDec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        textNomDec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textNomDec.setForeground(new java.awt.Color(255, 255, 255));
        textNomDec.setText("Nombre");

        campoNomDec.setEditable(false);
        campoNomDec.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textDesDec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textDesDec.setForeground(new java.awt.Color(255, 255, 255));
        textDesDec.setText("Descripción");

        campoDesDec.setEditable(false);
        campoDesDec.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textUniDec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textUniDec.setForeground(new java.awt.Color(255, 255, 255));
        textUniDec.setText("Universidad");

        textStaDec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textStaDec.setForeground(new java.awt.Color(255, 255, 255));
        textStaDec.setText("Estatus");

        bontonAtrasDec.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonAtrasDec.setText("ATRAS");
        bontonAtrasDec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonAtrasDec.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonAtrasDec.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonAtrasDec.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonAtrasDec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonAtrasDecMouseClicked(evt);
            }
        });
        bontonAtrasDec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonAtrasDecActionPerformed(evt);
            }
        });

        bontonCancelarDec.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonCancelarDec.setText("CANCELAR");
        bontonCancelarDec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonCancelarDec.setEnabled(false);
        bontonCancelarDec.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonCancelarDec.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonCancelarDec.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonCancelarDec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonCancelarDecMouseClicked(evt);
            }
        });
        bontonCancelarDec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonCancelarDecActionPerformed(evt);
            }
        });

        botonEliminarDec.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEliminarDec.setText("ELIMINAR");
        botonEliminarDec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarDec.setEnabled(false);

        botonModificarDec.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonModificarDec.setText("MODIFICAR");
        botonModificarDec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonModificarDec.setEnabled(false);

        botonGuardarDec.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonGuardarDec.setText("GUARDAR");
        botonGuardarDec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardarDec.setEnabled(false);

        javax.swing.GroupLayout bgDecanatoLayout = new javax.swing.GroupLayout(bgDecanato);
        bgDecanato.setLayout(bgDecanatoLayout);
        bgDecanatoLayout.setHorizontalGroup(
            bgDecanatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgDecanatoLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(bgDecanatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgDecanatoLayout.createSequentialGroup()
                        .addGroup(bgDecanatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNomDec)
                            .addComponent(textUniDec)
                            .addComponent(bontonAtrasDec, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(bgDecanatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bgDecanatoLayout.createSequentialGroup()
                                .addGroup(bgDecanatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoNomDec, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboUniDec, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(bgDecanatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textDesDec)
                                    .addComponent(textStaDec))
                                .addGap(27, 27, 27)
                                .addGroup(bgDecanatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboStaDec, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoDesDec, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgDecanatoLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(bontonCancelarDec, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonEliminarDec)
                                .addGap(18, 18, 18)
                                .addComponent(botonModificarDec)
                                .addGap(18, 18, 18)
                                .addComponent(botonGuardarDec))
                            .addGroup(bgDecanatoLayout.createSequentialGroup()
                                .addComponent(comboNombBusDec, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(botonBuscarDec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonAgregarDec))
                            .addGroup(bgDecanatoLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(tituloDec))))
                    .addComponent(textNomBusDec))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        bgDecanatoLayout.setVerticalGroup(
            bgDecanatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgDecanatoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tituloDec)
                .addGap(42, 42, 42)
                .addGroup(bgDecanatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomBusDec)
                    .addComponent(botonBuscarDec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboNombBusDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregarDec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(bgDecanatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNomDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNomDec)
                    .addComponent(textDesDec)
                    .addComponent(campoDesDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(bgDecanatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textUniDec)
                    .addComponent(comboUniDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStaDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textStaDec))
                .addGap(58, 58, 58)
                .addGroup(bgDecanatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminarDec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardarDec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonModificarDec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bontonAtrasDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bontonCancelarDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgDecanato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgDecanato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bontonAtrasDecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonAtrasDecMouseClicked
        //Abrir ventana
        DashboardAdministrador frm = new DashboardAdministrador();
        frm.setVisible(true);
        //Cerrar ventana anterior
        this.dispose();
    }//GEN-LAST:event_bontonAtrasDecMouseClicked

    private void bontonAtrasDecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonAtrasDecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonAtrasDecActionPerformed

    private void bontonCancelarDecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonCancelarDecMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarDecMouseClicked

    private void bontonCancelarDecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonCancelarDecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarDecActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DecanatoAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgDecanato;
    private javax.swing.JButton bontonAtrasDec;
    private javax.swing.JButton bontonCancelarDec;
    private javax.swing.JButton botonAgregarDec;
    private javax.swing.JButton botonBuscarDec;
    private javax.swing.JButton botonEliminarDec;
    private javax.swing.JButton botonGuardarDec;
    private javax.swing.JButton botonModificarDec;
    private javax.swing.JTextField campoDesDec;
    private javax.swing.JTextField campoNomDec;
    private javax.swing.JComboBox<String> comboNombBusDec;
    private javax.swing.JComboBox<String> comboStaDec;
    private javax.swing.JComboBox<String> comboUniDec;
    private javax.swing.JLabel textDesDec;
    private javax.swing.JLabel textNomBusDec;
    private javax.swing.JLabel textNomDec;
    private javax.swing.JLabel textStaDec;
    private javax.swing.JLabel textUniDec;
    private javax.swing.JLabel tituloDec;
    // End of variables declaration//GEN-END:variables
}
