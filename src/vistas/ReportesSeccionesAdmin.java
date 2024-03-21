// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package vistas;

public class ReportesSeccionesAdmin extends javax.swing.JFrame {

    /**
     * @return the bontonAtrasSeccionRet
     */
    public javax.swing.JButton getBontonAtrasSeccionRet() {
        return bontonAtrasSeccionRet;
    }

    /**
     * @return the comboSeccionRet
     */
    public javax.swing.JComboBox<String> getComboSeccionRet() {
        return comboSeccionRet;
    }

    /**
     * @return the comboSeccionesRet
     */
    public javax.swing.JComboBox<String> getComboSeccionesRet() {
        return comboSeccionesRet;
    }

    /**
     * @return the tableSec
     */
    public javax.swing.JTable getTableSec() {
        return tableSec;
    }

    public ReportesSeccionesAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgResportesSec = new javax.swing.JPanel();
        tituloRepSec = new javax.swing.JLabel();
        textSeccionesRet = new javax.swing.JLabel();
        comboSeccionesRet = new javax.swing.JComboBox<>();
        textSeccionRet = new javax.swing.JLabel();
        comboSeccionRet = new javax.swing.JComboBox<>();
        scrollSec = new javax.swing.JScrollPane();
        tableSec = new javax.swing.JTable();
        bontonAtrasSeccionRet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reportes De Secciones");
        setResizable(false);

        bgResportesSec.setBackground(new java.awt.Color(41, 144, 159));

        tituloRepSec.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        tituloRepSec.setForeground(new java.awt.Color(255, 255, 255));
        tituloRepSec.setText("REPORTES POR SECCIONES");

        textSeccionesRet.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textSeccionesRet.setForeground(new java.awt.Color(255, 255, 255));
        textSeccionesRet.setText("Ver reporte de");

        comboSeccionesRet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textSeccionRet.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textSeccionRet.setForeground(new java.awt.Color(255, 255, 255));
        textSeccionRet.setText("Sección");

        comboSeccionRet.setEditable(true);
        comboSeccionRet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboSeccionRet.setEnabled(false);

        tableSec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollSec.setViewportView(tableSec);

        bontonAtrasSeccionRet.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonAtrasSeccionRet.setText("ATRAS");
        bontonAtrasSeccionRet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonAtrasSeccionRet.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonAtrasSeccionRet.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonAtrasSeccionRet.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonAtrasSeccionRet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonAtrasSeccionRetMouseClicked(evt);
            }
        });
        bontonAtrasSeccionRet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bontonAtrasSeccionRetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgResportesSecLayout = new javax.swing.GroupLayout(bgResportesSec);
        bgResportesSec.setLayout(bgResportesSecLayout);
        bgResportesSecLayout.setHorizontalGroup(
            bgResportesSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgResportesSecLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloRepSec)
                .addGap(449, 449, 449))
            .addGroup(bgResportesSecLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(bgResportesSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bontonAtrasSeccionRet, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgResportesSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollSec, javax.swing.GroupLayout.PREFERRED_SIZE, 1222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(bgResportesSecLayout.createSequentialGroup()
                            .addComponent(textSeccionesRet)
                            .addGap(18, 18, 18)
                            .addComponent(comboSeccionesRet, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textSeccionRet)
                            .addGap(18, 18, 18)
                            .addComponent(comboSeccionRet, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        bgResportesSecLayout.setVerticalGroup(
            bgResportesSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgResportesSecLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(tituloRepSec)
                .addGap(23, 23, 23)
                .addGroup(bgResportesSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgResportesSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textSeccionesRet)
                        .addComponent(comboSeccionesRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgResportesSecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textSeccionRet)
                        .addComponent(comboSeccionRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addComponent(scrollSec, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bontonAtrasSeccionRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgResportesSec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgResportesSec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bontonAtrasSeccionRetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonAtrasSeccionRetMouseClicked

    }//GEN-LAST:event_bontonAtrasSeccionRetMouseClicked

    private void bontonAtrasSeccionRetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bontonAtrasSeccionRetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonAtrasSeccionRetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportesSeccionesAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgResportesSec;
    private javax.swing.JButton bontonAtrasSeccionRet;
    private javax.swing.JComboBox<String> comboSeccionRet;
    private javax.swing.JComboBox<String> comboSeccionesRet;
    private javax.swing.JScrollPane scrollSec;
    private javax.swing.JTable tableSec;
    private javax.swing.JLabel textSeccionRet;
    private javax.swing.JLabel textSeccionesRet;
    private javax.swing.JLabel tituloRepSec;
    // End of variables declaration//GEN-END:variables
}
