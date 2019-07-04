package simulator;

import simulator.weather.Coordinates;
import simulator.weather.WeatherProvider;

import java.lang.*;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    private  void changeWeather(){

    }
}
