import java.util.ArrayList;
import java.util.List;

public class GestaoClientes {

    private List<String> nomeCliente;
    private List<Integer> numeroCliente;

    public GestaoClientes() {
        this.nomeCliente = new ArrayList<>();
        this.numeroCliente = new ArrayList<>();
    }

    public void listarClientes() {
        for (int i = 0; i < nomeCliente.size(); i++) {
            System.out.println(nomeCliente.get(i) + " - " + numeroCliente.get(i));
        }
    }

    public void adicionarCliente(String nome, int numero) {
        nomeCliente.add(nome);
        numeroCliente.add(numero);
        System.out.println("Novo Cliente: " + nome + ", Novo Número: " + numero);
    }

    public void removerCliente(String nome) {
        int index = nomeCliente.indexOf(nome);
        if (index != -1) {
            nomeCliente.remove(index);
            numeroCliente.remove(index);
            System.out.println("Cliente Removido: " + nome);
        } else {
            System.out.println("Cliente não encontrado: " + nome);
        }
    }

    public void alterarCliente(String nomeAntigo, String nomeNovo, int numeroNovo) {
        int index = nomeCliente.indexOf(nomeAntigo);
        if (index != -1) {
            nomeCliente.set(index, nomeNovo);
            numeroCliente.set(index, numeroNovo);
            System.out.println("Cliente Alterado: " + nomeNovo + ", Novo Número: " + numeroNovo);
        } else {
            System.out.println("Cliente não encontrado: " + nomeAntigo);
        }
    }

}