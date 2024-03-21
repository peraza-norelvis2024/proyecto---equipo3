//Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package vistas;

public class ReportesEstudiantesAdmin extends javax.swing.JFrame {

    /**
     * @return the bontonAtrasEstudianteRet
     */
    public javax.swing.JButton getBontonAtrasEstudianteRet() {
        return bontonAtrasEstudianteRet;
    }

    /**
     * @return the comboEstudianteRet
     */
    public javax.swing.JComboBox<String> getComboEstudianteRet() {
        return comboEstudianteRet;
    }

    /**
     * @return the tableEst
     */
    public javax.swing.JTable getTableEst() {
        return tableEst;
    }

    public ReportesEstudiantesAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgResportesEst = new javax.swing.JPanel();
        tituloRepEst = new javax.swing.JLabel();
        textEstudianteRet = new javax.swing.JLabel();
        comboEstudianteRet = new javax.swing.JComboBox<>();
        scrolEst = new javax.swing.JScrollPane();
        tableEst = new javax.swing.JTable();
        bontonAtrasEstudianteRet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reportes De Estudiantes");
        setResizable(false);

        bgResportesEst.setBackground(new java.awt.Color(41, 144, 159));

        tituloRepEst.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        tituloRepEst.setForeground(new java.awt.Color(255, 255, 255));
        tituloRepEst.setText("REPORTES POR ESTUDIANTES");

        textEstudianteRet.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textEstudianteRet.setForeground(new java.awt.Color(255, 255, 255));
        textEstudianteRet.setText("Ver reporte de");

        comboEstudianteRet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboEstudianteRet.setEnabled(false);

        tableEst.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrolEst.setViewportView(tableEst);

        bontonAtrasEstudianteRet.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonAtrasEstudianteRet.setText("ATRAS");
        bontonAtrasEstudianteRet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonAtrasEstudianteRet.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonAtrasEstudianteRet.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonAtrasEstudianteRet.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonAtrasEstudianteRet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonAtrasEstudianteRetMouseClicked(evt);
            }
        });
        bontonAtrasEstudianteRet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonAtrasEstudianteRetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgResportesEstLayout = new javax.swing.GroupLayout(bgResportesEst);
        bgResportesEst.setLayout(bgResportesEstLayout);
        bgResportesEstLayout.setHorizontalGroup(
            bgResportesEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgResportesEstLayout.createSequentialGroup()
                .addGroup(bgResportesEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgResportesEstLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(bgResportesEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrolEst, javax.swing.GroupLayout.PREFERRED_SIZE, 1222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bgResportesEstLayout.createSequentialGroup()
                                .addComponent(textEstudianteRet)
                                .addGap(18, 18, 18)
                                .addComponent(comboEstudianteRet, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bontonAtrasEstudianteRet, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgResportesEstLayout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addComponent(tituloRepEst)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        bgResportesEstLayout.setVerticalGroup(
            bgResportesEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgResportesEstLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(tituloRepEst)
                .addGap(18, 18, 18)
                .addGroup(bgResportesEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEstudianteRet)
                    .addComponent(comboEstudianteRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(scrolEst, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bontonAtrasEstudianteRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgResportesEst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgResportesEst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bontonAtrasEstudianteRetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonAtrasEstudianteRetMouseClicked

    }//GEN-LAST:event_bontonAtrasEstudianteRetMouseClicked

    private void bontonAtrasEstudianteRetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonAtrasEstudianteRetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonAtrasEstudianteRetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportesEstudiantesAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgResportesEst;
    private javax.swing.JButton bontonAtrasEstudianteRet;
    private javax.swing.JComboBox<String> comboEstudianteRet;
    private javax.swing.JScrollPane scrolEst;
    private javax.swing.JTable tableEst;
    private javax.swing.JLabel textEstudianteRet;
    private javax.swing.JLabel tituloRepEst;
    // End of variables declaration//GEN-END:variables
}
