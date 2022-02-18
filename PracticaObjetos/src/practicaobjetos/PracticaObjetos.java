package practicaobjetos;

/**
 *
 * @author adcerro
 */
public class PracticaObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Pedro", "Pérez", 132654987L, 500);
        Object e2 = new Empleado("Juan", "Gamez", 132654987L, 500);
        Empleado e3 = new Empleado("Julian", "Espitaleta", 132654987L, 500);
        Empleado e4 = (Empleado) e2;
        ListaEnlazada listaPersonas = new ListaEnlazada();
        ListaEnlazada listacli = new ListaEnlazada();
        listaPersonas.agregar(e1);
        listaPersonas.agregar(e4);
        listaPersonas.agregar(e3);
        Empleado e5 = (Empleado) listaPersonas.obtener(1);
        MyFrame frame = new MyFrame(listaPersonas, listacli);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
