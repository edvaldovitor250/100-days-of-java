public class Pedido {

    String nome;
    int quantidade;

    public Pedido(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                '}';
}
}