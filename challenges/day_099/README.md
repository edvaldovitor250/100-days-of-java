# Day 99

## Desafio:

Crie um sistema em Java para gerenciar um pet shop, incluindo cadastro de clientes, agendamento de consultas veterinárias e controle de vendas de produtos.

**Resultado:**

```java

import java.util.ArrayList;
import java.util.List;

public class Day099 {

    static class GerenciaPet {
        List<String> clientes;
        List<String> consultas;
        List<String> vendas;

        public GerenciaPet() {
            this.clientes = new ArrayList<>();
            this.consultas = new ArrayList<>();
            this.vendas = new ArrayList<>();
        }

        public void cadastrarCliente(String nome, String endereco) {
            clientes.add("Nome: " + nome);
            clientes.add("Endereço: " + endereco);
        }

        public void agendarConsulta(String nomeCliente, String dataConsulta) {
            consultas.add("Cliente: " + nomeCliente + " - Data: " + dataConsulta);
        }

        public void realizarVenda(String nomeCliente, String produto, int quantidade) {
            vendas.add("Cliente: " + nomeCliente + " - Produto: " + produto + " - Quantidade: " + quantidade);
        }

        public void mostrarClientes() {
            System.out.println("Clientes cadastrados:");
            for (String cliente : clientes) {
                System.out.println(cliente);
            }
            System.out.println();
        }

        public void mostrarConsultas() {
            System.out.println("Consultas agendadas:");
            for (String consulta : consultas) {
                System.out.println(consulta);
            }
            System.out.println();
        }

        public void mostrarVendas() {
            System.out.println("Vendas realizadas:");
            for (String venda : vendas) {
                System.out.println(venda);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GerenciaPet petShop = new GerenciaPet();

        petShop.cadastrarCliente("John Doe", "123 Main St");
        petShop.cadastrarCliente("Jane Smith", "456 Oak St");

        petShop.agendarConsulta("John Doe", "2024-09-15 10:00");
        petShop.agendarConsulta("Jane Smith", "2024-09-16 14:00");

        petShop.realizarVenda("John Doe", "Ração para cães", 2);
        petShop.realizarVenda("Jane Smith", "Brinquedo para gatos", 1);

        petShop.mostrarClientes();
        petShop.mostrarConsultas();
        petShop.mostrarVendas();
    }
}
