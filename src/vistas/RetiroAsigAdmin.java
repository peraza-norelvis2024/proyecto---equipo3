// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package vistas;

public class RetiroAsigAdmin extends javax.swing.JFrame {

    /**
     * @return the bontonCancelarRet
     */
    public javax.swing.JButton getBontonCancelarRet() {
        return bontonCancelarRet;
    }

    /**
     * @return the botonEliminarRet
     */
    public javax.swing.JButton getBotonEliminarRet() {
        return botonEliminarRet;
    }

    /**
     * @return the bontonAtrasRet
     */
    public javax.swing.JButton getBontonAtrasRet() {
        return bontonAtrasRet;
    }

    /**
     * @return the botonBuscarRet
     */
    public javax.swing.JButton getBotonBuscarRet() {
        return botonBuscarRet;
    }

    /**
     * @return the campoApeRet
     */
    public javax.swing.JTextField getCampoApeRet() {
        return campoApeRet;
    }

    /**
     * @return the campoCedRet
     */
    public javax.swing.JTextField getCampoCedRet() {
        return campoCedRet;
    }

    /**
     * @return the campoNomRet
     */
    public javax.swing.JTextField getCampoNomRet() {
        return campoNomRet;
    }

    /**
     * @return the listAsigRet
     */
    public javax.swing.JComboBox<String> getListAsigRet() {
        return listAsigRet;
    }

    public RetiroAsigAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgModificarNota = new javax.swing.JPanel();
        tituloRet = new javax.swing.JLabel();
        textCedRet = new javax.swing.JLabel();
        campoCedRet = new javax.swing.JTextField();
        botonBuscarRet = new javax.swing.JButton();
        textNomRet = new javax.swing.JLabel();
        campoNomRet = new javax.swing.JTextField();
        textApeRet = new javax.swing.JLabel();
        campoApeRet = new javax.swing.JTextField();
        textAsigRet = new javax.swing.JLabel();
        listAsigRet = new javax.swing.JComboBox<>();
        bontonAtrasRet = new javax.swing.JButton();
        bontonCancelarRet = new javax.swing.JButton();
        botonEliminarRet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Retiro De Asignatura");
        setPreferredSize(new java.awt.Dimension(800, 430));
        setResizable(false);

        bgModificarNota.setBackground(new java.awt.Color(41, 144, 159));
        bgModificarNota.setPreferredSize(new java.awt.Dimension(400, 575));

        tituloRet.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        tituloRet.setForeground(new java.awt.Color(255, 255, 255));
        tituloRet.setText("RETIRO DE ASIGNATURA");

        textCedRet.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textCedRet.setForeground(new java.awt.Color(255, 255, 255));
        textCedRet.setText("Cédula");

        campoCedRet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        botonBuscarRet.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonBuscarRet.setText("BUSCAR");

        textNomRet.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textNomRet.setForeground(new java.awt.Color(255, 255, 255));
        textNomRet.setText("Nombre");

        campoNomRet.setEditable(false);

        textApeRet.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textApeRet.setForeground(new java.awt.Color(255, 255, 255));
        textApeRet.setText("Apellido");

        campoApeRet.setEditable(false);

        textAsigRet.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textAsigRet.setForeground(new java.awt.Color(255, 255, 255));
        textAsigRet.setText("Asignatura");

        listAsigRet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        bontonAtrasRet.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonAtrasRet.setText("ATRAS");
        bontonAtrasRet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonAtrasRet.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonAtrasRet.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonAtrasRet.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonAtrasRet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonAtrasRetMouseClicked(evt);
            }
        });

        bontonCancelarRet.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonCancelarRet.setText("CANCELAR");
        bontonCancelarRet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonCancelarRet.setEnabled(false);
        bontonCancelarRet.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonCancelarRet.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonCancelarRet.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonCancelarRet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonCancelarRetMouseClicked(evt);
            }
        });
        bontonCancelarRet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonCancelarRetActionPerformed(evt);
            }
        });

        botonEliminarRet.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEliminarRet.setText("RETIRAR");
        botonEliminarRet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarRet.setEnabled(false);

        javax.swing.GroupLayout bgModificarNotaLayout = new javax.swing.GroupLayout(bgModificarNota);
        bgModificarNota.setLayout(bgModificarNotaLayout);
        bgModificarNotaLayout.setHorizontalGroup(
            bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgModificarNotaLayout.createSequentialGroup()
                .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgModificarNotaLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(tituloRet))
                    .addGroup(bgModificarNotaLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(textCedRet)
                        .addGap(72, 72, 72)
                        .addComponent(campoCedRet, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(botonBuscarRet))
                    .addGroup(bgModificarNotaLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(textAsigRet)
                        .addGap(41, 41, 41)
                        .addComponent(listAsigRet, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgModificarNotaLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(bgModificarNotaLayout.createSequentialGroup()
                                .addComponent(bontonAtrasRet, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bontonCancelarRet, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonEliminarRet, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgModificarNotaLayout.createSequentialGroup()
                                .addComponent(textNomRet)
                                .addGap(64, 64, 64)
                                .addComponent(campoNomRet, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(textApeRet)
                                .addGap(18, 18, 18)
                                .addComponent(campoApeRet, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(47, 47, 47))
        );
        bgModificarNotaLayout.setVerticalGroup(
            bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgModificarNotaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(tituloRet)
                .addGap(39, 39, 39)
                .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgModificarNotaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(textCedRet))
                    .addGroup(bgModificarNotaLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(campoCedRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonBuscarRet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoNomRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoApeRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgModificarNotaLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNomRet)
                            .addComponent(textApeRet))))
                .addGap(27, 27, 27)
                .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgModificarNotaLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(textAsigRet))
                    .addComponent(listAsigRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bontonAtrasRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bontonCancelarRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonEliminarRet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgModificarNota, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgModificarNota, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bontonAtrasRetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonAtrasRetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonAtrasRetMouseClicked

    private void bontonCancelarRetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonCancelarRetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarRetMouseClicked

    private void bontonCancelarRetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonCancelarRetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonCancelarRetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RetiroAsigAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgModificarNota;
    private javax.swing.JButton bontonAtrasRet;
    private javax.swing.JButton bontonCancelarRet;
    private javax.swing.JButton botonBuscarRet;
    private javax.swing.JButton botonEliminarRet;
    private javax.swing.JTextField campoApeRet;
    private javax.swing.JTextField campoCedRet;
    private javax.swing.JTextField campoNomRet;
    private javax.swing.JComboBox<String> listAsigRet;
    private javax.swing.JLabel textApeRet;
    private javax.swing.JLabel textAsigRet;
    private javax.swing.JLabel textCedRet;
    private javax.swing.JLabel textNomRet;
    private javax.swing.JLabel tituloRet;
    // End of variables declaration//GEN-END:variables
}
