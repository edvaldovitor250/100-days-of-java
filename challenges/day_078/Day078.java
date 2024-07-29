import java.util.ArrayList;
import java.util.List;

public class Day078 {

    static class SistemaPedidos {
        List<String> pedidos = new ArrayList<>();
        List<String> entrega = new ArrayList<>();

        public void registroPedido(String pedido, String entregas) {
            System.out.println("Seu pedido foi registrado: " + pedido);
            System.out.println("Sua entrega foi registrada: " + entregas);
            pedidos.add(pedido);
            entrega.add(entregas);
        }

        public void preparoEntrega(String entregas) {
            System.out.println("Preparo da entrega: " + entregas);
            for (int i = 0; i < pedidos.size(); i++) {
                if (entrega.get(i).equals(entregas)) {
                    System.out.println("Pedido " + pedidos.get(i) + " está pronto para ser entregue.");
                }
            }
        }

        public void listarTudo() {
            for (int i = 0; i < pedidos.size(); i++) {
                System.out.println("Entrega: " + entrega.get(i));
                System.out.println("Pedido: " + pedidos.get(i));
            }
        }
    }

    public static void main(String[] args) {
        SistemaPedidos sistemaPedidos = new SistemaPedidos();

        sistemaPedidos.registroPedido("Pedido1", "Entrega1");
        sistemaPedidos.registroPedido("Pedido2", "Entrega2");
        sistemaPedidos.registroPedido("Pedido3", "Entrega3");

        sistemaPedidos.preparoEntrega("Entrega1");
        sistemaPedidos.preparoEntrega("Entrega2");

        sistemaPedidos.listarTudo();
    }
}
