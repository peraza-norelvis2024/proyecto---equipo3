// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package vistas;

public class ConsultarSeccionesProf extends javax.swing.JFrame {

    public javax.swing.JButton getBontonAtras() {
        return bontonAtras;
    }

    public javax.swing.JComboBox<String> getListPeriodos() {
        return listPeriodos;
    }

    public javax.swing.JTable getTablaSecciones() {
        return tablaSecciones;
    }

    public ConsultarSeccionesProf() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSecciones = new javax.swing.JPanel();
        tituloSecciones = new javax.swing.JLabel();
        textPeriodos = new javax.swing.JLabel();
        listPeriodos = new javax.swing.JComboBox<>();
        listSecciones = new javax.swing.JScrollPane();
        tablaSecciones = new javax.swing.JTable();
        bontonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consultar Secciones Asiganadas");
        setResizable(false);

        bgSecciones.setBackground(new java.awt.Color(41, 144, 159));

        tituloSecciones.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        tituloSecciones.setForeground(new java.awt.Color(255, 255, 255));
        tituloSecciones.setText("SECCIONES  ASIGNADAS");

        textPeriodos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textPeriodos.setForeground(new java.awt.Color(255, 255, 255));
        textPeriodos.setText("Período Académico");

        listPeriodos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tablaSecciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sección", "Asignatura", "Carrera", "Cantidad de Estudiantes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listSecciones.setViewportView(tablaSecciones);

        bontonAtras.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonAtras.setText("ATRAS");
        bontonAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonAtras.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonAtrasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bgSeccionesLayout = new javax.swing.GroupLayout(bgSecciones);
        bgSecciones.setLayout(bgSeccionesLayout);
        bgSeccionesLayout.setHorizontalGroup(
            bgSeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgSeccionesLayout.createSequentialGroup()
                .addGroup(bgSeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgSeccionesLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(bgSeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(listSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bontonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgSeccionesLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(textPeriodos)
                        .addGap(18, 18, 18)
                        .addComponent(listPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgSeccionesLayout.createSequentialGroup()
                .addComponent(tituloSecciones)
                .addGap(210, 210, 210))
        );
        bgSeccionesLayout.setVerticalGroup(
            bgSeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgSeccionesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(tituloSecciones)
                .addGap(50, 50, 50)
                .addGroup(bgSeccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPeriodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(listSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(bontonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgSecciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgSecciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bontonAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonAtrasMouseClicked
        //Abrir ventana
        DashboardProfesor frm = new DashboardProfesor();
        frm.setVisible(true);
        //Cerrar ventana anterior
        this.dispose();
    }//GEN-LAST:event_bontonAtrasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarSeccionesProf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgSecciones;
    private javax.swing.JButton bontonAtras;
    private javax.swing.JComboBox<String> listPeriodos;
    private javax.swing.JScrollPane listSecciones;
    private javax.swing.JTable tablaSecciones;
    private javax.swing.JLabel textPeriodos;
    private javax.swing.JLabel tituloSecciones;
    // End of variables declaration//GEN-END:variables
}
