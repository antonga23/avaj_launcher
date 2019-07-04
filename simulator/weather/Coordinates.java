package simulator.weather;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Coordinates {
    private int longitude;
    private int lattitude;
    private int height;

    private Coordinates(int longitude, int lattitude, int height){
        this.longitude = longitude;
        this.lattitude = lattitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLattitude() {
        return lattitude;
    }

    public int getHeight() {
        //do some error handling on height. Should strictly be between 0 and 100
        return height;
    }
}

