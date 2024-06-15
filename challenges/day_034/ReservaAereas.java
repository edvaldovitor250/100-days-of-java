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