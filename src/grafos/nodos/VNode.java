package grafos.nodos;

/**
 * Nodo pricipal 
 * @author dilan
 */
public class VNode {
    boolean asignado = false;
    int dato;
    ENode nextFirst;

    public VNode() {
        this.dato = 0;
        this.nextFirst = null;
    }

    public boolean isAsignado() {
        return asignado;
    }
    
    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
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
