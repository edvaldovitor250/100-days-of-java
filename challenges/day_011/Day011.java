
public class Day011 {

    private int estoqueAtual;

    public static void main(String[] args) {
        Day011 d9 = new Day011();
        d9.adicionarEstoque(20);
        d9.removerEstoque(30);
        d9.atualizarEstoque(40);
    }

    public void adicionarEstoque(int quantidade) {
        estoqueAtual += quantidade;
        System.out.println("Quantidade adicionada: " + quantidade);
        System.out.println("Estoque atual: " + estoqueAtual);
    }

    public void removerEstoque(int quantidade) {
        if (quantidade > estoqueAtual) {
            System.out.println("Erro: Não há estoque suficiente para remover " + quantidade + " unidades.");
        } else {
            estoqueAtual -= quantidade;
            System.out.println("Quantidade removida: " + quantidade);
        }
        System.out.println("Estoque atual: " + estoqueAtual);
    }

    public void atualizarEstoque(int novaQuantidade) {
        estoqueAtual = novaQuantidade;
        System.out.println("Estoque atualizado para: " + novaQuantidade);
    }
}
