package grafos.nodos;

/**
 * Nodo pricipal 
 * @author dilan
 */
public class VNode {
    int dato;
    ENode nextFirst;

    public VNode() {
        this.dato = 0;
        this.nextFirst = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public ENode getNext() {
        return nextFirst;
    }

    public void setNext(ENode next) {
        this.nextFirst = next;
    }
    
    
}
