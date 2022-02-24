
public class ListaEnlazada {

    NodoLista PTR;
    int tam;

    public ListaEnlazada() {
        PTR = null;
        tam = 0;
    }

    public int getElem(int num) {
        NodoLista p = PTR;
        int count = 0;
        while (p != null && count != num) {
            p = p.Link;
            count++;
        }
        if (count == num) {
            return p.Dato;
        } else {
            return -1;
        }
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
