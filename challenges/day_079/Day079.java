import java.util.ArrayList;
import java.util.List;


public class Day079 {

    static class SistemaPedidos {
        List<Pedido> pedidos = new ArrayList<>();
        List<Entrega> entregas = new ArrayList<>();

        public void registroPedido(Pedido pedido, Entrega entrega) {
            System.out.println("Seu pedido foi registrado: " + pedido);
            System.out.println("Sua entrega foi registrada: " + entrega);
            pedidos.add(pedido);
            entregas.add(entrega);
        }

        public void preparoEntrega(String destino) {
            System.out.println("Preparo da entrega para: " + destino);
            for (int i = 0; i < entregas.size(); i++) {
                if (entregas.get(i).destino.equals(destino)) {
                    System.out.println("Pedido " + pedidos.get(i) + " está pronto para ser entregue para " + destino + ".");
                    break;
                }
            }
        }

        public void listarTudo() {
            for (int i = 0; i < pedidos.size(); i++) {
                System.out.println("Entrega: " + entregas.get(i));
                System.out.println("Pedido: " + pedidos.get(i));
            }
        }
    }

    public static void main(String[] args) {
        SistemaPedidos sistemaPedidos = new SistemaPedidos();

        sistemaPedidos.registroPedido(new Pedido("Pedido1", 10), new Entrega("Destino1", 15.5));
        sistemaPedidos.registroPedido(new Pedido("Pedido2", 5), new Entrega("Destino2", 8.0));
        sistemaPedidos.registroPedido(new Pedido("Pedido3", 3), new Entrega("Destino3", 2.5));

        sistemaPedidos.preparoEntrega("Destino1");
        sistemaPedidos.preparoEntrega("Destino2");

        sistemaPedidos.listarTudo();
    }
}