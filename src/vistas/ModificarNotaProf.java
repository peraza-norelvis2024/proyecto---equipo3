// Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package vistas;
import javax.swing.JOptionPane;

public class ModificarNotaProf extends javax.swing.JFrame {

    public javax.swing.JButton getBontonCancelar() {
        return bontonCancelar;
    }

    public javax.swing.JButton getBontonGuardar() {
        return bontonGuardar;
    }

    public javax.swing.JButton getBotonBuscar() {
        return botonBuscar;
    }

    public javax.swing.JTextField getCampoCedula() {
        return campoCedula;
    }

    public javax.swing.JComboBox<String> getListAsignatura() {
        return listAsignatura;
    }
    
    
    public ModificarNotaProf() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textAsignatura1 = new javax.swing.JLabel();
        textAsignatura3 = new javax.swing.JLabel();
        bgModificarNota = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        textCedula = new javax.swing.JLabel();
        campoCedula = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        bontonCancelar = new javax.swing.JButton();
        bontonGuardar = new javax.swing.JButton();
        textAsignatura = new javax.swing.JLabel();
        listAsignatura = new javax.swing.JComboBox<>();
        textAsignatura2 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        textAsignatura4 = new javax.swing.JLabel();
        campoApellido = new javax.swing.JTextField();
        textAsignatura5 = new javax.swing.JLabel();
        campoCarrera = new javax.swing.JTextField();
        textAsignatura6 = new javax.swing.JLabel();
        campoSeccion = new javax.swing.JTextField();
        textAsignatura7 = new javax.swing.JLabel();
        campoNota = new javax.swing.JFormattedTextField();
        bontonAtras = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        textAsignatura1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textAsignatura1.setForeground(new java.awt.Color(255, 255, 255));
        textAsignatura1.setText("Asignatura");

        textAsignatura3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textAsignatura3.setForeground(new java.awt.Color(255, 255, 255));
        textAsignatura3.setText("Nombre");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar Nota");
        setResizable(false);

        bgModificarNota.setBackground(new java.awt.Color(41, 144, 159));

        titulo.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("MODIFICAR NOTA");

        textCedula.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textCedula.setForeground(new java.awt.Color(255, 255, 255));
        textCedula.setText("Cédula");

        campoCedula.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        botonBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonBuscar.setText("BUSCAR");

        bontonCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonCancelar.setText("CANCELAR");
        bontonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonCancelar.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonCancelar.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonCancelar.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonCancelarMouseClicked(evt);
            }
        });

        bontonGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonGuardar.setText("GUARDAR");
        bontonGuardar.setToolTipText("");
        bontonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonGuardar.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonGuardarMouseClicked(evt);
            }
        });

        textAsignatura.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textAsignatura.setForeground(new java.awt.Color(255, 255, 255));
        textAsignatura.setText("Asignatura");

        listAsignatura.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textAsignatura2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textAsignatura2.setForeground(new java.awt.Color(255, 255, 255));
        textAsignatura2.setText("Nombre");

        campoNombre.setEditable(false);

        textAsignatura4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textAsignatura4.setForeground(new java.awt.Color(255, 255, 255));
        textAsignatura4.setText("Apellido");

        campoApellido.setEditable(false);

        textAsignatura5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textAsignatura5.setForeground(new java.awt.Color(255, 255, 255));
        textAsignatura5.setText("Carrera");

        campoCarrera.setEditable(false);

        textAsignatura6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textAsignatura6.setForeground(new java.awt.Color(255, 255, 255));
        textAsignatura6.setText("Sección");

        campoSeccion.setEditable(false);

        textAsignatura7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textAsignatura7.setForeground(new java.awt.Color(255, 255, 255));
        textAsignatura7.setText("Nota");

        campoNota.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        bontonAtras.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bontonAtras.setText("ATRAS");
        bontonAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bontonAtras.setMaximumSize(new java.awt.Dimension(93, 21));
        bontonAtras.setMinimumSize(new java.awt.Dimension(93, 21));
        bontonAtras.setPreferredSize(new java.awt.Dimension(82, 31));
        bontonAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bontonAtrasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bgModificarNotaLayout = new javax.swing.GroupLayout(bgModificarNota);
        bgModificarNota.setLayout(bgModificarNotaLayout);
        bgModificarNotaLayout.setHorizontalGroup(
            bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgModificarNotaLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(bgModificarNotaLayout.createSequentialGroup()
                        .addComponent(bontonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bontonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bontonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgModificarNotaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(titulo)
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgModificarNotaLayout.createSequentialGroup()
                        .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgModificarNotaLayout.createSequentialGroup()
                                .addComponent(textCedula)
                                .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgModificarNotaLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textAsignatura4))
                                    .addGroup(bgModificarNotaLayout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(botonBuscar)
                                        .addGap(0, 82, Short.MAX_VALUE))))
                            .addGroup(bgModificarNotaLayout.createSequentialGroup()
                                .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textAsignatura5)
                                    .addGroup(bgModificarNotaLayout.createSequentialGroup()
                                        .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textAsignatura)
                                            .addComponent(textAsignatura2)
                                            .addComponent(textAsignatura7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoNombre)
                                            .addComponent(listAsignatura, 0, 200, Short.MAX_VALUE)
                                            .addComponent(campoCarrera)
                                            .addComponent(campoNota))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textAsignatura6)))
                        .addGap(27, 27, 27)
                        .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(campoSeccion))))
                .addGap(47, 47, 47))
        );
        bgModificarNotaLayout.setVerticalGroup(
            bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgModificarNotaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(titulo)
                .addGap(39, 39, 39)
                .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCedula)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAsignatura)
                    .addComponent(listAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAsignatura2)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAsignatura4)
                    .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAsignatura5)
                    .addComponent(campoCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAsignatura6)
                    .addComponent(campoSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAsignatura7)
                    .addComponent(campoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bontonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgModificarNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bontonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bontonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgModificarNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bgModificarNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bontonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonGuardarMouseClicked

    }//GEN-LAST:event_bontonGuardarMouseClicked

    private void bontonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonCancelarMouseClicked
        //Preguntar si esta seguro de cerrar sesión
    }//GEN-LAST:event_bontonCancelarMouseClicked

    private void bontonAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bontonAtrasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bontonAtrasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarNotaProf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgModificarNota;
    private javax.swing.JButton bontonAtras;
    private javax.swing.JButton bontonCancelar;
    private javax.swing.JButton bontonGuardar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoCarrera;
    private javax.swing.JTextField campoCedula;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JFormattedTextField campoNota;
    private javax.swing.JTextField campoSeccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> listAsignatura;
    private javax.swing.JLabel textAsignatura;
    private javax.swing.JLabel textAsignatura1;
    private javax.swing.JLabel textAsignatura2;
    private javax.swing.JLabel textAsignatura3;
    private javax.swing.JLabel textAsignatura4;
    private javax.swing.JLabel textAsignatura5;
    private javax.swing.JLabel textAsignatura6;
    private javax.swing.JLabel textAsignatura7;
    private javax.swing.JLabel textCedula;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the campoApellido
     */
    public javax.swing.JTextField getCampoApellido() {
        return campoApellido;
    }

    /**
     * @return the campoCarrera
     */
    public javax.swing.JTextField getCampoCarrera() {
        return campoCarrera;
    }

    /**
     * @return the campoNombre
     */
    public javax.swing.JTextField getCampoNombre() {
        return campoNombre;
    }

    /**
     * @return the campoNota
     */
    public javax.swing.JFormattedTextField getCampoNota() {
        return campoNota;
    }

    /**
     * @return the campoSeccion
     */
    public javax.swing.JTextField getCampoSeccion() {
        return campoSeccion;
    }

    /**
     * @return the bontonLimpiar
     */
    public javax.swing.JButton getBontonAtras() {
        return bontonAtras;
    }
}
