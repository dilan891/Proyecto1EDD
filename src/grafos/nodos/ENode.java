package grafos.nodos;

/**
 * Nodo unido al VNodo
 * @author dilan
 */
public class ENode {

    int position; //la poscion del VNodo orginal al que esta asociado
    boolean unido;
    int peso;
    ENode next;

    /**
    *  @param unido indica si ya esta unido al arbol
    * @param peso indica el peso de la arista
    **/
    public ENode() {
        this.next = null;
        this.peso = 0;
        this.position = -1;
        this.unido = false;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ENode getNext() {
        return next;
    }

    public void setNext(ENode next) {
        this.next = next;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
}
