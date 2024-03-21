// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package vistas;

public class SeccionAdmin extends javax.swing.JFrame {

    /**
     * @return the bontonAtrasSeccion
     */
    public javax.swing.JButton getBontonAtrasSeccion() {
        return bontonAtrasSeccion;
    }

    /**
     * @return the bontonCancelarSeccion
     */
    public javax.swing.JButton getBontonCancelarSeccion() {
        return bontonCancelarSeccion;
    }

    /**
     * @return the botonAgregarSeccion
     */
    public javax.swing.JButton getBotonAgregarSeccion() {
        return botonAgregarSeccion;
    }

    /**
     * @return the botonBuscarSeccion
     */
    public javax.swing.JButton getBotonBuscarSeccion() {
        return botonBuscarSeccion;
    }

    /**
     * @return the botonEliminarSeccion
     */
    public javax.swing.JButton getBotonEliminarSeccion() {
        return botonEliminarSeccion;
    }

    /**
     * @return the botonGuardarSeccion
     */
    public javax.swing.JButton getBotonGuardarSeccion() {
        return botonGuardarSeccion;
    }

    /**
     * @return the botonModificarSeccion
     */
    public javax.swing.JButton getBotonModificarSeccion() {
        return botonModificarSeccion;
    }

    /**
     * @return the campoMaxEstSec
     */
    public javax.swing.JTextField getCampoMaxEstSec() {
        return campoMaxEstSec;
    }

    /**
     * @return the campoNumSec
     */
    public javax.swing.JTextField getCampoNumSec() {
        return campoNumSec;
    }

    /**
     * @return the comboAsigBusSec
     */
    public javax.swing.JComboBox<String> getComboAsigBusSec() {
        return comboAsigBusSec;
    }

    /**
     * @return the comboAsigSec
     */
    public javax.swing.JComboBox<String> getComboAsigSec() {
        return comboAsigSec;
    }

    /**
     * @return the comboPerAcaBusSec
     */
    public javax.swing.JComboBox<String> getComboPerAcaBusSec() {
        return comboPerAcaBusSec;
    }

    /**
     * @return the comboPerAcaSec
     */
    public javax.swing.JComboBox<String> getComboPerAcaSec() {
        return comboPerAcaSec;
    }

    /**
     * @return the comboProfSec
     */
    public javax.swing.JComboBox<String> getComboProfSec() {
        return comboProfSec;
    }

    /**
     * @return the comboSecciones
     */
    public javax.swing.JComboBox<String> getComboSecciones() {
        return comboSecciones;
    }

    /**
     * @return the comboStaSec
     */
    public javax.swing.JComboBox<String> getComboStaSec() {
        return comboStaSec;
    }

    

    public SeccionAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSeccion = new javax.swing.JPanel();
        tituloSec = new javax.swing.JLabel();
        textPerAcaBusSec = new javax.swing.JLabel();
        comboPerAcaBusSec = new javax.swing.JComboBox<>();
        textAsigBusSec = new javax.swing.JLabel();
        comboAsigBusSec = new javax.swing.JComboBox<>();
        textSecciones = new javax.swing.JLabel();
        comboSecciones = new javax.swing.JComboBox<>();
        botonBuscarSeccion = new javax.swing.JButton();
        botonAgregarSeccion = new javax.swing.JButton();
        textNumSec = new javax.swing.JLabel();
        campoNumSec = new javax.swing.JTextField();
        textPerAcaSec = new javax.swing.JLabel();
        comboPerAcaSec = new javax.swing.JComboBox<>();
        textAsigSec = new javax.swing.JLabel();
        comboAsigSec = new javax.swing.JComboBox<>();
        textProfSec = new javax.swing.JLabel();
        comboProfSec = new javax.swing.JComboBox<>();
        textMaxEstSec = new javax.swing.JLabel();
        campoMaxEstSec = new javax.swing.JTextField();
        textStaSec = new javax.swing.JLabel();
        comboStaSec = new javax.swing.JComboBox<>();
        bontonAtrasSeccion = new javax.swing.JButton();
        bontonCancelarSeccion = new javax.swing.JButton();
        botonEliminarSeccion = new javax.swing.JButton();
        botonModificarSeccion = new javax.swing.JButton();
        botonGuardarSeccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sección");
        setResizable(false);

        bgSeccion.setBackground(new java.awt.Color(41, 144, 159));

        tituloSec.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        tituloSec.setForeground(new java.awt.Color(255, 255, 255));
        tituloSec.setText("GESTIONAR SECCIÓN");

