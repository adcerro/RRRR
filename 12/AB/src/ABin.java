
import java.util.Timer;
import java.util.TimerTask;

public class ABin {

    NodoArbol Raiz;
    Timer timer;

    //Constructor
    public ABin() {
        Raiz = null;
        timer = new Timer();
    }

    public void createLevelList(NodoArbol nodo, int nivel, ListaEnlazada lis) {
        if (nodo == null) {
            return;
        } else {
            if (nodo.nivel == nivel) {
                lis.insertarNodo(nodo.dato);
            }
            createLevelList(nodo.izq, nivel, lis);
            createLevelList(nodo.der, nivel, lis);
        }
    }

    public void eliminarNodoHoja(int dato, NodoArbol iterator, ABin tree) {
        NodoArbol der = iterator.der;
        NodoArbol izq = iterator.izq;
        if (tree.Raiz.dato == dato) {
            tree.Raiz = null;
        } else {
            if (der.dato == dato) {
                der = null;
                iterator.der = null;
            } else if (izq.dato == dato) {
                izq = null;
                iterator.izq = null;
            } else if (iterator.dato < dato) {
                eliminarNodoHoja(dato, der, tree);
            } else {
                eliminarNodoHoja(dato, izq, tree);
            }
        }
    }

    public boolean contains(int Elem, NodoArbol A) {
        if (A == null) {
            return false;
        } else if (A.dato == Elem) {
            return true;
        } else if (Elem > A.dato) {
            return contains(Elem, A.der);
        } else {
            return contains(Elem, A.izq);
        }
    }

    //Insercion de un elemento en el arbol
    public void insertarNodo(int Elem) {
        if (Raiz == null) {
            Raiz = new NodoArbol(Elem, 0, null);
        } else {
            Raiz.insertar(Elem);
        }
    }

    public void EliminarArbol() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                EliminarHoja();
            }
        };
        timer.schedule(task, 0, 1500);
    }

    public void EliminarHoja() {
        if (Raiz == null) {
            timer.cancel();
        } else {
            Raiz = Raiz.eliminarHoja();
            System.out.println("Hoja eliminada");
        }
    }

    public NodoArbol buscarTio(int dato) {
        if (Raiz == null) {
            return null;
        } else {
            return Raiz.buscar(dato);
        }
    }

    public int altura(NodoArbol Nodo) {
        if (Nodo == null) {
            return -1;
        } else {
            return 1 + Math.max(altura(Nodo.izq), altura(Nodo.der));
        }
    }

    public int hojas(NodoArbol Nodo) {
        if (Nodo == null) {
            return 0;
        } else if (Nodo.izq == null && Nodo.der == null) {
            return 1;
        } else {
            return hojas(Nodo.izq) + hojas(Nodo.der);
        }
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
