package simulator.vehicles;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        if (longitude <= 0)
            return longitude = 0;
        else
            return longitude;
    }

    public int getLatitude() {
        if (latitude <= 0)
            return latitude  = 0;
        else
            return latitude;
    }

    public int getHeight() {
        if (height <= 0){
            return height = 0;
        }
        else if (height >= 100)
            return height = 100;
        else
            return height;
        //do some error handling on height. Should strictly be between 0 and 100
    }
}

