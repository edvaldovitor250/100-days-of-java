# Day 61

## Desafio:

	Implemente um sistema em Java para gerenciar uma escola de idiomas, incluindo matrículas, aulas e avaliações de alunos.
    
**Resultado:**


```java
import java.util.*;

public class Day062 {
    
    public static void main(String[] args) {
        GerenciamentoGastos sistema = new GerenciamentoGastos();
        sistema.menuPrincipal();
    }

    static class GerenciamentoGastos {
        List<Despesa> despesas;

        public GerenciamentoGastos() {
            despesas = new ArrayList<>();
        }

        public void registrarDespesa(String descricao, double valor, String categoria) {
            Despesa despesa = new Despesa(descricao, valor, categoria);
            despesas.add(despesa);
            System.out.println("Despesa registrada com sucesso.");
        }

        public void listarDespesas() {
            System.out.println("Despesas registradas:");
            for (Despesa despesa : despesas) {
                System.out.println(despesa);
            }
        }

        public void gerarRelatorioPorCategoria(String categoria) {
            double total = 0;
            System.out.println("Relatório de despesas para a categoria: " + categoria);
            for (Despesa despesa : despesas) {
                if (despesa.getCategoria().equalsIgnoreCase(categoria)) {
                    System.out.println(despesa);
                    total += despesa.getValor();
                }
            }
            System.out.println("Total gasto na categoria " + categoria + ": " + total);
        }

        public void menuPrincipal() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n--- Sistema de Gerenciamento de Gastos Pessoais ---");
                System.out.println("1. Registrar Despesa");
                System.out.println("2. Listar Despesas");
                System.out.println("3. Gerar Relatório por Categoria");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Descrição da despesa: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Valor da despesa: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Categoria da despesa: ");
                        String categoria = scanner.nextLine();
                        registrarDespesa(descricao, valor, categoria);
                        break;
                    case 2:
                        listarDespesas();
                        break;
                    case 3:
                        System.out.print("Informe a categoria para o relatório: ");
                        String categoriaRelatorio = scanner.nextLine();
                        gerarRelatorioPorCategoria(categoriaRelatorio);
                        break;
                    case 4:
                        System.out.println("Saindo do sistema...");
                        scanner.close();
                        return;
                    default:
      
                }
            }
        }

    }}