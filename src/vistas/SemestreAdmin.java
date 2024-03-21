// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package vistas;

public class SemestreAdmin extends javax.swing.JFrame {

    /**
     * @return the bontonAtrasSem
     */
    public javax.swing.JButton getBontonAtrasSem() {
        return bontonAtrasSem;
    }

    /**
     * @return the bontonCancelarDec
     */
    public javax.swing.JButton getBontonCancelarSem() {
        return bontonCancelarSem;
    }

    /**
     * @return the botonAgregarSem
     */
    public javax.swing.JButton getBotonAgregarSem() {
        return botonAgregarSem;
    }

    /**
     * @return the botonBuscarSem
     */
    public javax.swing.JButton getBotonBuscarSem() {
        return botonBuscarSem;
    }

    /**
     * @return the botonEliminarSem
     */
    public javax.swing.JButton getBotonEliminarSem() {
        return botonEliminarSem;
    }

    /**
     * @return the botonGuardarSem
     */
    public javax.swing.JButton getBotonGuardarSem() {
        return botonGuardarSem;
    }

    /**
     * @return the botonModificarSem
     */
    public javax.swing.JButton getBotonModificarSem() {
        return botonModificarSem;
    }

    /**
     * @return the campoNomSem
     */
    public javax.swing.JTextField getCampoNomSem() {
        return campoNomSem;
    }

    /**
     * @return the comboNomBusSem
     */
    public javax.swing.JComboBox<String> getComboNomBusSem() {
        return comboNomBusSem;
    }

    /**
     * @return the comboStaSem
     */
    public javax.swing.JComboBox<String> getComboStaSem() {
        return comboStaSem;
    }

    public SemestreAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSemestre = new javax.swing.JPanel();
        tituloSem = new javax.swing.JLabel();
        textNomBusSem = new javax.swing.JLabel();
        comboNomBusSem = new javax.swing.JComboBox<>();
        botonBuscarSem = new javax.swing.JButton();
        botonAgregarSem = new javax.swing.JButton();
        textNomSem = new javax.swing.JLabel();
        campoNomSem = new javax.swing.JTextField();
        textStaSem = new javax.swing.JLabel();
        comboStaSem = new javax.swing.JComboBox<>();
        bontonAtrasSem = new javax.swing.JButton();
        bontonCancelarSem = new javax.swing.JButton();
        botonEliminarSem = new javax.swing.JButton();
        botonModificarSem = new javax.swing.JButton();
        botonGuardarSem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Semestre");
        setResizable(false);

        bgSemestre.setBackground(new java.awt.Color(41, 144, 159));

        tituloSem.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        tituloSem.setForeground(new java.awt.Color(255, 255, 255));
        tituloSem.setText("GESTIONAR SEMESTRE");

        textNomBusSem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textNomBusSem.setForeground(new java.awt.Color(255, 255, 255));
        textNomBusSem.setText("Nombre");

        botonBuscarSem.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonBuscarSem.setText("BUSCAR");
        botonBuscarSem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botonAgregarSem.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAgregarSem.setText("AGREGAR");
        botonAgregarSem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        textNomSem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textNomSem.setForeground(new java.awt.Color(255, 255, 255));
        textNomSem.setText("Nombre");

        campoNomSem.setEditable(false);
        campoNomSem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textStaSem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textStaSem.setForeground(new java.awt.Color(255, 255, 255));
        textStaSem.setText("Estatus");

        bontonAtrasSem.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonAtrasSem.setText("ATRAS");
        bontonAtrasSem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonAtrasSem.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonAtrasSem.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonAtrasSem.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonAtrasSem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonAtrasSemMouseClicked(evt);
            }
        });
        bontonAtrasSem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonAtrasSemActionPerformed(evt);
            }
        });

        bontonCancelarSem.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonCancelarSem.setText("CANCELAR");
        bontonCancelarSem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonCancelarSem.setEnabled(false);
        bontonCancelarSem.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonCancelarSem.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonCancelarSem.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonCancelarSem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonCancelarSemMouseClicked(evt);
            }
        });
        bontonCancelarSem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonCancelarSemActionPerformed(evt);
            }
        });

        botonEliminarSem.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEliminarSem.setText("ELIMINAR");
        botonEliminarSem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarSem.setEnabled(false);

        botonModificarSem.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonModificarSem.setText("MODIFICAR");
        botonModificarSem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonModificarSem.setEnabled(false);

        botonGuardarSem.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonGuardarSem.setText("GUARDAR");
        botonGuardarSem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardarSem.setEnabled(false);

        javax.swing.GroupLayout bgSemestreLayout = new javax.swing.GroupLayout(bgSemestre);
        bgSemestre.setLayout(bgSemestreLayout);
        bgSemestreLayout.setHorizontalGroup(
            bgSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgSemestreLayout.createSequentialGroup()
                .addGroup(bgSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgSemestreLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(bgSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgSemestreLayout.createSequentialGroup()
                                .addComponent(textNomBusSem)
                                .addGap(18, 18, 18)
                                .addComponent(comboNomBusSem, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonBuscarSem)
                                .addGap(18, 18, 18)
                                .addComponent(botonAgregarSem))
                            .addGroup(bgSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(bgSemestreLayout.createSequentialGroup()
                                    .addComponent(bontonAtrasSem, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(bontonCancelarSem, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonEliminarSem)
                                    .addGap(18, 18, 18)
                                    .addComponent(botonModificarSem)
                                    .addGap(18, 18, 18)
                                    .addComponent(botonGuardarSem))
                                .addGroup(bgSemestreLayout.createSequentialGroup()
                                    .addComponent(textNomSem)
                                    .addGap(18, 18, 18)
                                    .addComponent(campoNomSem, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(textStaSem)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboStaSem, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(bgSemestreLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(tituloSem)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        bgSemestreLayout.setVerticalGroup(
            bgSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgSemestreLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tituloSem)
                .addGap(40, 40, 40)
                .addGroup(bgSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomBusSem)
                    .addComponent(botonBuscarSem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboNomBusSem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregarSem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(bgSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomSem)
                    .addComponent(campoNomSem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textStaSem)
                    .addComponent(comboStaSem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(bgSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bontonAtrasSem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardarSem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonModificarSem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarSem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bontonCancelarSem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgSemestre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgSemestre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bontonAtrasSemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonAtrasSemMouseClicked

    }//GEN-LAST:event_bontonAtrasSemMouseClicked

    private void bontonAtrasSemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonAtrasSemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonAtrasSemActionPerformed

    private void bontonCancelarSemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonCancelarSemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarSemMouseClicked

    private void bontonCancelarSemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonCancelarSemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarSemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SemestreAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgSemestre;
    private javax.swing.JButton bontonAtrasSem;
    private javax.swing.JButton bontonCancelarSem;
    private javax.swing.JButton botonAgregarSem;
    private javax.swing.JButton botonBuscarSem;
    private javax.swing.JButton botonEliminarSem;
    private javax.swing.JButton botonGuardarSem;
    private javax.swing.JButton botonModificarSem;
    private javax.swing.JTextField campoNomSem;
    private javax.swing.JComboBox<String> comboNomBusSem;
    private javax.swing.JComboBox<String> comboStaSem;
    private javax.swing.JLabel textNomBusSem;
    private javax.swing.JLabel textNomSem;
    private javax.swing.JLabel textStaSem;
    private javax.swing.JLabel tituloSem;
    // End of variables declaration//GEN-END:variables
}
