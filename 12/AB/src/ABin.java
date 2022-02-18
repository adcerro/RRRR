
import java.util.Scanner;

/**
 *
 * @author mathisa
 */
public class ABin {

    NodoB Padre;
    NodoB Raiz;

    //Constructor
    public ABin() {
        Raiz = null;
    }

    //Insercion de un elemento en el arbol
    public void insertaNodo(int Elem) {
        if (Raiz == null) {
            Raiz = new NodoB(Elem);
        } else {
            Raiz.insertar(Elem);
        }
    }

    //Escribir arbol
    public void escribir(NodoB Nodo) {
        if (Nodo == null) {
            return;
        } else {
            System.out.print(Nodo.dato + " ");
            escribir(Nodo.Hizq);
            escribir(Nodo.Hder);
        }
    }

    //Preorden Recursivo del arbol
    public void preorden(NodoB Nodo) {
        if (Nodo == null) {
            return;
        } else {
            System.out.print(Nodo.dato + " ");
            preorden(Nodo.Hizq);
            preorden(Nodo.Hder);
        }
    }

    //PostOrden recursivo del arbol
    public void postOrden(NodoB Nodo) {
        if (Nodo == null) {
            return;
        } else {
            postOrden(Nodo.Hizq);
            postOrden(Nodo.Hder);
            System.out.print(Nodo.dato + " ");
        }
    }

    //Inorden Recursivo del arbol
    public void inorden(NodoB Nodo) {
        if (Nodo == null) {
            return;
        } else {
            inorden(Nodo.Hizq);
            System.out.print(Nodo.dato + " ");
            inorden(Nodo.Hder);
        }
    }

//cantidad de niveles que posee el arbol
    public int altura(NodoB Nodo) {
        if (Nodo == null) {
            return -1;
        } else {
            return 1 + Math.max(altura(Nodo.Hizq), altura(Nodo.Hder));
        }
    }
//cantidad de nodos que posee el arbol	

    public int tamaño(NodoB Nodo) {
        if (Nodo == null) {
            return 0;
        } else {
            return 1 + tamaño(Nodo.Hizq) + tamaño(Nodo.Hder);
        }
    }

//cantidad de nodos hojas que posee el arbol	
    public int hojas(NodoB Nodo) {
        if (Nodo == null) {
            return 0;
        } else if (Nodo.Hizq == null && Nodo.Hder == null) {
            return 1;
        } else {
            return hojas(Nodo.Hizq) + hojas(Nodo.Hder);
        }
    }

    //cantidad de nodos completos que posee el arbol	
    public int completos(NodoB Nodo) {
        int cont = 0;
        if (Nodo != null) {
            cont = completos(Nodo.Hizq) + completos(Nodo.Hder);
            if (Nodo.Hizq != null && Nodo.Hder != null) {
                cont = cont + 1;
            }
        }
        return cont;
    }

//Busca un elemento en el arbol
    public void buscar(int Elem, NodoB A) {
        if (A == null) {
            System.out.println("Nodo no encontrado ");
        } else if (A.dato == Elem) {
            System.out.println("Nodo encontrado ");
        } else if (Elem > A.dato) {
            buscar(Elem, A.Hder);
        } else {
            buscar(Elem, A.Hizq);
        }
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        /**
         * ABin A = new ABin(); Scanner sc = new Scanner(System.in); int m = 1,
         * i = 1; while (m == 1) { System.out.print("Digite información numérica
         * del nodo " + i + ":"); int n = sc.nextInt(); A.insertaNodo(n);
         * System.out.print("Desea insertar mas nodos?: (1:Si, 2:No: "); m =
         * sc.nextInt(); i = i + 1; } System.out.print("El recorrido en Preorden
         * es: "); A.preorden(A.Raiz); System.out.println();
         * System.out.print("El recorrido en Inorden es: "); A.inorden(A.Raiz);
         * System.out.println(); System.out.print("El recorrido en Postorden es:
         * "); A.postOrden(A.Raiz); System.out.println(); System.out.println("La
         * altura del arbol es: " + A.altura(A.Raiz)); System.out.println("La
         * cantidad de \"nodos\" que posee el arbol es: " + A.tamaño(A.Raiz));
         * System.out.println("La cantidad de \"nodos hoja\" que posee el arbol
         * es: " + A.hojas(A.Raiz)); System.out.println("La cantidad de \"nodos
         * completos\" que posee el arbol es: " + A.completos(A.Raiz));
         * System.out.print("Digite información numérica del nodo a buscar: ");
         * int nn = sc.nextInt(); A.buscar(nn, A.Raiz);*
         */
    }
}
