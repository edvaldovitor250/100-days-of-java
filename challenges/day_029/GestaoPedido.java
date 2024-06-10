import java.util.ArrayList;
import java.util.List;

public class GestaoPedido {

    private List<String> nomePedido;
    private List<Integer> valorPedido;
    private List<String> descricaoPedido;

    public GestaoPedido() {
        this.nomePedido = new ArrayList<>();
        this.valorPedido = new ArrayList<>();
        this.descricaoPedido = new ArrayList<>();
    }

    public void listarPedidos() {
        if (nomePedido.isEmpty()) {
            System.out.println("Nenhum pedido encontrado.");
        } else {
            for (int i = 0; i < nomePedido.size(); i++) {
                System.out.println("Pedido " + (i + 1) + ":");
                System.out.println("Nome: " + nomePedido.get(i));
                System.out.println("Valor: " + valorPedido.get(i));
                System.out.println("Descrição: " + descricaoPedido.get(i));
                System.out.println();
            }
        }
    }

    public void adicionarPedido(String nome, int valor, String descricao) {
        this.nomePedido.add(nome);
        this.valorPedido.add(valor);
        this.descricaoPedido.add(descricao);
        System.out.println("Novo Pedido adicionado: " + nome);
        System.out.println("Valor do Pedido adicionado: " + valor);
        System.out.println("Descrição do Pedido adicionado: " + descricao);
    }

    public void atualizarPedido(int index, String nomeAtualizado, int valorAtualizado, String descricaoAtualizado) {
        if (index < 0 || index >= nomePedido.size()) {
            System.out.println("Índice de pedido inválido.");
        } else {
            nomePedido.set(index, nomeAtualizado);
            valorPedido.set(index, valorAtualizado);
            descricaoPedido.set(index, descricaoAtualizado);
            System.out.println("Pedido atualizado: " + nomeAtualizado);
            System.out.println("Valor do Pedido atualizado: " + valorAtualizado);
            System.out.println("Descrição do Pedido atualizado: " + descricaoAtualizado);
        }
    }

    public void removerPedido(int index) {
        if (index < 0 || index >= nomePedido.size()) {
            System.out.println("Índice de pedido inválido.");
        } else {
            String nomeRemovido = nomePedido.remove(index);
            int valorRemovido = valorPedido.remove(index);
            String descricaoRemovida = descricaoPedido.remove(index);
            System.out.println("Pedido removido: " + nomeRemovido);
            System.out.println("Valor do Pedido removido: " + valorRemovido);
            System.out.println("Descrição do Pedido removido: " + descricaoRemovida);
        }
    }
}