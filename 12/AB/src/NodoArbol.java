
public class NodoArbol {

    int dato;
    NodoArbol izq;
    NodoArbol der;
    NodoArbol padre;
    int nivel;

    public NodoArbol(int Dato, int nivel, NodoArbol padre) {
        this.dato = Dato;
        this.izq = null;
        this.der = null;
        this.nivel = nivel;
        this.padre = padre;
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
                izq = new NodoArbol(Dato, nivel + 1, this);
            } else {
                izq.insertar(Dato);
            }
        } else {
            if (Dato > dato) {
                if (der == null) {
                    der = new NodoArbol(Dato, nivel + 1, this);
                } else {
                    der.insertar(Dato);
                }
            } else {
                System.out.println("Dato ya existe");
            }
        }
    }

    public NodoArbol tio() {
        if (padre != null) {
            if (padre.padre != null){
                if (padre.padre.izq == padre) {
                    return padre.padre.der;
                } else {
                    return padre.padre.izq;
                }
            } 
        } 
        return null;
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
            return tio();
        }
    }
}
