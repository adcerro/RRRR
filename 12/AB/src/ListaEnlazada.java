
public class ListaEnlazada {

    NodoLista PTR;
    int tam;

    public ListaEnlazada() {
        PTR = null;
        tam = 0;
    }

    public void insertarNodo(int Dato) {
        if (PTR == null) {
            PTR = new NodoLista(Dato);
        } else {
            PTR.insertar(Dato);
        }
    }

    public String show() {
        if (PTR != null) {            
            return "Lista: " + PTR.listar();
        } else {
            return "No hay nodos en este nivel";
        }
    }

}
