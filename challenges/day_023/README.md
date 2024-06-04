# Day 23

## Desafio:

	Crie uma classe em Java para representar um sistema de gestão de clientes com operações de adicionar, remover e atualizar informações dos clientes.

**Resultado:**

```java

import java.util.ArrayList;
import java.util.List;

public class GestaoClientes {

    private List<String> nomeCliente;
    private List<Integer> numeroCliente;

    public GestaoClientes() {
        this.nomeCliente = new ArrayList<>();
        this.numeroCliente = new ArrayList<>();
    }

    public void listarClientes() {
        for (int i = 0; i < nomeCliente.size(); i++) {
            System.out.println(nomeCliente.get(i) + " - " + numeroCliente.get(i));
        }
    }

    public void adicionarCliente(String nome, int numero) {
        nomeCliente.add(nome);
        numeroCliente.add(numero);
        System.out.println("Novo Cliente: " + nome + ", Novo Número: " + numero);
    }

    public void removerCliente(String nome) {
        int index = nomeCliente.indexOf(nome);
        if (index != -1) {
            nomeCliente.remove(index);
            numeroCliente.remove(index);
            System.out.println("Cliente Removido: " + nome);
        } else {
            System.out.println("Cliente não encontrado: " + nome);
        }
    }

    public void alterarCliente(String nomeAntigo, String nomeNovo, int numeroNovo) {
        int index = nomeCliente.indexOf(nomeAntigo);
        if (index != -1) {
            nomeCliente.set(index, nomeNovo);
            numeroCliente.set(index, numeroNovo);
            System.out.println("Cliente Alterado: " + nomeNovo + ", Novo Número: " + numeroNovo);
        } else {
            System.out.println("Cliente não encontrado: " + nomeAntigo);
        }
    }

}


public class Day023 {

  public static void main(String[] args) {
    GestaoClientes gestao = new GestaoClientes();
        
        gestao.adicionarCliente("Alice", 123456);
        gestao.adicionarCliente("Bob", 234567);
        
        System.out.println("Lista de Clientes:");
        gestao.listarClientes();
        
        gestao.alterarCliente("Alice", "Alice Smith", 654321);
        
        System.out.println("\nLista de Clientes Após Alteração:");
        gestao.listarClientes();

        gestao.removerCliente("Bob");
        
        System.out.println("\nLista de Clientes Após Remoção:");
        gestao.listarClientes();
  }

    
   

}