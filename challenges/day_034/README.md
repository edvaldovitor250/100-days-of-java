# Day 34

## Desafio:

	Desenvolva um aplicativo Java que simule o funcionamento de um sistema de reserva de passagens aéreas, permitindo a reserva, cancelamento e visualização de voos.

**Resultado:**


```java

import java.util.ArrayList;
import java.util.List;

public class ReservaAereas {

    List<String> reserva;
    List<Integer> dia;

    public ReservaAereas() {
        this.reserva = new ArrayList<>();
        this.dia = new ArrayList<>();
    }

    public void listarReservas() {
        for (int i = 0; i < reserva.size(); i++) {
            System.out.println("Reserva: " + reserva.get(i) + ", Dia: " + dia.get(i));
        }
    }

    public void adicionarReserva(String reserva, int dia) {
        this.reserva.add(reserva);
        this.dia.add(dia);
    }

    public void removerReserva(String reserva) {
        int index = this.reserva.indexOf(reserva);
        if (index != -1) {
            this.reserva.remove(index);
            this.dia.remove(index);
        }
    }
}

public class Day034 {
    public static void main(String[] args) {
        ReservaAereas reservas = new ReservaAereas();

        reservas.adicionarReserva("Reserva 1", 1);
        reservas.adicionarReserva("Reserva 2", 2);
        reservas.adicionarReserva("Reserva 3", 3);

        System.out.println("Listando reservas:");
        reservas.listarReservas();

        System.out.println("Removendo 'Reserva 2':");
        reservas.removerReserva("Reserva 2");

        System.out.println("Listando reservas após a remoção:");
        reservas.listarReservas();
    }

}