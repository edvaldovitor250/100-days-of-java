import java.util.ArrayList;
import java.util.List;

public class AgendaNova {
    private List<String> nomes;
    private List<Integer> telefones;

    public AgendaNova() {
        this.nomes = new ArrayList<>();
        this.telefones = new ArrayList<>();
    }

    public void listarAgenda() {
        System.out.println("Lista de Contatos:");
        for (int i = 0; i < this.nomes.size(); i++) {
            System.out.println(this.nomes.get(i) + " - " + this.telefones.get(i));
        }
    }

    public void adicionar(String nome, int telefone) {
        this.nomes.add(nome);
        this.telefones.add(telefone);
        System.out.println("Novo Contato: " + nome + ", Telefone: " + telefone);
    }

    public void remover(String nome) {
        int index = this.nomes.indexOf(nome);
        if (index != -1) {
            this.nomes.remove(index);
            this.telefones.remove(index);
            System.out.println("Contato removido: " + nome);
        } else {
            System.out.println("Contato não encontrado: " + nome);
        }
    }

    public void atualizar(String nome, int telefone) {
        int index = this.nomes.indexOf(nome);
        if (index != -1) {
            this.telefones.set(index, telefone);
            System.out.println("Contato atualizado: " + nome + ", Novo Telefone: " + telefone);
        } else {
            System.out.println("Contato não encontrado: " + nome);
        }
    }
}
