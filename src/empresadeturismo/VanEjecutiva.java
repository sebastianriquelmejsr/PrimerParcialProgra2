
package empresadeturismo;


public class VanEjecutiva extends Vehiculo{
    
    private boolean aireAcondicionado;
    
    public VanEjecutiva(String patente, String marca, int cantidadPasajeros, int anioFabricacion, boolean aireAcondicionado) {
        super(patente, marca, cantidadPasajeros, anioFabricacion);
        this.aireAcondicionado = aireAcondicionado;
    }

    @Override
    public void realizarServicio() {
        System.out.println("La Van Ejecutiva " + getMarca() + " con patente " + getPatente() + " esta realizando el servicio" );
    }

    @Override
    public String toString() {
        return "Van Ejecutiva "+ super.toString() + " Aire Acondicionado " + aireAcondicionado;
    }
    
}
