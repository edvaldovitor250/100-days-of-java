# Day 70

## Desafio:

	Escreva um programa Java que simule um sistema de gerenciamento de eventos, permitindo criar, editar e cancelar eventos, e gerar ingressos.
    
**Resultado:**


```java

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day070 {

    static class Event {
        private String name;
        private String date;
        private String location;
        private int ticketsAvailable;

        public Event(String name, String date, String location, int ticketsAvailable) {
            this.name = name;
            this.date = date;
            this.location = location;
            this.ticketsAvailable = ticketsAvailable;
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getTicketsAvailable() {
            return ticketsAvailable;
        }

        public void setTicketsAvailable(int ticketsAvailable) {
            this.ticketsAvailable = ticketsAvailable;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "name='" + name + '\'' +
                    ", date='" + date + '\'' +
                    ", location='" + location + '\'' +
                    ", ticketsAvailable=" + ticketsAvailable +
                    '}';
        }
    }

    static class EventManager {
        private List<Event> events;

        public EventManager() {
            events = new ArrayList<>();
        }

        public void createEvent(String name, String date, String location, int ticketsAvailable) {
            events.add(new Event(name, date, location, ticketsAvailable));
            System.out.println("Evento criado com sucesso.");
        }

        public void editEvent(String name, String newDate, String newLocation, int newTicketsAvailable) {
            for (Event event : events) {
                if (event.getName().equals(name)) {
                    event.setDate(newDate);
                    event.setLocation(newLocation);
                    event.setTicketsAvailable(newTicketsAvailable);
                    System.out.println("Evento editado com sucesso.");
                    return;
                }
            }
            System.out.println("Evento não encontrado.");
        }

        public void cancelEvent(String name) {
            for (Event event : events) {
                if (event.getName().equals(name)) {
                    events.remove(event);
                    System.out.println("Evento cancelado com sucesso.");
                    return;
                }
            }
            System.out.println("Evento não encontrado.");
        }

        public void generateTicket(String eventName) {
            for (Event event : events) {
                if (event.getName().equals(eventName) && event.getTicketsAvailable() > 0) {
                    event.setTicketsAvailable(event.getTicketsAvailable() - 1);
                    System.out.println("Ingresso gerado para o evento: " + eventName);
                    return;
                }
            }
            System.out.println("Evento não encontrado ou ingressos esgotados.");
        }

        public void listEvents() {
            if (events.isEmpty()) {
                System.out.println("Nenhum evento disponível.");
            } else {
                for (Event event : events) {
                    System.out.println(event);
                }
            }
        }
    }

    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Criar evento");
            System.out.println("2. Editar evento");
            System.out.println("3. Cancelar evento");
            System.out.println("4. Gerar ingresso");
            System.out.println("5. Listar eventos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (choice) {
                case 1:
                    System.out.print("Nome do evento: ");
                    String name = scanner.nextLine();
                    System.out.print("Data do evento: ");
                    String date = scanner.nextLine();
                    System.out.print("Local do evento: ");
                    String location = scanner.nextLine();
                    System.out.print("Ingressos disponíveis: ");
                    int tickets = scanner.nextInt();
                    eventManager.createEvent(name, date, location, tickets);
                    break;
                case 2:
                    System.out.print("Nome do evento a ser editado: ");
                    String editName = scanner.nextLine();
                    System.out.print("Nova data do evento: ");
                    String newDate = scanner.nextLine();
                    System.out.print("Novo local do evento: ");
                    String newLocation = scanner.nextLine();
                    System.out.print("Novos ingressos disponíveis: ");
                    int newTickets = scanner.nextInt();
                    eventManager.editEvent(editName, newDate, newLocation, newTickets);
                    break;
                case 3:
                    System.out.print("Nome do evento a ser cancelado: ");
                    String cancelName = scanner.nextLine();
                    eventManager.cancelEvent(cancelName);
                    break;
                case 4:
                    System.out.print("Nome do evento para gerar ingresso: ");
                    String ticketEvent = scanner.nextLine();
                    eventManager.generateTicket(ticketEvent);
                    break;
                case 5:
                    eventManager.listEvents();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
