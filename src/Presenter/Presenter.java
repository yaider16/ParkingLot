package Presenter;

import Model.ParkingLot;
import Views.View;

public class Presenter {
    private static final int REGISTRATION = 0;
    private static final int INFO = 1;
    private static final int FREESPACES = 2;
    private static final int OCCUPIEDSPACES = 3;
    private static final int UNREGISTER = 4;


    private ParkingLot parkingLot;
    private View view;
    public void Menu(){
        parkingLot = new ParkingLot();
        view = new View();
        String[] options = new String[]{"Registrar vehiculo", "Informacion de vehiculo", "Espacios libres", "Espacios ocupados", "Desregistrar vehiculo", "Salir"};

        int option = 0;
        while (option!=6){
            option = view.menu(options);
            switching(option);
        }
    }

    public void switching(int option){
        switch (option){
            case REGISTRATION:
                vehicleRegistration();
                break;
            case INFO:
                vehicleInfo();
                break;
            case FREESPACES:
                freeSpaces();
                break;
            case OCCUPIEDSPACES:
                occupiedSpaces();
                break;
            case UNREGISTER:
                vehicleUnregister();
                break;
            case 5:
            default:
                view.message("Gracias por usar el programa");
                System.exit(0);
                break;
        }
    }

    public void vehicleRegistration(){
        String license = view.input("Ingrese la placa del vehiculo");
        int entryHour = Integer.parseInt(view.input("Ingrese la hora de entrada del vehiculo"));
        int entryMin = Integer.parseInt(view.input("Ingrese los minutos de entrada del vehiculo"));

        if (entryHour>24 || entryHour<0 || entryMin>60 || entryMin<0){
            view.message("La hora ingresada no es valida");
            return;
        }
        parkingLot.vehicleRegistration(license,entryHour,entryMin);
        view.message("El vehiculo ha sido registrado en la posicion "+parkingLot.occupiedSpaces());
    }

    public void vehicleInfo(){
        int position = Integer.parseInt(view.input("Ingrese la posicion del vehiculo"));
        if (position>20 || position<0){
            view.message("No hay ningun vehiculo en esa posicion");
            return;
        }else if (parkingLot.vehicleInfo(position).getLicense()==null ){
            view.message("No hay ningun vehiculo en esa posicion");
            return;
        }
        view.message(parkingLot.vehicleInfo(position).toString());
    }

    public void freeSpaces(){
        view.message("Hay "+parkingLot.freeSpaces()+" espacios libres");
    }

    public void occupiedSpaces(){
        view.message("Hay "+parkingLot.occupiedSpaces()+" espacios ocupados");
    }

    public void vehicleUnregister(){
        int position = Integer.parseInt(view.input("Ingrese la posicion del vehiculo"));
        if (parkingLot.vehicleUnregister(position)){
            view.message("El vehiculo ha sido desregistrado");
        }else{
            view.message("No hay ningun vehiculo en esa posicion");
        }
    }

    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        presenter.Menu();
    }
}
