# Day 98

## Desafio:

Escreva um programa Java que simule um sistema de gestão de serviços de entrega de comida, permitindo fazer pedidos, rastrear entregas e avaliar restaurantes.

**Resultado:**

```java

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day098 {

    static class GestaoServicos {
        List<String> entregas;
        List<String> pedidos;
        List<Integer> avaliar;

        public GestaoServicos() {
            entregas = new ArrayList<>();
            pedidos = new ArrayList<>();
            avaliar = new ArrayList<>();
        }

        public void fazerPedidos(String pedido) {
            pedidos.add(pedido);
            System.out.println("Pedido \"" + pedido + "\" foi feito com sucesso.");
        }

        public void rastrearEntrega() {
            if (pedidos.isEmpty()) {
                System.out.println("Nenhum pedido disponível para rastrear.");
            } else {
                String entrega = pedidos.remove(0);
                entregas.add(entrega);
                System.out.println("Entrega do pedido \"" + entrega + "\" está a caminho.");
            }
        }

        public void avaliarRestaurante(int nota) {
            if (nota >= 1 && nota <= 5) {
                avaliar.add(nota);
                System.out.println("Restaurante avaliado com " + nota + " estrelas.");
            } else {
                System.out.println("Nota inválida. Insira uma nota entre 1 e 5.");
            }
        }

        public void mostrarEntregas() {
            if (entregas.isEmpty()) {
                System.out.println("Nenhuma entrega foi realizada até o momento.");
            } else {
                System.out.println("Entregas realizadas:");
                for (String entrega : entregas) {
                    System.out.println("- " + entrega);
                }
            }
        }

        public void mostrarAvaliacaoMedia() {
            if (avaliar.isEmpty()) {
                System.out.println("Nenhuma avaliação foi registrada.");
            } else {
                double total = 0;
                for (int nota : avaliar) {
                    total += nota;
                }
                double media = total / avaliar.size();
                System.out.printf("A avaliação média dos restaurantes é: %.2f estrelas.%n", media);
            }
        }
    }

    public static void main(String[] args) {
        GestaoServicos gestao = new GestaoServicos();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSistema de Gestão de Serviços de Entrega");
            System.out.println("1. Fazer pedido");
            System.out.println("2. Rastrear entrega");
            System.out.println("3. Avaliar restaurante");
            System.out.println("4. Mostrar entregas realizadas");
            System.out.println("5. Mostrar avaliação média dos restaurantes");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do pedido: ");
                    String pedido = scanner.nextLine();
                    gestao.fazerPedidos(pedido);
                    break;
                case 2:
                    gestao.rastrearEntrega();
                    break;
                case 3:
                    System.out.print("Digite a nota do restaurante (1 a 5): ");
                    int nota = scanner.nextInt();
                    gestao.avaliarRestaurante(nota);
                    break;
                case 4:
                    gestao.mostrarEntregas();
                    break;
                case 5:
                    gestao.mostrarAvaliacaoMedia();
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 6);

        scanner.close();
    }
}
