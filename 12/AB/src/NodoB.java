/**
 *
 * @author mathisa
 */
public class NodoB {

    int dato;
    NodoB Hizq, Hder;

    //Constructores
    NodoB(int Elem) {
        dato = Elem;
        NodoB Hizq, Hder = null;
    }

    public void insertar(int Elem) {
        if (Elem < dato) {
            if (Hizq == null) {
                Hizq = new NodoB(Elem);
            } else {
                Hizq.insertar(Elem);
            }
        } else {
            if (Elem > dato) {
                if (Hder == null) {
                    Hder = new NodoB(Elem);
                } else {
                    Hder.insertar(Elem);
                }
            }
            else{
                System.out.println("Dato ya existe");
            }
        }
    }
}
