# Day 56

## Desafio:

Desenvolva um aplicativo em Java que simule um sistema de gerenciamento de tarefas, permitindo criar, atribuir, priorizar e acompanhar o progresso das tarefas.

**Resultado:**


```java

import java.util.*;

public class Day056 {

    public static void main(String[] args) {
        GerenciamentoTarefas gerenciamentoTarefas = new GerenciamentoTarefas();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Criar Tarefa");
            System.out.println("2. Atribuir Tarefa");
            System.out.println("3. Priorizar Tarefa");
            System.out.println("4. Acompanhar Progresso");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Digite o nome da tarefa: ");
                    String nomeTarefa = scanner.nextLine();
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    gerenciamentoTarefas.criarTarefa(nomeTarefa, descricao);
                    break;
                case 2:
                    System.out.print("Digite o ID da tarefa para atribuir: ");
                    int idAtribuir = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o nome do responsável: ");
                    String responsavel = scanner.nextLine();
                    gerenciamentoTarefas.atribuirTarefa(idAtribuir, responsavel);
                    break;
                case 3:
                    System.out.print("Digite o ID da tarefa para priorizar: ");
                    int idPriorizar = scanner.nextInt();
                    System.out.print("Digite a prioridade (1- Alta, 2- Média, 3- Baixa): ");
                    int prioridade = scanner.nextInt();
                    gerenciamentoTarefas.priorizarTarefa(idPriorizar, prioridade);
                    break;
                case 4:
                    gerenciamentoTarefas.acompanharProgresso();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

class GerenciamentoTarefas {
    private List<Tarefa> tarefas;
    private int nextId;
    
    public GerenciamentoTarefas() {
        tarefas = new ArrayList<>();
        nextId = 1;
    }
    
    public void criarTarefa(String nome, String descricao) {
        Tarefa tarefa = new Tarefa(nextId++, nome, descricao);
        tarefas.add(tarefa);
        System.out.println("Tarefa criada com sucesso: " + tarefa);
    }
    
    public void atribuirTarefa(int id, String responsavel) {
        Tarefa tarefa = encontrarTarefaPorId(id);
        if (tarefa != null) {
            tarefa.setResponsavel(responsavel);
            System.out.println("Tarefa atribuída com sucesso: " + tarefa);
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }
    
    public void priorizarTarefa(int id, int prioridade) {
        Tarefa tarefa = encontrarTarefaPorId(id);
        if (tarefa != null) {
            tarefa.setPrioridade(prioridade);
            System.out.println("Prioridade da tarefa atualizada com sucesso: " + tarefa);
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }
    
    public void acompanharProgresso() {
        System.out.println("Progresso das Tarefas:");
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }
    
    private Tarefa encontrarTarefaPorId(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        return null;
    }
}

class Tarefa {
    private int id;
    private String nome;
    private String descricao;
    private String responsavel;
    private int prioridade;
    
    public Tarefa(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.responsavel = "Não atribuído";
        this.prioridade = 3;
    }
    
    public int getId() {
        return id;
    }
    
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    
    public void setPrioridade(int prioridade) {
        if (prioridade >= 1 && prioridade <= 3) {
            this.prioridade = prioridade;
        } else {
            System.out.println("Prioridade inválida. Mantendo a prioridade atual.");
        }
    }
    
    @Override
    public String toString() {
        return "Tarefa [ID=" + id + ", Nome=" + nome + ", Descrição=" + descricao + 
               ", Responsável=" + responsavel + ", Prioridade=" + (prioridade == 1 ? "Alta" : (prioridade == 2 ? "Média" : "Baixa")) + "]";
    }
}
