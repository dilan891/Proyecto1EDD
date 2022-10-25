package proyecto1.ventanas;

/**
 *
 * @author dilan
 */
public class InicioVentana extends javax.swing.JFrame {

    /**
     * Creates new form InicioVentana
     */
    public InicioVentana() {
        initComponents();
        this.setResizable(false);
        this.setTitle("Generar Laberinto");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nColumnas = new javax.swing.JTextField();
        nFilas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonGenerar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        errorMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(nColumnas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 90, -1));
        jPanel1.add(nFilas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 90, -1));

        jLabel1.setText("Numero de columnas: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 170, -1));

        jLabel2.setText("Numero de filas:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 110, -1));

        botonGenerar.setText("Generar");
        botonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarActionPerformed(evt);
            }
        });
        jPanel1.add(botonGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        jLabel3.setText("Generar Laberinto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        errorMensaje.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errorMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 270, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarActionPerformed
        // TODO add your handling code here:
        try {
            int columnas = Integer.parseInt(nColumnas.getText());
            int filas = Integer.parseInt(nFilas.getText()); 
            if (columnas <= 0 || filas <= 0) {
                System.out.println("numero de columnas o filas invalida");
                errorMensaje.setText("Numero de columnas o filas invalida");
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
            errorMensaje.setText("Error: no se pueden introducir letras");
        }


    }//GEN-LAST:event_botonGenerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGenerar;
    private javax.swing.JLabel errorMensaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nColumnas;
    private javax.swing.JTextField nFilas;
    // End of variables declaration//GEN-END:variables
}
