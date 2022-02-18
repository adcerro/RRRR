package practicaobjetos;

/**
 *
 * @author adcerro
 */
public class Empleado extends Persona{
    private float Salario;
    Empleado(String nombre, String apellido, long id, float salario){
        this.Salario = salario;
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setId(id);
    }

    public float getSalario() {
        return Salario;
    }

    public void setSalario(float salario) {
        this.Salario = salario;
    }
}
