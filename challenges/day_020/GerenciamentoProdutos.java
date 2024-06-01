import java.util.ArrayList;
import java.util.List;

public class GerenciamentoProdutos {

    List<String> produto;
    List<Integer> valor;
    
    public GerenciamentoProdutos() {
        this.produto = new ArrayList<>();
        this.valor = new ArrayList<>();
    }

    public void ListarProdutos(){
        for (int i = 0; i < this.produto.size(); i++) {
            System.out.println("Produto: " + this.produto.get(i) + " - valor: " + this.valor.get(i));
        }
    }


    public void adicionarProduto(String produto, int valor) {
        this.produto.add(produto);
        this.valor.add(valor);
        System.out.println("Seu produto foi Cadastrado: " + produto);
    }

    public void removerProduto(String produto) {
        int index = this.produto.indexOf(produto);
        if (index != -1) {
            this.produto.remove(index);
            this.valor.remove(index);
            System.out.println("Seu produto foi Removvaloro: " + produto);
        } else {
            System.out.println("Produto não encontrado: " + produto);
        }
    }

    public void atualizarProduto(int valor, String novoProduto) {
        int index = this.valor.indexOf(valor);
        if (index != -1) {
            this.produto.set(index, novoProduto);
            System.out.println("Seu produto foi Atualizado para: " + novoProduto);
        } else {
            System.out.println("Produto com valor " + valor + " não encontrado.");
        }
    }

}
