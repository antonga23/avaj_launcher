package simulator.vehicles;
import simulator.Flyable;
import simulator.Simulator;
import simulator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable  {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name,coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                Simulator.printWriter.println("Helicopter#" + name + "(" + id + "): " + "We need to increase our altitude ma bru.");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                Simulator.printWriter.println("Helicopter#" + name + "(" + id + "): " + "Are you jas. I can't see ma bru");
                break;
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                Simulator.printWriter.println("Helicopter#" + name + "(" + id + "): " + "Ma bru dis poes warm.");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                Simulator.printWriter.println("Helicopter#" + name + "(" + id + "): " + "It's poes koud ma bru");
                break;
        }
        if (coordinates.getHeight() == 0) {
            weatherTower.unregister(this);
            Simulator.printWriter.println("Helicopter#" + name + "(" + id + "): is landing am bru.");
            Simulator.printWriter.println("The coordinates are " + coordinates.getLongitude() +"North"
                    + coordinates.getLatitude() +"East"
                    + coordinates.getHeight() + "alathas high");
            Simulator.printWriter.println("Tower says: Helicopter#" + name + "(" + id + ")" + " unregistered from weather tower ma bru.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.printWriter.println("Helicopter#" + name + "(" + id + "): " + "registered to weather tower.");
    }
}
