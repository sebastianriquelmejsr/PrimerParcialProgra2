
package empresadeturismo;

import java.util.ArrayList;
import java.util.Scanner;

public class EmpresaDeTurismo {


    public static void main(String[] args) {
        
    Scanner input = new Scanner(System.in);
    
    ArrayList<Vehiculo> vehiculosLista = new ArrayList<>();
    
    int opcion;    
    
    boolean bandera = true;
                
    while (bandera){
        System.out.println(" --- Empresa de Turismo UTN Avellaneda ---  \n"+
                "/// ° Menu principal ° /// \n"+
                "1. Agregar vehiculo\n" +
                "2. Ver todos los vehiculos\n" +
                "3. Realizar servicios turisticos\n" +
                "4. Buscar vehiculo por patente\n" +
                "5. Ver vehiculos con capacidad mayor a un valor deseado \n" +
                "6. Ver vehiculos ordenados por año de fabricación descendente\n" +
                "7. Ver vehiculos ordenados por capacidad de pasajeros descendente\n" +
                "8. Salir");
        System.out.println("Por favor, ingrese su opcion: ");
        try {
            opcion = Integer.parseInt(input.nextLine());
                switch (opcion) {
                    case 1:
                        agregarVehiculo(vehiculosLista, input);                        
                        break;
                    case 2:
                        mostrarLista(vehiculosLista);
                        break;
                    case 3:
                        serviciosTuristicos(vehiculosLista, input);
                        break;
                    case 4:
                        buscarPatente(vehiculosLista, input);
                        break;
                    case 5:
                        capacidadFlota(vehiculosLista, input);
                        break;
                    case 6:
                        mostrarLista(ordenarLista(vehiculosLista));
                        break;
                    case 7:
                        mostrarLista(ordenarListaPasajeros(vehiculosLista));
                        break;
                    case 8:
                        bandera = false;
                        System.out.println("Gracias por elegirnos, hasta luego! ");
                        break;                       
                    default:
                     System.out.println("Opcion incorrecta, ingrese una opcion valida, por favor"); 
                }   
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un numero valido");
                }
        }     
    }
    
    public static void agregarVehiculo(ArrayList<Vehiculo> vehiculosLista, Scanner input) {
        try{
        System.out.println("Sr usuario, por favor ingrese los siguientes datos");
            String nuevaPatente;
            while(true){
                System.out.println("Ingrese patente: ");
                nuevaPatente = input.nextLine();
                if (nuevaPatente.isEmpty() || nuevaPatente.isBlank()){
                    System.out.println("Por favor, ingrese una patente valida");
                } else if (encontrarPatente(vehiculosLista, nuevaPatente)) {
                    System.out.println("La patente ya existe, no se puede repetir ");
                } else break;                
            }
            
            String nuevaMarca;
            while (true){
                System.out.println("Ingrese marca: ");
                nuevaMarca = input.nextLine();
                if (nuevaMarca.isEmpty() || nuevaMarca.isBlank()){
                    System.out.println("Por favor, ingrese una marca valida");
                } else break;           
            }

            int cantPasajeros;
            while (true){    
                System.out.println("Ingrese cantidad de pasajeros: ");
                cantPasajeros = Integer.parseInt(input.nextLine());
                if (cantPasajeros <= 0){
                    System.out.println("Debe ingresar una cantidad mayor a 0");
                } else break;
            }
            
            int anioDeFab;
            while (true){
                System.out.println("Ingrese anio de fabricacion: ");
                anioDeFab = Integer.parseInt(input.nextLine());
                if (anioDeFab < 1990 || anioDeFab > 2026){
                    System.out.println("El anio debe ser valido (no menor a 1990 ni mayor al actual)");
                } else break;         
            }                
            System.out.println("Que tipo vehiculo desea agregar? \n"
                + "1 - Colectivo \n"
                + "2 - Van ejecutiva \n"
                + "3 Lancha\n"
                + "Ingrese su opcion");
                int opSubMenu;
                opSubMenu = Integer.parseInt(input.nextLine());
        switch (opSubMenu) {
            case 1:
                int cantPisos;
                while (true){
                System.out.println("Cantidad de pisos: (debe ser igual a 1 y no mayor a 2) ");
                cantPisos = Integer.parseInt(input.nextLine());
                    if (cantPisos < 1 || cantPisos > 2){
                        System.out.println("Ingrese una cantidad valida (1 piso o 2 pisos)");
                    } else break;
                }
                vehiculosLista.add(new ColectivoTuristico(nuevaPatente, nuevaMarca, cantPasajeros, anioDeFab,cantPisos));
                System.out.println("Colectivo turistico agregado con exito! ");
                break;
            case 2:
                boolean aireA;
                while(true){
                System.out.println("Cuenta con aire acondicionado? (si/no) ");
                String respuesta = input.nextLine().toLowerCase();
                    if (respuesta.equals("si")){
                        aireA = true;
                        break;
                    } else if (respuesta.equals("no")){
                        aireA = false;
                        break;
                    } else System.out.println("Por favor, indique correctamente si posee A/A (si/no)");
                }
                vehiculosLista.add(new VanEjecutiva(nuevaPatente, nuevaMarca, cantPasajeros, anioDeFab,aireA));
                System.out.println("Van Ejecutiva agregada con exito!");
                break;
            case 3:
                tipoMotor motor = null;
                while(motor == null){
                    System.out.println("Ingrese tipo de motor (1 - NAFTA, 2 - DIESEL, 3 - ELECTRICO)");
                    int opMotor = Integer.parseInt(input.nextLine());                
                    switch (opMotor) {
                        case 1:
                            motor = tipoMotor.NAFTA;
                            break;
                        case 2:
                            motor = tipoMotor.DIESEL;
                            break;
                        case 3:
                            motor = tipoMotor.ELECTRICO;
                            break;
                        default:
                            System.out.println("El motor seleccionado no es valido");
                    }
                }
                vehiculosLista.add(new LanchaTuristica(nuevaPatente, nuevaMarca, cantPasajeros, anioDeFab, motor));
                System.out.println("Lancha turistica agregada con exito");
                break;
            default:
                System.out.println("Opcion incorrecta, ingrese una opcion valida, por favor");        
        }
        }
        catch (NumberFormatException e){
            System.out.println("Ingrese una opcion valida");
        }
        }
    
