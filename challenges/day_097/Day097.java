import java.util.ArrayList;
import java.util.List;

public class Day097 {

    public static void main(String[] args) {
        GerenciamentoViagens gerenciamento = new GerenciamentoViagens();

        gerenciamento.fazerReservaVoos("João", "São Paulo", "10/09/2024");
        gerenciamento.fazerReservaHotel("Hotel Central", "Rio de Janeiro", "15/09/2024");
        gerenciamento.fazerReservacarro("Carro Luxo", "Curitiba", "20/09/2024");

        gerenciamento.listarReservas();
    }

    static class GerenciamentoViagens {

        List<String> reservas = new ArrayList<>();

        public void fazerReservaVoos(String passageiro, String destino, String dataSaida) {
            reservas.add(passageiro + " - " + destino + " - " + dataSaida);
        }

        public void fazerReservaHotel(String hotel, String destino, String dataSaida) {
            reservas.add(hotel + " - " + destino + " - " + dataSaida);
        }

        public void fazerReservacarro(String carro, String destino, String dataSaida) {
            reservas.add(carro + " - " + destino + " - " + dataSaida);
        }

        public void listarReservas() {
            for (String reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }
}
