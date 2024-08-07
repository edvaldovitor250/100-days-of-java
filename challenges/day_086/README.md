# Day 86

## Desafio:

	Escreva um programa Java que simule um sistema de gerenciamento de despesas corporativas, permitindo registrar e categorizar despesas de funcionários.
            
**Resultado:**


```java


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day086 {

    static class DespesasCorporativas {
        List<String> nome;
        List<Double> valor;

        public DespesasCorporativas() {
            nome = new ArrayList<>();
            valor = new ArrayList<>();
        }

        public void adicionarDespesa(String nomeDespesa, double valorDespesa) {
            nome.add(nomeDespesa);
            valor.add(valorDespesa);
            System.out.println("Adicionado com Sucesso!");
        }

        public void listarDespesas() {
            System.out.println("Lista de Despesas:");
            for (int i = 0; i < nome.size(); i++) {
                System.out.println("Despesa: " + nome.get(i) + ", Valor: " + valor.get(i));
            }
        }
    }

    public static void main(String[] args) {
        DespesasCorporativas despesas = new DespesasCorporativas();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Adicionar Despesa");
            System.out.println("2. Listar Despesas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da despesa: ");
                    String nomeDespesa = scanner.nextLine();
                    System.out.print("Digite o valor da despesa: ");
                    double valorDespesa = scanner.nextDouble();
                    despesas.adicionarDespesa(nomeDespesa, valorDespesa);
                    break;
                case 2:
                    despesas.listarDespesas();
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 3);

        scanner.close();
    }
}
