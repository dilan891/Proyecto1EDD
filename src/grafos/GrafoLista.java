package grafos;

import grafos.nodos.ENode;
import grafos.nodos.VNode;
import lista.Lista;

/**
 *
 * @author dilan
 */
public final class GrafoLista {
    private VNode[] vertices;
    private int nNodos; //numero de nodos que tendra el grafo
    private Integer[] limites = new Integer[500];
    private int first; //primer nodo del grafo, en caso de que se quiera
    private int last;
    private Lista camino; //un camino de reccorido en el grafo
    
    /**
     * @param nNodos numero de nodos que tendra el grafo
    **/
    public GrafoLista(int nNodos) {
        this.nNodos = nNodos;
        this.vertices = null;
        this.first = -1;
        this.camino = null;
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
        int countLimites = 0;
        float numero = 0;
        for (int i = 0 ; i < vertices.length; i++) {
            numero = (float)(Math.random()*18+0);
            if (i == 0) {
                unir(0, 1,numero);
                unir(1, 0,numero);
                numero = (float)(Math.random()*18+0);
                unir(0, i+ancho,numero);
                unir(i+ancho, 0,numero);
                limites[countLimites] = 0;
                countLimites++;
            }else if(ancho*(fila-1) == i){
                unir(i, i+1,numero);
                if (fila != alto) {
                    numero = (float)(Math.random()*18+0);
                    int nodoAbajo = ancho*fila;//nodo debajo del nodo i
                    unir(i, nodoAbajo,numero);  
                    unir(nodoAbajo,i,numero);
                }
                limites[countLimites] = i;
                countLimites++;
            }else if (i == ((ancho*fila)-1)) {           
                unir(i, i-1,numero);
                //unir((ancho*fila)-2, (ancho*fila)-1);
                if (fila != alto) {
                  numero = (float)(Math.random()*18+0);
                  int nodoAbajo = (ancho*(fila+1))-1;//pocicion del nodo ubicado abajo del nodo i
                  unir(i,nodoAbajo,numero);
                  unir(nodoAbajo,i,numero);  
                }          
                limites[countLimites] = i;
                countLimites++;
                fila++;
            }else{ //el else une todos los nodos que no esten en ezquinas o extremos
                unir(i,i-1,numero);
                numero = (float)(Math.random()*18+0);
                unir(i, i+1,numero);
                if (fila == 1) {
                    limites[countLimites] = i;
                    countLimites++;
                }
                if (fila != alto) {
                    numero = (float)(Math.random()*18+0);
                    int nodoAbajo = i+ancho;//pocicion del nodo ubicado abajo del nodo i
                    unir(i, nodoAbajo,numero);
                    unir(nodoAbajo, i,numero);
                }else{
                    limites[countLimites] = i;
                    countLimites++;
                }
            }
        }
    }
    
    /**
     * Une dos nodos con arcos
     * @param nodo es la posicion del nodo en el que se agrega un arco
     * @param nodoUnido es la poscion del nodo que se va unir
     * @param peso el peso que tendra la arista de los dos nodos
    **/
    public void unir(int nodo,int nodoUnido,float peso){
        ENode nodoU = new ENode();
        nodoU.setPosition(nodoUnido);
        nodoU.setPeso(peso);
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
    
    /**
     * @return retorna la posicion de un limite random
     **/
    public int getRadomLimit(){
        int select = (int)(Math.random()*(1+vertices.length))-1;
        while(!isInLimit(select)){
            select = (int)(Math.random()*(1+vertices.length))-1;
        }
        System.out.println(select);
        return select;
    }
     
    public void mostrarLog(){
        for (int i = 0; i < vertices.length; i++) {
            //System.out.println("\nposicion:  " + i);
            if (vertices[i].getNext() != null) {
                //System.out.println("Contiene al nodo de la posicion: " + vertices[i].getNext().getPosition());
                //System.out.println("contiene los nodos: ");
                ENode aux = vertices[i].getNext();
                while (aux!= null){
                    //System.out.println("--nodo " + aux.getPosition());
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
        while(aux != null){
            if(aux.getPosition() == find){
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }
    
    //verifica si la poscion dada es un limite del grafo
    public boolean isInLimit(int select){
        for (Integer limite : limites) {
            if (limite == null) {
                return false;
            } else if (limite == select) {
                return true;
            }
        }
        return false;
    }
    
    public GrafoLista prims(){
        Prims arbol = new Prims(this);
        arbol.convertPrimd();
        GrafoLista arbolGrado = arbol.getArbolGrafo();
        arbolGrado.setFirst(arbol.getPosicionEntrada());
        arbolGrado.setLast(arbol.getUltimo());
        arbolGrado.setCamino(arbol.getCamino());
        return arbolGrado;
    }

    public Lista getCamino(){
        return camino;
    }
    
    public VNode[] getVertices() {
        return vertices;
    }

    public void setCamino(Lista camino) {
        this.camino = camino;
    }

    
    
    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
    
    public int getFilas() {
        return nNodos;
    }

    public int getFirst() {
        return first;
    }
    
    public void setFilas(int nNodos) {
        this.nNodos = nNodos;
    }  
    
}
