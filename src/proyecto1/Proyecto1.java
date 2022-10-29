package proyecto1;

import grafos.GrafoLista;
import proyecto1.ventanas.GrafoVentana;
import proyecto1.ventanas.InicioVentana;

public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        System.out.println("Laberinto");
//        InicioVentana v = new InicioVentana();
//        v.setVisible(true);
        
        int ancho = 4; //numero de ancho del laberinto
        int alto = 4; //numero de alto del laberinto
        int nNodos = alto * ancho; //numero de nodos que tendra el grafo a generar
        
        GrafoLista grafo2 = new GrafoLista(nNodos);
        grafo2.generarTabla(ancho,alto);
        grafo2.mostrarLog();
        
        GrafoVentana ventana = new GrafoVentana(grafo2,ancho,alto);
        ventana.setVisible(true);
        
//        GrafoMatriz grafo1 = new GrafoMatriz(4, false);
//       
//        InterfazMatriz ventana = new InterfazMatriz(grafo1.getMaxNodos(),grafo1.getMatrizAdy());
//        ventana.setVisible(true);
//        grafo1.mostrarMatriz();

        
    }
    
}
