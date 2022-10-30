package grafos.nodos;

/**
 * Nodo unido al VNodo
 * @author dilan
 */
public class ENode {

    int position; //la poscion del VNodo orginal al que esta asociado
    float peso;
    ENode next;

    /**
    *  @param unido indica si ya esta unido al arbol
    * @param peso indica el peso de la arista
    **/
    public ENode() {
        this.next = null;
        this.peso = 0;
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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
}
