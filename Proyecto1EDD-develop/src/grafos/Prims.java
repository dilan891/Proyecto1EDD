package grafos;

import grafos.nodos.ENode;
import grafos.nodos.VNode;
import lista.Lista;

/**
 *
 * @author dilan
 */
public class Prims {

    private GrafoLista grafoS; // grafo sin convertir a arbol
    private GrafoLista grafo;
    private int posicionEntrada;
    private int ultimo;//salida del laberinto

    public Prims(GrafoLista grafo) {
        this.grafoS = grafo;
        this.grafo = null;
        this.ultimo = -1;
    }

    public void convertPrimd() {
        Arbol arbol = new Arbol();
        int select = 0;
        boolean limite = false;
        while (!limite) {
            select = (int) (Math.random() * grafoS.getVertices().length + 1) - 1;
            limite = grafoS.isInLimit(select);
        }
        VNode first = grafoS.getVertices()[select];
        first.setAsignado(true);
        posicionEntrada = select;       
        //agarra la arista de menor peso
        VNode auxRecorrido = first;
        int count = 1;
        this.grafo = new GrafoLista(grafoS.getVertices().length);
        Lista recorrdido = new Lista();
        while (true) { //cambiar
            float auxMenor = 9999;
            int positionMenor = 0;       
            boolean haySiguiente = false;//indica si todavia hay nodos siguientes no asigandos
            ENode aux = auxRecorrido.getNext();
            if (recorrdido.isEmpty()) {
                recorrdido.append(first.getDato());
            }
            while (aux != null) {
                if (aux.getPeso() < auxMenor && !grafoS.getVertices()[aux.getPosition()].isAsignado()) {
                    auxMenor = aux.getPeso();
                    positionMenor = aux.getPosition();
                    haySiguiente = true;
                }
                aux = aux.getNext();
            }
            if (haySiguiente == false && auxRecorrido.equals(first)) {
                //System.out.println("no mas datos");
                try{
                    first = grafoS.getVertices()[recorrdido.getFirst().getSiguiente().getElemento()]; //first sera igual al segundo elemento del recorrido
                }catch(NullPointerException e){
                    System.out.println("Termino...");
                    break;
                }             
                //auxRecorrido = first;
                recorrdido.removed(0);
            } else if (haySiguiente == false) {
                //System.out.println("El nodo " + auxRecorrido.getDato() + " se une con ninguno");
                auxRecorrido = first;
            } else { //aqui se crea el nuevo grafo
                //System.out.println("El nodo " + auxRecorrido.getDato() + " se une con: " + positionMenor);
                grafo.unir(auxRecorrido.getDato(), positionMenor, 0);
                grafo.unir(positionMenor, auxRecorrido.getDato(), 0);
                arbol.appendArbol(auxRecorrido.getDato(), positionMenor);
                auxRecorrido = grafoS.getVertices()[positionMenor];
                recorrdido.append(positionMenor);
            }
            auxRecorrido.setAsignado(true);
            count++;
        }
        NodoArbol3 raiz = arbol.getRaiz();
        while(ultimo == -1||ultimo == posicionEntrada){    
            ultimo = grafoS.getRadomLimit();
            arbol.setUltimo(raiz, ultimo);
        }
        //grafo.mostrarLog();
        //System.out.println(arbol.DatoA());
        arbol.recorridoSalida(raiz); //genera la lista de recorrido hasta la salida del laberinto
        //arbol.getCaminoSalida().mostrar();
    }

    public int getPosicionEntrada() {
        return posicionEntrada;
    }

    public GrafoLista getArbol() {
        return grafo;
    }

    public int getUltimo() {
        return ultimo;
    }

}
