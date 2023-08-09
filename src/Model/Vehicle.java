package Model;

public class Vehicle{
        private int entryHour;
        private int entryMin;
        private String license;

        public Vehicle(){

        }
        public Vehicle(String license, int entryHour, int entryMin){
            this.license=license;
            this.entryHour=entryHour;
            this.entryMin=entryMin;
        }

        public int getEntryHour(){
            return entryHour;
        }
        public int getEntryMin(){
            return entryMin;
        }
        public String getLicense(){
            return license;
        }

    @Override
    public String toString() {
        return "El vehiculo con placa "+license+" ingreso a las "+entryHour+":"+entryMin+" horas";
    }
}
