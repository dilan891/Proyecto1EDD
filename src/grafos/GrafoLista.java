package grafos;

import grafos.nodos.ENode;
import grafos.nodos.VNode;




/**
 *
 * @author dilan
 */
public class GrafoLista {
    private VNode[] vertices;
    private int nNodos; //numero de nodos que tendra el grafo

    /**
     * @param nNodos numero de nodos que tendra el grafo
    **/
    public GrafoLista(int nNodos) {
        this.nNodos = nNodos;
        this.vertices = null;
        createLista();
    }
    
    /**
     * crea la lista que contendra los nodos
    **/
    public void createLista(){
        VNode[] vert = new VNode[nNodos];
        for (int i = 0; i < vert.length; i++) {
            vert[i] = new VNode();
            vert[i].setDato(i);
        }
        vertices = vert;
    }
    
    /**
     * Recorre el array vertices y une los respectivos nodos con aristas
     * @param ancho El ancho que tendra la tabla
     * @param alto El alto que tendra la tabla
    **/
    public void generarTabla(int ancho,int alto){
        int fila = 1;//fila que va por el recorrido
        for (int i = 0 ; i < vertices.length; i++) {
            if (i == 0) {
                unir(0, 1);
                unir(1, 0);
                unir(0, i+ancho);
                unir(i+ancho, 0);
            }else if(ancho*(fila-1) == i){
                unir(i, i+1);
                if (fila != alto) {
                    int nodoAbajo = ancho*fila;//nodo debajo del nodo i
                    unir(i, nodoAbajo);
                    unir(nodoAbajo,i);
                }
            }else if (i == ((ancho*fila)-1)) {           
                //System.out.println((ancho*fila)-1);
                unir(i, i-1);
                //unir((ancho*fila)-2, (ancho*fila)-1);
                if (fila != alto) {
                  int nodoAbajo = (ancho*(fila+1))-1;//pocicion del nodo ubicado abajo del nodo i
                  unir(i,nodoAbajo);
                  unir(nodoAbajo,i);  
                }               
                fila++;
            }else{ //el else une todos los nodos que no esten en ezquinas o extremos
                unir(i,i-1);
                unir(i, i+1);
                if (fila != alto) {
                    int nodoAbajo = i+ancho;//pocicion del nodo ubicado abajo del nodo i
                    unir(i, nodoAbajo);
                    unir(nodoAbajo, i);
                }
            }
        }
    }
    
    /**
     * Une dos nodos con arcos
     * @param nodo es la posicion del nodo en el que se agrega un arco
     * @param nodoUnido es la poscion del nodo que se va unir
    **/
    public void unir(int nodo,int nodoUnido){
        ENode nodoU = new ENode();
        nodoU.setPosition(nodoUnido);
        if (vertices[nodo].getNext() == null){
            vertices[nodo].setNext(nodoU); //inecesesario
        }else{
            ENode aux = vertices[nodo].getNext();
            while(aux != null){
                if (aux.getNext() == null) {
                    aux.setNext(nodoU);
                    break;
                }
                aux = aux.getNext();
            }
        } 
        //unir(nodoUnido,nodo); implementar para que quede guardado en los dos
    }
    
    public void mostrarLog(){
        for (int i = 0; i < vertices.length; i++) {
            System.out.println("\nposicion:  " + i);
            if (vertices[i].getNext() != null) {
                //System.out.println("Contiene al nodo de la posicion: " + vertices[i].getNext().getPosition());
                System.out.println("contiene los nodos: ");
                ENode aux = vertices[i].getNext();
                while (aux!= null){
                    System.out.println("--nodo " + aux.getPosition());
                    aux = aux.getNext();
                }
            }else{
                System.out.println("nothing");
            }
        }
    }
    
    /**
     * Busca si el nodo tiene una arista con el otro
     * @param pNodo posicion del nodo
     * @param find posicion del nodo que se busca
    **/
    public boolean isIn(int pNodo,int find){
        ENode aux = vertices[pNodo].getNext();
        while(aux !=null){
            if(aux.getPosition()==find){
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public VNode[] getVertices() {
        return vertices;
    }
    
    public int getFilas() {
        return nNodos;
    }

    public void setFilas(int nNodos) {
        this.nNodos = nNodos;
    }
    
    
    
}
