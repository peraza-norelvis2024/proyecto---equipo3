//Norelvis Peraza // Joe Verde // Sophia Estrada // Juan Fonseca // Gloria Sánchez

package vistas;
import javax.swing.JOptionPane;

public class DashboardAdministrador extends javax.swing.JFrame {

    /**
     * @return the reportesEst
     */
    public javax.swing.JMenuItem getReportesEst() {
        return reportesEst;
    }

    /**
     * @return the reportesSec
     */
    public javax.swing.JMenuItem getReportesSec() {
        return reportesSec;
    }

    /**
     * @return the retiroAsignatura
     */
    public javax.swing.JMenuItem getRetiroAsignatura() {
        return retiroAsignatura;
    }

    /**
     * @return the asignatura
     */
    public javax.swing.JMenuItem getAsignatura() {
        return asignatura;
    }

    /**
     * @return the carrera
     */
    public javax.swing.JMenuItem getCarrera() {
        return carrera;
    }

    /**
     * @return the decanato
     */
    public javax.swing.JMenuItem getDecanato() {
        return decanato;
    }

    /**
     * @return the estudiante
     */
    public javax.swing.JMenuItem getEstudiante() {
        return estudiante;
    }

    /**
     * @return the inscripcionEstudiante
     */
    public javax.swing.JMenuItem getInscripcionEstudiante() {
        return inscripcionEstudiante;
    }

    /**
     * @return the periodoAcademico
     */
    public javax.swing.JMenuItem getPeriodoAcademico() {
        return periodoAcademico;
    }

    /**
     * @return the profesor
     */
    public javax.swing.JMenuItem getProfesor() {
        return profesor;
    }

    /**
     * @return the salir
     */
    public javax.swing.JMenuItem getSalir() {
        return salir;
    }

    /**
     * @return the seccion
     */
    public javax.swing.JMenuItem getSeccion() {
        return seccion;
    }

    /**
     * @return the semestre
     */
    public javax.swing.JMenuItem getSemestre() {
        return semestre;
    }
    
    public DashboardAdministrador() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgDashAdmin = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();
        titulo2 = new javax.swing.JLabel();
        imgIzq = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        modulos = new javax.swing.JMenu();
        decanato = new javax.swing.JMenuItem();
        carrera = new javax.swing.JMenuItem();
        semestre = new javax.swing.JMenuItem();
        asignatura = new javax.swing.JMenuItem();
        seccion = new javax.swing.JMenuItem();
        periodoAcademico = new javax.swing.JMenuItem();
        profesor = new javax.swing.JMenuItem();
        estudiante = new javax.swing.JMenuItem();
        inscripcion = new javax.swing.JMenu();
        inscripcionEstudiante = new javax.swing.JMenuItem();
        retiroAsig = new javax.swing.JMenu();
        retiroAsignatura = new javax.swing.JMenuItem();
        reportes = new javax.swing.JMenu();
        reportesSec = new javax.swing.JMenuItem();
        reportesEst = new javax.swing.JMenuItem();
        cerrar = new javax.swing.JMenu();
        salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Dashboard Administrador");
        setResizable(false);

        bgDashAdmin.setBackground(new java.awt.Color(255, 255, 255));
        bgDashAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoDash.png"))); // NOI18N
        bgDashAdmin.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        titulo1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        titulo1.setText("¡GRACIAS POR FORMAR PARTE");
        bgDashAdmin.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        titulo2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        titulo2.setText(" DE NUESTRO EQUIPO!");
        bgDashAdmin.add(titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        imgIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoDashAdmin.png"))); // NOI18N
        bgDashAdmin.add(imgIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 290, 470));

