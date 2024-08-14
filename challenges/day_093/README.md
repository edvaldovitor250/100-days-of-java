# Day 93

## Desafio:

Desenvolva um aplicativo em Java que simule um sistema de gestão de estoque para uma loja de materiais de construção, incluindo controle de fornecedores e produtos.

**Resultado:**

import java.util.ArrayList;
import java.util.List;

public class Day093 {

    public static void main(String[] args) {
        lojaManterial loja = new lojaManterial();

        loja.adicionarProduto("Tinta", 50);
        loja.adicionarProduto("Pincel", 30);
        loja.adicionarProduto("Cimento", 100);
        loja.adicionarProduto("Areia", 200);

        loja.controlerProdutos();
        loja.controlerFornecedores();
    }

    static class lojaManterial {

        List<String> produtos;
        List<Integer> quantidade;

        public lojaManterial() {
            this.produtos = new ArrayList<>();
            this.quantidade = new ArrayList<>();
        }

        public void adicionarProduto(String produto, int quantidade) {
            this.produtos.add(produto);
            this.quantidade.add(quantidade);
        }

        public void controlerFornecedores() {
            System.out.println("Fornecedores: ");
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println(produtos.get(i) + " - Quantidade: " + quantidade.get(i));
            }
        }

        public void controlerProdutos() {
            System.out.println("Produtos: ");
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println(produtos.get(i) + " - Quantidade: " + quantidade.get(i));
            }
        }
    }
}
