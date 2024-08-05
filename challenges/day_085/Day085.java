import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day085 {

    static class VendasOnline {
        private List<String> produto;
        private List<Integer> validade;

        public VendasOnline() {
            this.produto = new ArrayList<>();
            this.validade = new ArrayList<>();
        }

        public void adicionarVenda(String produto, int validade) {
            this.produto.add(produto);
            this.validade.add(validade);
        }

        public void geradorRelatorio() {
            System.out.println("Relatório de Vendas:");
            for (int i = 0; i < produto.size(); i++) {
                System.out.println("Produto: " + produto.get(i) + ", Validade: " + validade.get(i));
            }
        }

        public void cadastrarProduto(String produto, int validade) {
            adicionarVenda(produto, validade);
            System.out.println("Produto cadastrado com sucesso: " + produto);
        }

        public void processarPedido(String produto) {
            int index = this.produto.indexOf(produto);
            if (index != -1) {
                System.out.println("Pedido processado para o produto: " + produto);
            } else {
                System.out.println("Produto não encontrado: " + produto);
            }
        }
    }

    public static void main(String[] args) {
        VendasOnline sistemaVendas = new VendasOnline();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Processar Pedido");
            System.out.println("3. Gerar Relatório de Vendas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String produto = scanner.nextLine();
                    System.out.print("Digite a validade do produto (em dias): ");
                    int validade = scanner.nextInt();
                    sistemaVendas.cadastrarProduto(produto, validade);
                    break;
                case 2:
                    System.out.print("Digite o nome do produto para processar o pedido: ");
                    String produtoPedido = scanner.nextLine();
                    sistemaVendas.processarPedido(produtoPedido);
                    break;
                case 3:
                    sistemaVendas.geradorRelatorio();
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }
}
