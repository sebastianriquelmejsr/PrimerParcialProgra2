
package empresadeturismo;


public class LanchaTuristica extends Vehiculo {
    
    private tipoMotor tipoMotor;
    
    public LanchaTuristica(String patente, String marca, int cantidadPasajeros, int anioFabricacion, tipoMotor tipoMotor) {
        super(patente, marca, cantidadPasajeros, anioFabricacion);
        this.tipoMotor = tipoMotor;
    }

    @Override
    public void realizarServicio() {
        System.out.println("La lancha " + getMarca() + " patente " + getPatente() + " esta navegando a su servicio");
    }

    public void setTipoMotor(tipoMotor tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    @Override
    public String toString() {
        return "Lancha Turistica " + super.toString() + " tipo de motor: " + tipoMotor;
    }
    
    
    
}
