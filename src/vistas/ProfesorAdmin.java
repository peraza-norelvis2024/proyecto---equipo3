// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package vistas;

public class ProfesorAdmin extends javax.swing.JFrame {

    /**
     * @return the bontonAtrasProf
     */
    public javax.swing.JButton getBontonAtrasProf() {
        return bontonAtrasProf;
    }

    /**
     * @return the bontonCancelarProf
     */
    public javax.swing.JButton getBontonCancelarProf() {
        return bontonCancelarProf;
    }

    /**
     * @return the botonAgregarProf
     */
    public javax.swing.JButton getBotonAgregarProf() {
        return botonAgregarProf;
    }

    /**
     * @return the botonBuscarProf
     */
    public javax.swing.JButton getBotonBuscarProf() {
        return botonBuscarProf;
    }

    /**
     * @return the botonEliminarProf
     */
    public javax.swing.JButton getBotonEliminarProf() {
        return botonEliminarProf;
    }

    /**
     * @return the botonGuardarProf
     */
    public javax.swing.JButton getBotonGuardarProf() {
        return botonGuardarProf;
    }

    /**
     * @return the botonModificarProf
     */
    public javax.swing.JButton getBotonModificarProf() {
        return botonModificarProf;
    }

    /**
     * @return the campoApeProf
     */
    public javax.swing.JTextField getCampoApeProf() {
        return campoApeProf;
    }

    /**
     * @return the campoCedBusProf
     */
    public javax.swing.JTextField getCampoCedBusProf() {
        return campoCedBusProf;
    }

    /**
     * @return the campoCedProf
     */
    public javax.swing.JTextField getCampoCedProf() {
        return campoCedProf;
    }

    /**
     * @return the campoCorProf
     */
    public javax.swing.JTextField getCampoCorProf() {
        return campoCorProf;
    }

    /**
     * @return the campoDirProf
     */
    public javax.swing.JTextField getCampoDirProf() {
        return campoDirProf;
    }

    /**
     * @return the campoEspProf
     */
    public javax.swing.JTextField getCampoEspProf() {
        return campoEspProf;
    }

    /**
     * @return the campoNomProf
     */
    public javax.swing.JTextField getCampoNomProf() {
        return campoNomProf;
    }

    /**
     * @return the campoTelProf
     */
    public javax.swing.JTextField getCampoTelProf() {
        return campoTelProf;
    }

    
    /**
     * @return the comboStaProf
     */
    public javax.swing.JComboBox<String> getComboStaProf() {
        return comboStaProf;
    }

    public ProfesorAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgProfesor = new javax.swing.JPanel();
        tituloProf = new javax.swing.JLabel();
        textCedBusProf = new javax.swing.JLabel();
        campoCedBusProf = new javax.swing.JTextField();
        botonBuscarProf = new javax.swing.JButton();
        botonAgregarProf = new javax.swing.JButton();
        textCedProf = new javax.swing.JLabel();
        campoCedProf = new javax.swing.JTextField();
        textNomProf = new javax.swing.JLabel();
        campoNomProf = new javax.swing.JTextField();
        textApeProf = new javax.swing.JLabel();
        campoApeProf = new javax.swing.JTextField();
        textDirProf = new javax.swing.JLabel();
        campoDirProf = new javax.swing.JTextField();
        textCorProf = new javax.swing.JLabel();
        campoCorProf = new javax.swing.JTextField();
        textTelProf = new javax.swing.JLabel();
        campoTelProf = new javax.swing.JTextField();
        textEspProf = new javax.swing.JLabel();
        campoEspProf = new javax.swing.JTextField();
        textStaProf = new javax.swing.JLabel();
        comboStaProf = new javax.swing.JComboBox<>();
        bontonAtrasProf = new javax.swing.JButton();
        bontonCancelarProf = new javax.swing.JButton();
        botonEliminarProf = new javax.swing.JButton();
        botonModificarProf = new javax.swing.JButton();
        botonGuardarProf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Profesor");
        setResizable(false);

