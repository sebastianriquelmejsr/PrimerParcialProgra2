
package empresadeturismo;


public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int cantidadPasajeros;
    private int anioFabricacion;

    public Vehiculo(String patente, String marca, int cantidadPasajeros, int anioFabricacion) {
        this.patente = patente;
        this.marca = marca;
        this.cantidadPasajeros = cantidadPasajeros;
        this.anioFabricacion = anioFabricacion;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }
    public abstract void realizarServicio();

    @Override
    public String toString() {
        return "patente: " + patente + ", marca: " + marca + ", cantidad de pasajeros: " + cantidadPasajeros + ", Anio de fabricacion " + anioFabricacion;
    }


    
}
