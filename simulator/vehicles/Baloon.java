package simulator.vehicles;
import simulator.Flyable;
import simulator.WeatherTower;
import simulator.Simulator;


public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                Simulator.printWriter.println("Baloon#" + name + "(" + id + "): " + "Gotta get low. Everything is so slippery ma bru");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                Simulator.printWriter.println("Baloon#" + name + "(" + id + "): " + "Gotta get low. Fog is making it hard to see ma bru");
                break;
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                Simulator.printWriter.println("Baloon#" + name + "(" + id + "): " + "Open the champagne.Soar! Soar! Soar! ma bru");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                Simulator.printWriter.println("Baloon#" + name + "(" + id + "): " + "I'm freezing. let's get low now! ma bru.");
                break;
        }
        if (coordinates.getHeight() == 0) {
            Simulator.printWriter.println("Baloon#" + name + "(" + id + "): is landing ma bru.");
            Simulator.printWriter.println("The coordinates are " + coordinates.getLongitude() +"North"
                    + coordinates.getLatitude() +"East"
                    + coordinates.getHeight() + "alathas high");
            Simulator.printWriter.println("Tower says: Baloon#" + name + "(" + id + ")" + " unregistered from weather tower ma bru.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.printWriter.println("Baloon#" + name + "(" + id + "): " + "registered to weather tower.");
    }
}