        textPerAcaBusSec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textPerAcaBusSec.setForeground(new java.awt.Color(255, 255, 255));
        textPerAcaBusSec.setText("Periodo Académico");

        comboPerAcaBusSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPerAcaBusSecActionPerformed(evt);
            }
        });

        textAsigBusSec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textAsigBusSec.setForeground(new java.awt.Color(255, 255, 255));
        textAsigBusSec.setText("Asignatura");

        comboAsigBusSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAsigBusSecActionPerformed(evt);
            }
        });

        textSecciones.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textSecciones.setForeground(new java.awt.Color(255, 255, 255));
        textSecciones.setText("Secciones");

        comboSecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSeccionesActionPerformed(evt);
            }
        });

        botonBuscarSeccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonBuscarSeccion.setText("BUSCAR");
        botonBuscarSeccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarSeccionActionPerformed(evt);
            }
        });

        botonAgregarSeccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAgregarSeccion.setText("AGREGAR");
        botonAgregarSeccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        textNumSec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textNumSec.setForeground(new java.awt.Color(255, 255, 255));
        textNumSec.setText("Número");

        campoNumSec.setEditable(false);
        campoNumSec.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textPerAcaSec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textPerAcaSec.setForeground(new java.awt.Color(255, 255, 255));
        textPerAcaSec.setText("Periodo Académico");

        textAsigSec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textAsigSec.setForeground(new java.awt.Color(255, 255, 255));
        textAsigSec.setText("Asignatura");

        comboAsigSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAsigSecActionPerformed(evt);
            }
        });

        textProfSec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textProfSec.setForeground(new java.awt.Color(255, 255, 255));
        textProfSec.setText("Profesor");

        textMaxEstSec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textMaxEstSec.setForeground(new java.awt.Color(255, 255, 255));
        textMaxEstSec.setText("Máximo de Estudiante");

        campoMaxEstSec.setEditable(false);
        campoMaxEstSec.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoMaxEstSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMaxEstSecActionPerformed(evt);
            }
        });

        textStaSec.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textStaSec.setForeground(new java.awt.Color(255, 255, 255));
        textStaSec.setText("Estatus");

        bontonAtrasSeccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonAtrasSeccion.setText("ATRAS");
        bontonAtrasSeccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonAtrasSeccion.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonAtrasSeccion.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonAtrasSeccion.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonAtrasSeccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonAtrasSeccionMouseClicked(evt);
            }
        });
        bontonAtrasSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonAtrasSeccionActionPerformed(evt);
            }
        });

        bontonCancelarSeccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonCancelarSeccion.setText("CANCELAR");
        bontonCancelarSeccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonCancelarSeccion.setEnabled(false);
        bontonCancelarSeccion.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonCancelarSeccion.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonCancelarSeccion.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonCancelarSeccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonCancelarSeccionMouseClicked(evt);
            }
        });
        bontonCancelarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonCancelarSeccionActionPerformed(evt);
            }
        });

        botonEliminarSeccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEliminarSeccion.setText("ELIMINAR");
        botonEliminarSeccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarSeccion.setEnabled(false);

        botonModificarSeccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonModificarSeccion.setText("MODIFICAR");
        botonModificarSeccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonModificarSeccion.setEnabled(false);

        botonGuardarSeccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonGuardarSeccion.setText("GUARDAR");
        botonGuardarSeccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardarSeccion.setEnabled(false);

        javax.swing.GroupLayout bgSeccionLayout = new javax.swing.GroupLayout(bgSeccion);
        bgSeccion.setLayout(bgSeccionLayout);
        bgSeccionLayout.setHorizontalGroup(
            bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgSeccionLayout.createSequentialGroup()
                .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgSeccionLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgSeccionLayout.createSequentialGroup()
                                .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgSeccionLayout.createSequentialGroup()
                                        .addComponent(bontonAtrasSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bontonCancelarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(bgSeccionLayout.createSequentialGroup()
                                        .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textMaxEstSec)
                                            .addComponent(textAsigSec)
                                            .addComponent(textNumSec))
                                        .addGap(18, 18, 18)
                                        .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboAsigSec, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoMaxEstSec, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoNumSec, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboPerAcaBusSec, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgSeccionLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(bgSeccionLayout.createSequentialGroup()
                                                .addComponent(botonEliminarSeccion)
                                                .addGap(18, 18, 18)
                                                .addComponent(botonModificarSeccion)
                                                .addGap(18, 18, 18)
                                                .addComponent(botonGuardarSeccion))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgSeccionLayout.createSequentialGroup()
                                                .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(bgSeccionLayout.createSequentialGroup()
                                                        .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(textProfSec)
                                                            .addComponent(textStaSec))
                                                        .addGap(92, 92, 92))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgSeccionLayout.createSequentialGroup()
                                                        .addComponent(textPerAcaSec)
                                                        .addGap(18, 18, 18)))
                                                .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(comboStaSec, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(comboProfSec, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(comboPerAcaSec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                    .addGroup(bgSeccionLayout.createSequentialGroup()
                                        .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(bgSeccionLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(textAsigBusSec))
                                            .addGroup(bgSeccionLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(botonBuscarSeccion)))
                                        .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(bgSeccionLayout.createSequentialGroup()
                                                .addGap(78, 78, 78)
                                                .addComponent(comboAsigBusSec, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(bgSeccionLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(botonAgregarSeccion))))))
                            .addComponent(textPerAcaBusSec)
                            .addComponent(textSecciones)))
                    .addGroup(bgSeccionLayout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(tituloSec)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        bgSeccionLayout.setVerticalGroup(
            bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgSeccionLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tituloSec)
                .addGap(30, 30, 30)
                .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPerAcaBusSec)
                    .addComponent(comboPerAcaBusSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAsigBusSec)
                    .addComponent(comboAsigBusSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSecciones)
                    .addComponent(comboSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNumSec)
                    .addComponent(campoNumSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPerAcaSec)
                    .addComponent(comboPerAcaSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboProfSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboAsigSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textProfSec)
                        .addComponent(textAsigSec)))
                .addGap(28, 28, 28)
                .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboStaSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoMaxEstSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textStaSec)
                        .addComponent(textMaxEstSec)))
                .addGap(74, 74, 74)
                .addGroup(bgSeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bontonAtrasSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bontonCancelarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonModificarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgSeccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgSeccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bontonAtrasSeccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonAtrasSeccionMouseClicked

    }//GEN-LAST:event_bontonAtrasSeccionMouseClicked

    private void bontonAtrasSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonAtrasSeccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonAtrasSeccionActionPerformed

    private void comboAsigSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAsigSecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAsigSecActionPerformed

    private void comboPerAcaBusSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPerAcaBusSecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPerAcaBusSecActionPerformed

    private void bontonCancelarSeccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonCancelarSeccionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarSeccionMouseClicked

    private void bontonCancelarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonCancelarSeccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarSeccionActionPerformed

    private void campoMaxEstSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMaxEstSecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMaxEstSecActionPerformed

    private void comboAsigBusSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAsigBusSecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAsigBusSecActionPerformed

    private void comboSeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSeccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSeccionesActionPerformed

    private void botonBuscarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarSeccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonBuscarSeccionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeccionAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgSeccion;
    private javax.swing.JButton bontonAtrasSeccion;
    private javax.swing.JButton bontonCancelarSeccion;
    private javax.swing.JButton botonAgregarSeccion;
    private javax.swing.JButton botonBuscarSeccion;
    private javax.swing.JButton botonEliminarSeccion;
    private javax.swing.JButton botonGuardarSeccion;
    private javax.swing.JButton botonModificarSeccion;
    private javax.swing.JTextField campoMaxEstSec;
    private javax.swing.JTextField campoNumSec;
    private javax.swing.JComboBox<String> comboAsigBusSec;
    private javax.swing.JComboBox<String> comboAsigSec;
    private javax.swing.JComboBox<String> comboPerAcaBusSec;
    private javax.swing.JComboBox<String> comboPerAcaSec;
    private javax.swing.JComboBox<String> comboProfSec;
    private javax.swing.JComboBox<String> comboSecciones;
    private javax.swing.JComboBox<String> comboStaSec;
    private javax.swing.JLabel textAsigBusSec;
    private javax.swing.JLabel textAsigSec;
    private javax.swing.JLabel textMaxEstSec;
    private javax.swing.JLabel textNumSec;
    private javax.swing.JLabel textPerAcaBusSec;
    private javax.swing.JLabel textPerAcaSec;
    private javax.swing.JLabel textProfSec;
    private javax.swing.JLabel textSecciones;
    private javax.swing.JLabel textStaSec;
    private javax.swing.JLabel tituloSec;
    // End of variables declaration//GEN-END:variables
}
