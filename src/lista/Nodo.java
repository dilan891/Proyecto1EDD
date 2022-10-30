package lista;

/**
 *
 * @author dilan
 */
public class Nodo {
    
    private int elemento;
    private Nodo next; 
    
    public Nodo(int elemnto){
        this.elemento = elemnto;
        this.next = null;
    }
    
    public Nodo(){
        this.elemento = -1;
        this.next = null;
    }
    
    public Nodo(int elemnto, Nodo nodo){
        this.elemento = elemnto;
        this.next = nodo;
    }

    /**
     * @return the elemento
     */
    public int getElemento() {
        return elemento;
    }

    /**
     * @param elemento the elemento to set
     */
    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    /**
     * @return the next
     */
    public Nodo getSiguiente() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setSiguiente(Nodo next) {
        this.next = next;
    }
    
    
    
}
