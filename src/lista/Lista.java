package lista;

/**
 *
 * @author dilan
 */
public class Lista{

    private Nodo last;
    private Nodo first;
    private int size;

    public Lista() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public Nodo getLast() {
        return last;
    }

    public void setLast(Nodo last) {
        this.last = last;
    }

    public Nodo getFirst() {
        return first;
    }

    public void setFirst(Nodo first) {
        this.first = first;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int length() {
        return this.size;
    }

    public void appendPDeficient(int position, int dato) {  //no es muy eficiente
        if (position < size) {
            Nodo nuevo = new Nodo(dato);
            Nodo aux1 = this.first;
            Lista aux = new Lista();
            for (int i = 0; i < this.size + 1; i++) {
                if (i == 0) {//colcar en la primera posicion
                    if (position == 0) {
                        nuevo.setSiguiente(this.first);
                        aux1 = nuevo;
                        aux.setFirst(nuevo);
                    } else {
                        aux.setFirst(this.first);
                    }
                }
                if (position - 1 == i && position != 0) {
                    nuevo.setSiguiente(aux1.getSiguiente());
                    aux1.setSiguiente(nuevo);
                }
                if (i == position && i != 0) {
                    aux1 = nuevo;
                }
                aux.setLast(aux1);
                aux1 = aux1.getSiguiente();
            }
            this.first = aux.getFirst();
            this.last = aux.getLast();
            this.size += 1;
        } else {
            System.out.println("Posicicion no valida");
        }

    }

    public void generarCopia(Lista lista){
        Lista copia = new Lista();
        Nodo aux = lista.getFirst();
        while(aux != null){
            copia.append(aux.getElemento());
            aux = aux.getSiguiente();
        }
        first = copia.getFirst();
        last = copia.getLast();
        size = copia.length();
    }
    
    public void append(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (this.isEmpty()) {
            this.first = nuevo;
            this.last = nuevo;
        } else {
            Nodo aux = this.last;
            aux.setSiguiente(nuevo);
            this.last = nuevo;
        }
        size++;
    }

    public void removed(int position) {
        if (position == 0){
            first = first.getSiguiente();
        }else{
            Nodo aux1 = this.first;
            for (int i = 0; i < size - 1; i++) {
                if (i == position - 1) {
                    aux1.setSiguiente(aux1.getSiguiente().getSiguiente());
                    break;
                }
                aux1 = aux1.getSiguiente();
            }
        }
        
        this.size--;
    }

    public void mostrar() {
        if (!this.isEmpty()) {
            Nodo aux = first;
            for (int i = 0; i < size; i++) {
                System.out.println(aux.getElemento() + " ");
                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("lista vacia");
        }
    }
//    
//    public String mostrarIndice(int position){
//        Nodo aux = first;
//        if (position >= size){
//            System.out.println("La posicion no existe dentro de la lista");
//            throw new Error("La posicion no existe dentro de la lista");
//        }
//        for (int i = 0; i <= position; i++) {
//            if (i == position){
//                return aux.getElemento().toString();
//            }
//            aux = aux.getSiguiente();
//        }
//        return "";
//    }
//
}
