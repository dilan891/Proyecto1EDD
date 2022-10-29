package grafos.nodos;

/**
 * Nodo unido al VNodo
 * @author dilan
 */
public class ENode {

    int position; //la poscion del VNodo orginal al que esta asociado
    ENode next;

    public ENode() {
        this.next = null;
        this.position = -1;
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

    
    
}