        bgProfesor.setBackground(new java.awt.Color(41, 144, 159));

        tituloProf.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        tituloProf.setForeground(new java.awt.Color(255, 255, 255));
        tituloProf.setText("GESTIONAR PROFESOR");

        textCedBusProf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textCedBusProf.setForeground(new java.awt.Color(255, 255, 255));
        textCedBusProf.setText("Cédula");

        campoCedBusProf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        botonBuscarProf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonBuscarProf.setText("BUSCAR");
        botonBuscarProf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botonAgregarProf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAgregarProf.setText("AGREGAR");
        botonAgregarProf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        textCedProf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textCedProf.setForeground(new java.awt.Color(255, 255, 255));
        textCedProf.setText("Cédula");

        campoCedProf.setEditable(false);
        campoCedProf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textNomProf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textNomProf.setForeground(new java.awt.Color(255, 255, 255));
        textNomProf.setText("Nombre");

        campoNomProf.setEditable(false);
        campoNomProf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textApeProf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textApeProf.setForeground(new java.awt.Color(255, 255, 255));
        textApeProf.setText("Apellido");

        campoApeProf.setEditable(false);
        campoApeProf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textDirProf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textDirProf.setForeground(new java.awt.Color(255, 255, 255));
        textDirProf.setText("Dirección");

        campoDirProf.setEditable(false);
        campoDirProf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textCorProf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textCorProf.setForeground(new java.awt.Color(255, 255, 255));
        textCorProf.setText("Correo");

        campoCorProf.setEditable(false);
        campoCorProf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textTelProf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textTelProf.setForeground(new java.awt.Color(255, 255, 255));
        textTelProf.setText("Teléfono");

        campoTelProf.setEditable(false);
        campoTelProf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textEspProf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textEspProf.setForeground(new java.awt.Color(255, 255, 255));
        textEspProf.setText("Especialidad");

        campoEspProf.setEditable(false);
        campoEspProf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textStaProf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textStaProf.setForeground(new java.awt.Color(255, 255, 255));
        textStaProf.setText("Estatus");

