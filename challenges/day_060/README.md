# Day 60

## Desafio:

Desenvolva um aplicativo em Java que simule o funcionamento de um sistema de monitoramento de tráfego rodoviário, permitindo visualizar e analisar o fluxo de veículos em tempo real.

**Resultado:**


```java

import java.util.*;

public class Day060 {

    public static void main(String[] args) {
        TrafficMonitor monitor = new TrafficMonitor();

        monitor.addVehicle(new Vehicle("V001", "Car", 60));
        monitor.addVehicle(new Vehicle("V002", "Truck", 50));
        monitor.addVehicle(new Vehicle("V003", "Bike", 25));

        monitor.displayTraffic();
        monitor.analyzeTraffic();

        monitor.addVehicle(new Vehicle("V004", "Bus", 45));
        monitor.addVehicle(new Vehicle("V005", "Car", 70));

        monitor.displayTraffic();
        monitor.analyzeTraffic();
    }

    static class Vehicle {
        private String id;
        private String type;
        private double speed;

        public Vehicle(String id, String type, double speed) {
            this.id = id;
            this.type = type;
            this.speed = speed;
        }

        public String getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public double getSpeed() {
            return speed;
        }

        @Override
        public String toString() {
            return "Vehicle{" +
                    "id='" + id + '\'' +
                    ", type='" + type + '\'' +
                    ", speed=" + speed +
                    '}';
        }
    }

    static class TrafficMonitor {
        private List<Vehicle> vehicles;

        public TrafficMonitor() {
            vehicles = new ArrayList<>();
        }

        public void addVehicle(Vehicle vehicle) {
            vehicles.add(vehicle);
            System.out.println("Vehicle added: " + vehicle);
        }

        public void displayTraffic() {
            System.out.println("Current Traffic:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }

        public void analyzeTraffic() {
            double totalSpeed = 0;
            for (Vehicle vehicle : vehicles) {
                totalSpeed += vehicle.getSpeed();
            }
            double averageSpeed = vehicles.size() > 0 ? totalSpeed / vehicles.size() : 0;
            System.out.println("Average Speed: " + averageSpeed + " km/h");
        }
    }
}
