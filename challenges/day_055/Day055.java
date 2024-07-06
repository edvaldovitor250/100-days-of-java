import java.util.*;

public class Day055 {
    
    public static void main(String[] args) {
        Hotel hotel = new Hotel(10);
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Reservar Quarto");
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Verificar Quartos Disponíveis");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Digite o número do quarto para reservar: ");
                    int roomToReserve = scanner.nextInt();
                    hotel.reserveRoom(roomToReserve);
                    break;
                case 2:
                    System.out.print("Digite o número do quarto para cancelar a reserva: ");
                    int roomToCancel = scanner.nextInt();
                    hotel.cancelReservation(roomToCancel);
                    break;
                case 3:
                    hotel.displayAvailableRooms();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

class Hotel {
    private boolean[] rooms;
    
    public Hotel(int numberOfRooms) {
        rooms = new boolean[numberOfRooms];
    }
    
    public void reserveRoom(int roomNumber) {
        if (roomNumber < 0 || roomNumber >= rooms.length) {
            System.out.println("Número do quarto inválido.");
        } else if (rooms[roomNumber]) {
            System.out.println("Quarto já está reservado.");
        } else {
            rooms[roomNumber] = true;
            System.out.println("Quarto " + roomNumber + " reservado com sucesso.");
        }
    }
    
    public void cancelReservation(int roomNumber) {
        if (roomNumber < 0 || roomNumber >= rooms.length) {
            System.out.println("Número do quarto inválido.");
        } else if (!rooms[roomNumber]) {
            System.out.println("Quarto não está reservado.");
        } else {
            rooms[roomNumber] = false;
            System.out.println("Reserva do quarto " + roomNumber + " cancelada com sucesso.");
        }
    }
    
    public void displayAvailableRooms() {
        System.out.println("Quartos disponíveis:");
        for (int i = 0; i < rooms.length; i++) {
            if (!rooms[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
