# Day 39

## Desafio:

	Crie um sistema Java para gerenciar uma loja online, com funcionalidades de adicionar produtos ao carrinho, fazer pedidos e calcular o total da compra.

**Resultado:**


```java

import java.util.ArrayList;
import java.util.List;

public class LojaOnline {

    List<String> nome;
    List<Integer> preco;
    List<Integer> quantidade;

    public LojaOnline(){
        this.nome = new ArrayList<>();
        this.preco = new ArrayList<>();
        this.quantidade = new ArrayList<>();
    }

    public void  AdicionarProduto(String produtoNome, int produtoPreco,int produtoQuantidade){
        nome.add(produtoNome);
        preco.add(produtoPreco);
        quantidade.add(produtoQuantidade);

        System.out.println("Produto Adicionado: " + produtoNome);
        System.out.println("Preço do Produto: " + produtoPreco);
        System.out.println("Quantidade do Produto: " + produtoQuantidade);
    }

    public void FazerPedido(int quantidadeTotal, int valorTotals){
        System.out.println("Fazer Pedido");
        int valorTotal = quantidadeTotal * valorTotals;
        System.out.println("Esse o valor que vai pagar" + valorTotal);

    }

}


public class Day039 {

    public static void main(String[] args) {
        LojaOnline lj1 = new LojaOnline();

        lj1.AdicionarProduto("Camiseta", 20, 10);
        lj1.FazerPedido(10, 200);
    }

}
