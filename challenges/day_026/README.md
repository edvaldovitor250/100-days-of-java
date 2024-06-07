# Day 26

## Desafio:

		Crie uma classe em Java para representar um sistema de gestão de vendas com operações de adicionar, remover e atualizar informações das vendas.

**Resultado:**

```java

import java.util.ArrayList;
import java.util.List;

public class GestaoVendas {

    private List<String> nomeProduto;
    private List<Integer> valorProduto;

    public GestaoVendas() {
        nomeProduto = new ArrayList<>();
        valorProduto = new ArrayList<>();
    }

    public void ListarProdutos() {
        for (int i = 0; i < this.nomeProduto.size(); i++) {
            System.out.println("Produto: " + this.nomeProduto.get(i));
            System.out.println("Valor: " + this.valorProduto.get(i));
        }
    }

    public void adicionarProduto(String nome, int valor) {
        this.nomeProduto.add(nome);
        this.valorProduto.add(valor);

        System.out.println("Novo Produto adicionado: " + nome);
        System.out.println("Valor do Produto adicionado: " + valor);
    }

    public void removerProduto(String nome) {
        int index = this.nomeProduto.indexOf(nome);
        if (index != -1) {
            this.nomeProduto.remove(index);
            this.valorProduto.remove(index);
            System.out.println("Produto removido: " + nome);
        } else {
            System.out.println("Produto não encontrado: " + nome);
        }
    }

    public void atualizarProduto(String nome, int valor) {
        int index = this.nomeProduto.indexOf(nome);
        if (index != -1) {
            this.valorProduto.set(index, valor);
            System.out.println("Produto atualizado: " + nome + " com novo valor: " + valor);
        } else {
            System.out.println("Produto não encontrado: " + nome);
        }
    }
}


public class Day026 {

    public static void main(String[] args) {
        GestaoVendas gp1 = new GestaoVendas();

      gp1.adicionarProduto("Carro", 12000);
      gp1.adicionarProduto("Moto", 8000);
      gp1.ListarProdutos();
    }

}
