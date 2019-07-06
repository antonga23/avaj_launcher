package simulator;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Tower {

    private List<Flyable> flyables = new ArrayList<>();

    public void register(Flyable flyable){
        this.flyables.add(flyable);
    }

    public void unregister(Flyable flyable){
        this.flyables.remove(flyable);
    }

    protected void conditionsChanged(){
        for(int i =0; i <flyables.size();i++ ){
            flyables.get(i).updateConditions();
        }

    }
}