    public static boolean encontrarPatente(ArrayList <Vehiculo> lista, String patente){
            for (Vehiculo vehiculo : lista) {
                if (vehiculo.getPatente().equalsIgnoreCase(patente)){
                    return true;
                }
            } return false;
        }
    public static void mostrarLista(ArrayList <Vehiculo> lista){
            if (lista.isEmpty()){
                System.out.println("La flota actualmente no esta disponible ");
                return;
            }
            for (Vehiculo vehiculo : lista) {
                System.out.println(vehiculo);       
            }        
        }
    public static void serviciosTuristicos(ArrayList<Vehiculo> lista, Scanner input){
        if (lista.isEmpty()){
            System.out.println("No hay vehiculos disponibles");
            return;
        }
        
        System.out.println("Que tipo de servicio necesita?\n"
                + "1 - Colectivo turistico \n"
                + "2 - Van\n"
                + "3 - Lancha turistica");
        int opServicio = Integer.parseInt(input.nextLine()); 
        boolean vehiculoDisp = false;   
        for (Vehiculo vehiculo : lista) {
            if (opServicio == 1 && vehiculo instanceof ColectivoTuristico){
                vehiculo.realizarServicio();
                vehiculoDisp = true;
                break;
            } 
            else if (opServicio == 2 && vehiculo instanceof VanEjecutiva){
                vehiculo.realizarServicio();
                vehiculoDisp = true;
                break;
            }
            else if (opServicio == 3 && vehiculo instanceof LanchaTuristica){
                vehiculo.realizarServicio();
                vehiculoDisp = true;
                break;
            }  
        }
        if (vehiculoDisp == false){
            System.out.println("El vehiculo solicitado no esta disponible en este momento");
        }
    }
    public static void buscarPatente(ArrayList <Vehiculo> lista, Scanner input){
        if (lista.isEmpty()){
            System.out.println("No hay vehiculos disponibles");
        return;
        }
        System.out.println("Ingrese patente a buscar: ");
        String patente = input.nextLine();
        boolean coincidencia = false;
        for (Vehiculo vehiculo : lista) {
            if (vehiculo.getPatente().equalsIgnoreCase(patente)){
               System.out.println("Se encontro el vehiculo con coincidencia " + vehiculo.toString());
               coincidencia = true;
               break;
            } 
        }
        if (coincidencia == false) System.out.println("No se encontro la patente");
    }
    public static void capacidadFlota(ArrayList<Vehiculo> lista, Scanner input){
        if (lista.isEmpty()){
            System.out.println("No hay vehiculos disponibles");
        return;
        }
        int capacidadUsuario;
        while (true){
            try {    
                System.out.println("Ingrese cantidad de pasajeros deseada: ");
                capacidadUsuario = Integer.parseInt(input.nextLine());
                if (capacidadUsuario <= 0){
                    System.out.println("Debe ingresar una cantidad mayor a 0");
                } else break;
            }                               
            catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            }
        }
        boolean capacidadHallada = false;
        for (Vehiculo vehiculo : lista) {
            if (vehiculo.getCantidadPasajeros() >= capacidadUsuario){
                System.out.println(vehiculo);
                capacidadHallada = true;
                }                
            }
            if (capacidadHallada == false){
                System.out.println("No hay vehiculos con la capacidad seleccionada");
            }
        
        }
    public static ArrayList<Vehiculo> ordenarLista(ArrayList<Vehiculo> lista){
        if (lista.isEmpty()){
            System.out.println("No hay vehiculos disponibles");
        return lista;
        }
        Vehiculo aux;
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.size() - 1; j++) {
                if (lista.get(j).getAnioFabricacion() < lista.get(j + 1).getAnioFabricacion()){
                    aux = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, aux);                   
            }
            }
        }
        return lista;  
    } 
    public static ArrayList<Vehiculo> ordenarListaPasajeros(ArrayList<Vehiculo> lista){
        if (lista.isEmpty()){
            System.out.println("No hay vehiculos disponibles");
        return lista;
        }
        Vehiculo aux;
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.size() - 1; j++) {
                if (lista.get(j).getCantidadPasajeros() < lista.get(j +1).getCantidadPasajeros()){
                    aux = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, aux);                   
            }
            }
        }return lista;  
        } 
    }

        
        
    

