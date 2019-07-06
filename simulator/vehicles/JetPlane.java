package simulator.vehicles;
import simulator.Flyable;
import simulator.WeatherTower;
import simulator.Simulator;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                Simulator.printWriter.println("JetPlane#" + name + "(" + id + "): " + "Radioing in. We need to avoid this thunderstorm, ma bru");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                Simulator.printWriter.println("JetPlane#" + name + "(" + id + "): " + "Radioing in. We need to get above the clouds, ma bru");
                break;
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                Simulator.printWriter.println("JetPlane#" + name + "(" + id + "): " + "Jasis! ma bru. Dis fokken warm, ma bru");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                Simulator.printWriter.println("JetPlane#" + name + "(" + id + "): " + "Jasis! ma bru. It's poes koud, ma bru");
                break;
        }
        if (coordinates.getHeight() == 0) {
            weatherTower.unregister(this);
            Simulator.printWriter.println("JetPlane#" + name + "(" + id + "): is landing ma bru");
            Simulator.printWriter.println("The coordinates are " + coordinates.getLongitude() +"North"
                    + coordinates.getLatitude() +"East"
                    + coordinates.getHeight() + "alathas high");
            Simulator.printWriter.println("Tower says: JetPlane#" + name + "(" + id + ")" + " unregistered from weather tower, ma bru");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.printWriter.println("JetPlane#" + name + "(" + id + "): " + "registered to weather tower.");
    }
}
