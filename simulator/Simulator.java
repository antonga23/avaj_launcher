package simulator;

import simulator.vehicles.Aircraft;
import simulator.vehicles.AircraftFactory;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Simulator {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();
    public static PrintWriter printWriter;

    public static void main(String[] args) throws InterruptedException {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            printWriter = new PrintWriter("simulation.txt");
            if (line != null){
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0){
                    System.out.println("Invalid number of simulations");
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
                    flyables.add(flyable);
                }

                for (Flyable flyable: flyables) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= simulations; i++){
                    weatherTower.changeWeather();
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Sorry mate. Couldn't find the file" + args[0]);
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null,e, "error",JOptionPane.ERROR_MESSAGE);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Give a simulation file");
        } finally {
            if (printWriter != null)
                printWriter.close();
        }
    }
}
