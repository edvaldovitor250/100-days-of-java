import java.util.ArrayList;
import java.util.List;

public class Day045 {

    public static void main(String[] args) {
        SistemaGestao sj1 = new SistemaGestao();

        sj1.AdicionarProduto("Produto 1", "Endereço 1");
        sj1.AdicionarProduto("Produto 2", "Endereço 2");

        sj1.AtualizarProduto("Produto Atualizado 1", "Endereço Atualizado 1");

        sj1.RemoverProduto();

        sj1.AdicionarProduto("Produto 3", "Endereço 3");
        
        sj1.RemoverProduto();
    }

    public static class SistemaGestao {

        List<String> produto;
        List<String> endereco;

        public SistemaGestao(){
            this.produto = new ArrayList<String>();
            this.endereco = new ArrayList<String>();
        }

        public void AdicionarProduto(String nomeProduto,String enderecoProduto){
            this.produto.add(nomeProduto);
            this.endereco.add(enderecoProduto);
            System.out.println("Novo Produto Adicionado: " + nomeProduto);
            System.out.println("Novo Produto Adicionado: " + enderecoProduto);
        }

        public void RemoverProduto(){
            this.produto.remove(0);
            this.endereco.remove(0);
            System.out.println("Produto Removido: " + this.produto.get(0));
            System.out.println("Endereço Removido: " + this.endereco.get(0));
        }

        public void AtualizarProduto(String produtoAtulizado,String enderecoAtualizado){
            this.produto.set(0,produtoAtulizado);
            this.endereco.set(0,enderecoAtualizado);
            System.out.println("Produto Atualizado: " + produtoAtulizado);
            System.out.println("Endereço Atualizado: " + enderecoAtualizado);
        }

    
        
    }
    
    
}