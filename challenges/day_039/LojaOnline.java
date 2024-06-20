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
