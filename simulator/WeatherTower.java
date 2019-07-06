package simulator;

import simulator.vehicles.Coordinates;
import simulator.weather.WeatherProvider;
import java.util.Random;

import java.lang.*;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather(){
        conditionsChanged();
    }
}
