package grafos;

/**
 *
 * @author dilan
 */
public class Prims {
    GrafoLista grafoS; // grafo sin convertir a arbol
    GrafoLista grafo;
    
    public Prims(GrafoLista grafo){
        this.grafoS = grafo;
        this.grafo = null;
    }
    
    public void convertPrimd(){
        int select = 0;
        boolean limite = false;
        while(!limite){
            select  = (int)(Math.random()*grafoS.getVertices().length+1)-1;
            limite = grafoS.isInArray(select);
        }
        System.out.println(select);
    }

    public GrafoLista getArbol() {
        return grafo;
    }
    
}
