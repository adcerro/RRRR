package practicaobjetos;

/**
 *
 * @author adcerro
 */
public class Nodo {
    public Persona dato;
    public Nodo link;
    Nodo(Persona p){
        this.dato = p;
        this.link = null;
    }
}
