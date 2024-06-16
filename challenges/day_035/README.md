# Day 35

## Desafio:

	Crie um sistema em Java para gerenciar uma agenda de contatos, com operações de adicionar, remover e atualizar informações de contatos.
    

**Resultado:**


```java

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

public class Day035 {
    public static void main(String[] args) {
        AgendaNova agenda = new AgendaNova();

        agenda.adicionar("Alice", 123456789);
        agenda.adicionar("Bob", 987654321);
        agenda.adicionar("Charlie", 555555555);

        agenda.listarAgenda();

        agenda.atualizar("Bob", 111111111);

        agenda.listarAgenda();

        agenda.remover("Alice");

        agenda.listarAgenda();

        agenda.remover("David");

        agenda.atualizar("David", 222222222);

        agenda.listarAgenda();
    }
}