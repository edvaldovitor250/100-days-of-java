public class Day014 {

    private String nome;
    private String email;
    private int telefone;

    public static void main(String[] args) {
        Day014 d14 = new Day014();

        d14.atualizar("Edvaldo", "email@example.com", 123456789);
        d14.adicionar("João", "joao@example.com", 987654321);
        d14.remover();
    }

    public void atualizar(String nome, String email, int telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        exibirContato("Atualizado");
    }

    public void adicionar(String nome, String email, int telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        exibirContato("Adicionado");
    }

    public void remover() {
        exibirContato("Removido");
        this.nome = null;
        this.email = null;
        this.telefone = 0;
    }

    private void exibirContato(String operacao) {
        System.out.println("Contato " + operacao + ":");
        System.out.println("Nome: " + (nome != null ? nome : "N/A"));
        System.out.println("Email: " + (email != null ? email : "N/A"));
        System.out.println("Telefone: " + (telefone != 0 ? telefone : "N/A"));
        System.out.println();
    }
}
