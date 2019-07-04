package simulator.vehicles;
import simulator.weather.Coordinates;

import java.lang.*;



public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter; //maybe i should initialise it to 0???

    protected Aircraft(String name, Coordinates coordinates){
        this.coordinates = coordinates;
        this.name = name;
    }

    private long nextId(){
     return idCounter++;
    }
}

