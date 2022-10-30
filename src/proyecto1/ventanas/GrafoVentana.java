package proyecto1.ventanas;

import grafos.GrafoLista;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author dilan
 */
public class GrafoVentana extends javax.swing.JFrame {

    private InicioVentana ventanaAnterior;
    private GrafoLista grafo;

    /**
     * Creates new form Grafo
     *
     * @param grafo grafo que aparecera en la interfaz
     * @param anchoTabla el ancho que tendra la tabla generada
     */
    public GrafoVentana(GrafoLista grafos, int anchoTabla, int altoTabla, InicioVentana ventanAnterior) {
        this.grafo = grafos;
        this.ventanaAnterior = ventanAnterior;
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Laberinto");
        gererarPanel(anchoTabla, altoTabla);
    }

    public void gererarPanel(int anchoTabla, int altoTabla) {
        int alto, ancho, inicialX, inicialY;
        inicialX = 0;//pocision inicial en x de la celda 1
        inicialY = 0;//pocision inicial en y de la celda 1
        alto = 40;//alto de la celda
        ancho = 40;//ancho de la celda
        int nodo = 0;//contador del nodo al que va
        //System.out.println("\nnodos: ");
        for (int i = 0; i < altoTabla; i++) {
            int auxX = inicialX;
            for (int j = 0; j < anchoTabla; j++) {
                int top = 2, left = 2, button = 2, right = 2;
                JPanel nodo1 = new JPanel();
                //System.out.println(grafo.getVertices()[nodo].getDato());
                if (grafo.isIn(nodo, nodo - 1)) { //verifica si el nodo anterior esta en la unido si no es asi borra el borde izquirdo
                    left = 0;
                }
                if (grafo.isIn(nodo, nodo + 1)) {
                    right = 0;
                }
                if (grafo.isIn(nodo, nodo - anchoTabla)) {
                    top = 0;
                }
                if (grafo.isIn(nodo, nodo + anchoTabla)) {
                    button = 0;
                }
                nodo1.setPreferredSize(new Dimension(1500, 1500));
                if (grafo.getFirst() == nodo) {
                    nodo1.setBorder(javax.swing.BorderFactory.createMatteBorder(top, left, button, right, new java.awt.Color(0, 143, 57)));
                }else if(grafo.getLast() == nodo){
                    nodo1.setBorder(javax.swing.BorderFactory.createMatteBorder(top, left, button, right, new java.awt.Color(255, 0, 0)));
                } else {
                    nodo1.setBorder(javax.swing.BorderFactory.createMatteBorder(top, left, button, right, new java.awt.Color(51, 51, 51)));
                }
                jPanel1.add(nodo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(auxX, inicialY, ancho, alto));
                auxX = auxX + ancho;
                nodo++;
            }
            inicialY = inicialY + alto;
        }
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        volver = new javax.swing.JButton();
        botonSolucion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(jPanel1);

        volver.setText("Volver a generar");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        botonSolucion.setText("Solucion");
        botonSolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSolucionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(volver)
                .addGap(112, 112, 112)
                .addComponent(botonSolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volver)
                    .addComponent(botonSolucion))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        ventanaAnterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void botonSolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSolucionActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_botonSolucionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSolucion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
