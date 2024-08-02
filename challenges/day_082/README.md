# Day 82

## Desafio:

		Escreva um programa Java que simule um sistema de gerenciamento de espaços de coworking, incluindo reserva de estações de trabalho e salas de reunião.

**Resultado:**


```java

import java.util.ArrayList;
import java.util.List;

public class Day082 {

    public static class GerenciamenteEspaco {
        List<String> reservas;
        List<String> salas;

        public GerenciamenteEspaco() {
            this.reservas = new ArrayList<>();
            this.salas = new ArrayList<>();
        }

        public void adicionarSala(String nome) {
            this.salas.add(nome);
            System.out.println("Sala " + nome + " adicionada com sucesso!");
        }

        public void reservarSala(String nomeSala, String data, String horario) {
            if (this.salas.contains(nomeSala)) {
                this.reservas.add(nomeSala + " - " + data + " - " + horario);
                System.out.println("Sala reservada com sucesso!");
            } else {
                System.out.println("Sala não encontrada!");
            }
        }

        public void cancelarReserva(String nomeSala, String data, String horario) {
            String reserva = nomeSala + " - " + data + " - " + horario;
            if (this.reservas.contains(reserva)) {
                this.reservas.remove(reserva);
                System.out.println("Reserva cancelada com sucesso!");
            } else {
                System.out.println("Reserva não encontrada!");
            }
        }
    }

    public static void main(String[] args) {
        GerenciamenteEspaco gerenciador = new GerenciamenteEspaco();

        gerenciador.adicionarSala("Sala 101");
        gerenciador.adicionarSala("Sala 102");

        gerenciador.reservarSala("Sala 101", "2024-08-02", "10:00");
        gerenciador.reservarSala("Sala 102", "2024-08-03", "14:00");

        gerenciador.reservarSala("Sala 103", "2024-08-04", "16:00");

        gerenciador.cancelarReserva("Sala 101", "2024-08-02", "10:00");
        gerenciador.cancelarReserva("Sala 102", "2024-08-03", "14:00");

        gerenciador.cancelarReserva("Sala 101", "2024-08-05", "12:00");
    }
}
