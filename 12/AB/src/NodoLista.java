
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
    
    public String listar(){
        if (Link != null){
            return Dato+""+" --> "+Link.listar();
        } else{
            return Dato+""+" --> nulo";
        }
    }
}
