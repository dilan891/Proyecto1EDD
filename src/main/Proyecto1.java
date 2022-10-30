package main;

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
        
        int ancho = 8; //numero de ancho del laberinto
        int alto = 8; //numero de alto del laberinto
        int nNodos = alto * ancho; //numero de nodos que tendra el grafo a generar

        GrafoLista grafoPrueba = new GrafoLista(nNodos);
        grafoPrueba.unir(2, 1, 0);
        grafoPrueba.unir(1, 2, 0);
        grafoPrueba.unir(24, 19, 0);
        grafoPrueba.unir(19, 24, 0);
  
        InicioVentana v = new InicioVentana();//interfez de pedida de datos
        v.setVisible(true);
        
    }
    
}
