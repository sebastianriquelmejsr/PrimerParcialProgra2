
package empresadeturismo;


public class ColectivoTuristico extends Vehiculo{
    
    private int cantidadPisos;
    
    public ColectivoTuristico(String patente, String marca, int cantidadPasajeros, int anioFabricacion, int cantidadPisos) {
        super(patente, marca, cantidadPasajeros, anioFabricacion);
        this.cantidadPisos = cantidadPisos;
    }

    @Override
    public void realizarServicio() {
        System.out.println("El Colectivo Turistico " + getMarca() + " Patente " + getPatente() + " esta realizando el servicio. ");
    }

    @Override
    public String toString() {
        return "Colectivo Turistico " + super.toString() + " cantidad de pisos: " + cantidadPisos;
    }
    
}