        bontonAtrasProf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonAtrasProf.setText("ATRAS");
        bontonAtrasProf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonAtrasProf.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonAtrasProf.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonAtrasProf.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonAtrasProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonAtrasProfMouseClicked(evt);
            }
        });
        bontonAtrasProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonAtrasProfActionPerformed(evt);
            }
        });

        bontonCancelarProf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonCancelarProf.setText("CANCELAR");
        bontonCancelarProf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonCancelarProf.setEnabled(false);
        bontonCancelarProf.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonCancelarProf.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonCancelarProf.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonCancelarProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonCancelarProfMouseClicked(evt);
            }
        });
        bontonCancelarProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonCancelarProfActionPerformed(evt);
            }
        });

        botonEliminarProf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEliminarProf.setText("ELIMINAR");
        botonEliminarProf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarProf.setEnabled(false);

        botonModificarProf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonModificarProf.setText("MODIFICAR");
        botonModificarProf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonModificarProf.setEnabled(false);

        botonGuardarProf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonGuardarProf.setText("GUARDAR");
        botonGuardarProf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardarProf.setEnabled(false);

        javax.swing.GroupLayout bgProfesorLayout = new javax.swing.GroupLayout(bgProfesor);
        bgProfesor.setLayout(bgProfesorLayout);
        bgProfesorLayout.setHorizontalGroup(
            bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgProfesorLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgProfesorLayout.createSequentialGroup()
                        .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgProfesorLayout.createSequentialGroup()
                                .addComponent(textEspProf)
                                .addGap(18, 18, 18)
                                .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoCorProf, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoEspProf, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoApeProf, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoCedProf, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(textCedProf))
                        .addGap(54, 54, 54)
                        .addComponent(textNomProf)
                        .addGap(46, 46, 46)
                        .addComponent(campoNomProf, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(bgProfesorLayout.createSequentialGroup()
                        .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgProfesorLayout.createSequentialGroup()
                                .addComponent(bontonAtrasProf, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bontonCancelarProf, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(195, 195, 195)
                                .addComponent(botonEliminarProf)
                                .addGap(18, 18, 18)
                                .addComponent(botonModificarProf)
                                .addGap(18, 18, 18)
                                .addComponent(botonGuardarProf))
                            .addGroup(bgProfesorLayout.createSequentialGroup()
                                .addComponent(textCedBusProf)
                                .addGap(48, 48, 48)
                                .addComponent(campoCedBusProf, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonBuscarProf)
                                .addGap(18, 18, 18)
                                .addComponent(botonAgregarProf))
                            .addGroup(bgProfesorLayout.createSequentialGroup()
                                .addComponent(textApeProf)
                                .addGap(334, 334, 334)
                                .addComponent(textDirProf)
                                .addGap(34, 34, 34)
                                .addComponent(campoDirProf, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgProfesorLayout.createSequentialGroup()
                                .addComponent(textCorProf)
                                .addGap(342, 342, 342)
                                .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textTelProf)
                                    .addComponent(textStaProf))
                                .addGap(38, 38, 38)
                                .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboStaProf, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoTelProf, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(46, Short.MAX_VALUE))))
            .addGroup(bgProfesorLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(tituloProf)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bgProfesorLayout.setVerticalGroup(
            bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgProfesorLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(tituloProf)
                .addGap(30, 30, 30)
                .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgProfesorLayout.createSequentialGroup()
                        .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textCedBusProf)
                            .addComponent(campoCedBusProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBuscarProf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAgregarProf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(textCedProf))
                    .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoCedProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textNomProf)
                        .addComponent(campoNomProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgProfesorLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textApeProf, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoApeProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgProfesorLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textDirProf)
                            .addComponent(campoDirProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCorProf)
                    .addComponent(campoCorProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTelProf)
                    .addComponent(campoTelProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textEspProf)
                        .addComponent(campoEspProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textStaProf)
                        .addComponent(comboStaProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(93, 93, 93)
                .addGroup(bgProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bontonAtrasProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bontonCancelarProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarProf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonModificarProf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardarProf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bontonAtrasProfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonAtrasProfMouseClicked

    }//GEN-LAST:event_bontonAtrasProfMouseClicked

    private void bontonAtrasProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonAtrasProfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonAtrasProfActionPerformed

    private void bontonCancelarProfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonCancelarProfMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarProfMouseClicked

    private void bontonCancelarProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonCancelarProfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarProfActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfesorAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgProfesor;
    private javax.swing.JButton bontonAtrasProf;
    private javax.swing.JButton bontonCancelarProf;
    private javax.swing.JButton botonAgregarProf;
    private javax.swing.JButton botonBuscarProf;
    private javax.swing.JButton botonEliminarProf;
    private javax.swing.JButton botonGuardarProf;
    private javax.swing.JButton botonModificarProf;
    private javax.swing.JTextField campoApeProf;
    private javax.swing.JTextField campoCedBusProf;
    private javax.swing.JTextField campoCedProf;
    private javax.swing.JTextField campoCorProf;
    private javax.swing.JTextField campoDirProf;
    private javax.swing.JTextField campoEspProf;
    private javax.swing.JTextField campoNomProf;
    private javax.swing.JTextField campoTelProf;
    private javax.swing.JComboBox<String> comboStaProf;
    private javax.swing.JLabel textApeProf;
    private javax.swing.JLabel textCedBusProf;
    private javax.swing.JLabel textCedProf;
    private javax.swing.JLabel textCorProf;
    private javax.swing.JLabel textDirProf;
    private javax.swing.JLabel textEspProf;
    private javax.swing.JLabel textNomProf;
    private javax.swing.JLabel textStaProf;
    private javax.swing.JLabel textTelProf;
    private javax.swing.JLabel tituloProf;
    // End of variables declaration//GEN-END:variables
}
