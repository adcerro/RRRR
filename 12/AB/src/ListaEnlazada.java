
/**
 *@author David
 */
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

    public void listar() {
        if (PTR != null) {
            PTR.listar();
        } else {
            System.out.println("No hay nodos en este nivel");
        }
    }

}
