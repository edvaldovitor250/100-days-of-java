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