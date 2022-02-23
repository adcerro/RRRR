
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ABin {

    NodoArbol Padre;
    NodoArbol Raiz;

    //Constructor
    public ABin() {
        Raiz = null;
    }

    private int getLevel(NodoArbol raiz, NodoArbol n) {
        if (raiz == null) {
            return 0;
        } else if (raiz.dato == n.dato) {
            return 0;
        } else if (raiz.dato < n.dato) {
            return 1 + getLevel(raiz.der, n);
        } else {
            return 1 + getLevel(raiz.izq, n);
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

    public int getLevelOf(NodoArbol raiz, NodoArbol node) {
        if (this.contains(node.dato, raiz)) {
            return this.getLevel(raiz, node);
        } else {
            return -1;
        }
    }

    public String getNodesFromLevel(NodoArbol raiz, NodoArbol iterator, int level) {
        if (raiz == null) {
            return "";
        } else if (getLevelOf(raiz, iterator) == level) {
            return iterator.dato + "";
        } else if (getLevelOf(raiz, iterator) < level) {
            return "" + getNodesFromLevel(raiz, iterator.izq, level) + "->" + getNodesFromLevel(raiz, iterator.der, level);
        } else {
            return "";
        }
    }

    //Insercion de un elemento en el arbol
    public void insertarNodo(int Elem) {
        if (Raiz == null) {
            Raiz = new NodoArbol(Elem, 0, null, null);
        } else {
            Raiz.insertar(Elem);
        }
    }
    Timer timer = new Timer();

    public void EliminarArbol() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                frame.getPanel().repaint();
                frame.drawTree(Raiz, 300, 20, frame.getPanel().getGraphics(), 150);
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

    public void CrearLista(NodoArbol nodo, int nivel, ListaEnlazada lis) {
        if (nodo == null) {
            return;
        } else {
            if (nodo.nivel == nivel) {
                lis.insertarNodo(nodo.dato);
            }
            CrearLista(nodo.izq, nivel, lis);
            CrearLista(nodo.der, nivel, lis);
        }
    }

//cantidad de niveles que posee el arbol
    public int altura(NodoArbol Nodo) {
        if (Nodo == null) {
            return -1;
        } else {
            return 1 + Math.max(altura(Nodo.izq), altura(Nodo.der));
        }
    }

//cantidad de nodos hojas que posee el arbol	
    public int hojas(NodoArbol Nodo) {
        if (Nodo == null) {
            return 0;
        } else if (Nodo.izq == null && Nodo.der == null) {
            return 1;
        } else {
            return hojas(Nodo.izq) + hojas(Nodo.der);
        }
    }

    static MyFrame frame = new MyFrame();

    ;
    public static void main(String[] args) {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
