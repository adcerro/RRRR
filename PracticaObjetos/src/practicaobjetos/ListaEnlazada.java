package practicaobjetos;

/**
 *
 * @author adcerro
 */
public class ListaEnlazada {

    public Nodo ptr;
    public Nodo ult;
    public int tamaño;

    public ListaEnlazada() {
        ptr = new Nodo(null);
        ult = ptr;
        tamaño = 0;
    }

    public void agregar(Persona per) {
        Nodo nuevoNodo = new Nodo(per);
        ult.link = nuevoNodo;
        ult = nuevoNodo;
        tamaño++;
    }

    public boolean existe(Persona per) {
        Nodo p = ptr.link;
        boolean exists = false;
        while(p != null){
            if (p.dato.getNombre().contentEquals(per.getNombre()) && p.dato.getApellido().contentEquals(per.getApellido()) && p.dato.getId() == per.getId() || p.dato.getId() == per.getId()) {
                exists = true;
            }
            p = p.link;
        }
        return exists;
    }

    public Persona obtener(int i) {
        if (i > tamaño) {
            throw new IndexOutOfBoundsException();
        }
        Nodo nodo = ptr;
        if (i != 0) {
            for (int j = 0; j < i; j++) {
                nodo = nodo.link;
            }
            return nodo.dato;
        }
        return nodo.dato;
    }

    public int tamaño() {
        return tamaño;
    }
}
