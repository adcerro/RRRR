package practicaobjetos;

/*@author adcerro*/
public class Cliente extends Persona {

    private int compras;

    Cliente(String nombre, String apellido, long id, int compra) {
        compras = compra;
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setId(id);

    }

    public int getCompras() {
        return compras;
    }

    public void setCompras(int compra) {
        this.compras = compra;
    }
}
