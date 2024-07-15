# Day 64

## Desafio:

	Implemente um algoritmo em Java para calcular o fluxo máximo em um grafo usando o algoritmo de Ford-Fulkerson.	
    
**Resultado:**


```java

import java.util.*;

public class Day063 {

    static class Appointment {
        String customerName;
        String serviceName;
        Date appointmentDate;

        public Appointment(String customerName, String serviceName, Date appointmentDate) {
            this.customerName = customerName;
            this.serviceName = serviceName;
            this.appointmentDate = appointmentDate;
        }

        @Override
        public String toString() {
            return "Appointment{" +
                    "customerName='" + customerName + '\'' +
                    ", serviceName='" + serviceName + '\'' +
                    ", appointmentDate=" + appointmentDate +
                    '}';
        }
    }

    static class Service {
        String name;
        double price;

        public Service(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Service{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    static class Product {
        String name;
        int quantity;

        public Product(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }

    List<Appointment> appointments = new ArrayList<>();
    List<Service> services = new ArrayList<>();
    List<Product> products = new ArrayList<>();

    public void addAppointment(String customerName, String serviceName, Date appointmentDate) {
        appointments.add(new Appointment(customerName, serviceName, appointmentDate));
    }

    public List<Appointment> getAppointment
