package Model;

public class ParkingLot {
    private final int MAX_LENGTH=20;
    private  Vehicle[] vehicles;

    public ParkingLot(){
        vehicles= new Vehicle[MAX_LENGTH];
        vehiclesInit();
    }

    public void vehiclesInit(){
        for (int i = 0; i < MAX_LENGTH; i++) {
            this.vehicles[i]= new Vehicle();
        }
    }
    public void vehicleRegistration(String license, int entryHour, int entryMin){
        for (int i =0; i<MAX_LENGTH;i++){
            if (vehicles[i].getLicense()==null){
                vehicles[i]= new Vehicle(license,entryHour,entryMin);
                return;
            }
        }
    }

    public Vehicle vehicleInfo(int position){
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (i==position-1 && vehicles[i]!=null){
                return vehicles[i];
            }
        }
        return null;
    }

    public int freeSpaces(){
        int count = 0;
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (vehicles[i].getLicense()==null){
                count++;
            }
        }
        return count;
    }

    public int occupiedSpaces(){
        int count = 0;
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (vehicles[i].getLicense()!=null){
                count++;
            }
        }
        return count;
    }

    public Boolean vehicleUnregister(int position){
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (i==position-1 && vehicles[i].getLicense()!=null){
                vehicles[i]=null;
                return true;
            }
        }
        return false;
    }
}
