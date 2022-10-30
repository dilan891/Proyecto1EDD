package grafos;

/**
 *
 * @author dilan
 */
public class Arbol {

    private NodoArbol3 raiz;

    public Arbol() {
        this.raiz = null;
    }

    public NodoArbol3 getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol3 raiz) {
        this.raiz = raiz;
    }

    public void recorrerArbolAgregando(NodoArbol3 nodo, int valorBuscado,int dato) {
        if (nodo != null) {      
            //System.out.println("Estas en el nodo: " + nodo.getDato() + " y buscas: " + valorBuscado);
            if (nodo.getDato() == valorBuscado) { //cuando encuentra el nodo en donde va lo añade 
                //visitar
                System.out.println("Estas en el nodo: " + nodo.getDato() + " y buscas: " + valorBuscado);
                agregar(nodo, dato);          
            } else {//recorrer
                recorrerArbolAgregando(nodo.getNodoA(), valorBuscado,dato);
                recorrerArbolAgregando(nodo.getNodoB(), valorBuscado,dato);
                recorrerArbolAgregando(nodo.getNodoC(), valorBuscado,dato);
            }
            
        }
    }

    public void appendArbol(int posicion, int dato) {
        if (raiz == null) {
            NodoArbol3 nodo = new NodoArbol3();
            nodo.setDato(0);
            raiz = nodo;
        }
        recorrerArbolAgregando(raiz, posicion,dato);
    }

    public void agregar(NodoArbol3 nodo,int dato) {
        NodoArbol3 nuevoNodo = new NodoArbol3();
        nuevoNodo.setDato(dato);
        if (nodo.getNodoA() == null) {
            System.out.println("ejecutando set A");
            nodo.setNodoA(nuevoNodo);
        } else if (nodo.getNodoB() == null) {
            nodo.setNodoB(nuevoNodo);
        } else if (nodo.getNodoC() == null) {
            nodo.setNodoC(nuevoNodo);
        } else {
            System.out.println("todos los espacios estan llenos");
        }
    }

    
    //getters de prueba --borrar
    public int DatoA() {
        return raiz.getNodoA().getDato();
    }
    public int DatoAA() {
        return raiz.getNodoA().getNodoA().getDato();
    }

    public int DatoB() {
        return raiz.getNodoB().getDato();
    }

    public int DatoC() {
        return raiz.getNodoC().getDato();
    }

    public int DatoAB(){
        return raiz.getNodoA().getNodoB().getDato();
    }
    public int DatoBA(){
        return raiz.getNodoB().getNodoA().getDato();
    }
}
