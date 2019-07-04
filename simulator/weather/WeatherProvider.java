package simulator.weather;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String weather[] = {"RAIN", "SNOW", "FOG", "SUN"};

    private WeatherProvider(){

    }

    public static WeatherProvider getProvider(){
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        return weather[(coordinates.getHeight() + coordinates.getLattitude() + coordinates.getLongitude()) % 4]; //get sum of coords, apply modlus
    }
}
