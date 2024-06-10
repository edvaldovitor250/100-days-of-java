
public class Day029 {

    public static void main(String[] args) {
        GestaoPedido gestao = new GestaoPedido();

        gestao.adicionarPedido("Pedido1", 100, "Descrição do Pedido 1");
        gestao.adicionarPedido("Pedido2", 200, "Descrição do Pedido 2");

        System.out.println("Listando pedidos:");
        gestao.listarPedidos();

        System.out.println("Atualizando o primeiro pedido:");
        gestao.atualizarPedido(0, "Pedido1 Atualizado", 150, "Descrição do Pedido 1 Atualizada");

        System.out.println("Listando pedidos após atualização:");
        gestao.listarPedidos();

        System.out.println("Removendo o segundo pedido:");
        gestao.removerPedido(1);

        System.out.println("Listando pedidos após remoção:");
        gestao.listarPedidos();
    }
}


