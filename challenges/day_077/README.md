# Day 77

## Desafio:

Desenvolva um aplicativo em Java que simula um sistema de reservas em um restaurante, permitindo reservar mesas, visualizar cardápio e fazer pedidos.

**Resultado:**


```java

import java.util.ArrayList;
import java.util.List;

public class Day077 {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();

        restaurante.visualizarMenu();

        restaurante.reservas("Restaurante Italiano", "Mesa 5");

        restaurante.fazerPedidos("Pizza Margherita");

        restaurante.visualizarPedidos();
    }

    static class Restaurante {
        List<String> restaurantes;
        List<String> reservarMesas;
        List<String> cardapio;
        List<String> pedidos;

        public Restaurante() {
            this.restaurantes = new ArrayList<>();
            this.reservarMesas = new ArrayList<>();
            this.cardapio = new ArrayList<>();
            this.pedidos = new ArrayList<>();

            cardapio.add("Pizza Margherita");
            cardapio.add("Hamburguer");
            cardapio.add("Sushi");
            cardapio.add("Lasanha");
            cardapio.add("Salada Caesar");
            cardapio.add("Tacos");
            cardapio.add("Bife à Parmegiana");
            cardapio.add("Sorvete de Chocolate");
            cardapio.add("Café Espresso");
            cardapio.add("Suco de Laranja");
        }

        public void reservas(String restaurante, String mesasreservar) {
            System.out.println(restaurante + " " + mesasreservar + " foram adicionados à reserva");
            restaurantes.add(restaurante);
            reservarMesas.add(mesasreservar);
        }

        public void visualizarMenu() {
            System.out.println("Cardápio:");
            for (String item : cardapio) {
                System.out.println(item);
            }
        }

        public void fazerPedidos(String pedido) {
            System.out.println("Pedido realizado: " + pedido);
            pedidos.add(pedido);
        }

        public void visualizarPedidos() {
            System.out.println("Pedidos:");
            for (String pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }
}
