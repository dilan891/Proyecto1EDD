package grafos;

/**
 *
 * @author dilan
 */
class NodoArbol3 {
    private int dato;
    private NodoArbol3 nodoA;
    private NodoArbol3 nodoB;
    private NodoArbol3 nodoC;
    private boolean isSalida;

    public NodoArbol3() {
        this.nodoA = null;
        this.nodoB = null;
        this.nodoC = null;
        this.isSalida = false;
    }

    public NodoArbol3 getNodoA() {
        return nodoA;
    }

    public void setNodoA(NodoArbol3 nodoA) {
        this.nodoA = nodoA;
    }

    public NodoArbol3 getNodoB() {
        return nodoB;
    }

    public void setNodoB(NodoArbol3 nodoB) {
        this.nodoB = nodoB;
    }

    public NodoArbol3 getNodoC() {
        return nodoC;
    }

    public void setNodoC(NodoArbol3 nodoC) {
        this.nodoC = nodoC;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public boolean isIsSalida() {
        return isSalida;
    }

    public void setIsSalida(boolean isSalida) {
        this.isSalida = isSalida;
    }
    
    
}