        modulos.setText("Modulos");
        modulos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modulos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        decanato.setText("Decanato");
        decanato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decanatoActionPerformed(evt);
            }
        });
        modulos.add(decanato);

        carrera.setText("Carrera");
        carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreraActionPerformed(evt);
            }
        });
        modulos.add(carrera);

        semestre.setText("Semestre");
        semestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semestreActionPerformed(evt);
            }
        });
        modulos.add(semestre);

        asignatura.setText("Asignatura");
        asignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignaturaActionPerformed(evt);
            }
        });
        modulos.add(asignatura);

        seccion.setText("Sección");
        seccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seccionActionPerformed(evt);
            }
        });
        modulos.add(seccion);

        periodoAcademico.setText("Periodo Académico");
        periodoAcademico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                periodoAcademicoActionPerformed(evt);
            }
        });
        modulos.add(periodoAcademico);

        profesor.setText("Profesor");
        profesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profesorActionPerformed(evt);
            }
        });
        modulos.add(profesor);

        estudiante.setText("Estudiante");
        estudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estudianteActionPerformed(evt);
            }
        });
        modulos.add(estudiante);

        menu.add(modulos);

        inscripcion.setText("Inscripción");
        inscripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inscripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscripcionActionPerformed(evt);
            }
        });

        inscripcionEstudiante.setText("Inscribir Estudiante");
        inscripcion.add(inscripcionEstudiante);

        menu.add(inscripcion);

        retiroAsig.setText("Retiro");
        retiroAsig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retiroAsig.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        retiroAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retiroAsigActionPerformed(evt);
            }
        });

        retiroAsignatura.setText("Retiro de Asignatura");
        retiroAsig.add(retiroAsignatura);

        menu.add(retiroAsig);

        reportes.setText("Reportes");
        reportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        reportesSec.setText("Por Sección");
        reportesSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesSecActionPerformed(evt);
            }
        });
        reportes.add(reportesSec);

        reportesEst.setText("Por Estudiante");
        reportesEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesEstActionPerformed(evt);
            }
        });
        reportes.add(reportesEst);

        menu.add(reportes);

        cerrar.setText("Cerrar");
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        cerrar.add(salir);

        menu.add(cerrar);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgDashAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgDashAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed

    }//GEN-LAST:event_salirActionPerformed

    private void inscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscripcionActionPerformed

    }//GEN-LAST:event_inscripcionActionPerformed

    private void periodoAcademicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodoAcademicoActionPerformed

    }//GEN-LAST:event_periodoAcademicoActionPerformed

    private void decanatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decanatoActionPerformed

    }//GEN-LAST:event_decanatoActionPerformed

    private void carreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carreraActionPerformed

    }//GEN-LAST:event_carreraActionPerformed

    private void semestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semestreActionPerformed

    }//GEN-LAST:event_semestreActionPerformed

    private void asignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignaturaActionPerformed

    }//GEN-LAST:event_asignaturaActionPerformed

    private void seccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seccionActionPerformed

    }//GEN-LAST:event_seccionActionPerformed

    private void profesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profesorActionPerformed

    }//GEN-LAST:event_profesorActionPerformed

    private void estudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estudianteActionPerformed

    }//GEN-LAST:event_estudianteActionPerformed

    private void reportesSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesSecActionPerformed

    }//GEN-LAST:event_reportesSecActionPerformed

    private void retiroAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retiroAsigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retiroAsigActionPerformed

    private void reportesEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportesEstActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem asignatura;
    private javax.swing.JPanel bgDashAdmin;
    private javax.swing.JMenuItem carrera;
    private javax.swing.JMenu cerrar;
    private javax.swing.JMenuItem decanato;
    private javax.swing.JMenuItem estudiante;
    private javax.swing.JLabel imgIzq;
    private javax.swing.JMenu inscripcion;
    private javax.swing.JMenuItem inscripcionEstudiante;
    private javax.swing.JLabel logo;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu modulos;
    private javax.swing.JMenuItem periodoAcademico;
    private javax.swing.JMenuItem profesor;
    private javax.swing.JMenu reportes;
    private javax.swing.JMenuItem reportesEst;
    private javax.swing.JMenuItem reportesSec;
    private javax.swing.JMenu retiroAsig;
    private javax.swing.JMenuItem retiroAsignatura;
    private javax.swing.JMenuItem salir;
    private javax.swing.JMenuItem seccion;
    private javax.swing.JMenuItem semestre;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    // End of variables declaration//GEN-END:variables

    
}
