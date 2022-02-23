
public class NodoArbol {

    int dato;
    NodoArbol izq;
    NodoArbol der;
    NodoArbol padre;
    NodoArbol tio;
    int nivel;

    public NodoArbol(int Dato, int nivel, NodoArbol padre, NodoArbol tio) {
        this.dato = Dato;
        this.izq = null;
        this.der = null;
        this.nivel = nivel;
        this.padre = padre;
        this.tio = tio;
    }

    public NodoArbol eliminarHoja() {
        if (izq == null && der == null) {
            return null;
        }
        if (izq != null) {
            izq = izq.eliminarHoja();
        }
        if (der != null) {
            der = der.eliminarHoja();
        }
        return this;
    }

    public void insertar(int Dato) {
        if (Dato < dato) {
            if (izq == null) {
                izq = new NodoArbol(Dato, nivel + 1, this, tio(this));
            } else {
                izq.insertar(Dato);
            }
        } else {
            if (Dato > dato) {
                if (der == null) {
                    der = new NodoArbol(Dato, nivel + 1, this, tio(this));
                } else {
                    der.insertar(Dato);
                }
            } else {
                System.out.println("Dato ya existe");
            }
        }
    }

    public NodoArbol tio(NodoArbol nodo) {
        if (nodo.padre != null) {
            if (nodo.padre.izq == nodo) {
                return nodo.padre.der;
            } else {
                return nodo.padre.izq;
            }
        } else {
            return null;
        }
    }

    public NodoArbol buscar(int Dato) {
        if (Dato < dato) {
            if (izq != null) {
                return izq.buscar(Dato);
            } else {
                return null;
            }
        } else if (Dato > dato) {
            if (der != null) {
                return der.buscar(Dato);
            } else {
                return null;
            }
        } else {
            return tio;
        }
    }
}
