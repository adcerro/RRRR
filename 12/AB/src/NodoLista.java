/**
 *@author David
 */
public class NodoLista {
    int Dato;
    NodoLista Link;

    public NodoLista(int Dato) {
        this.Dato = Dato;
        this.Link = null;
    }    
    
    public void insertar(int Dato){
        if (Link == null){
            Link = new NodoLista(Dato);
        } else{
            Link.insertar(Dato);
        }
    }
    
    public void listar(){
        System.out.print(Dato+" --> ");
        if (Link != null){
            Link.listar();;
        } else{
            System.out.print("nulo");
            System.out.println("");
        }
    }
}
