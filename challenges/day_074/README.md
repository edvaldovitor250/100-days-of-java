# Day 74

## Desafio:

	Desenvolva um aplicativo em Java que simule um sistema de gerenciamento de atividades de uma equipe de desenvolvimento de software, incluindo tarefas, sprints e burndown charts.
    
**Resultado:**


```java

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day074 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProjectManagementSystem system = new ProjectManagementSystem();

        while (true) {
            System.out.println("\nSistema de Gerenciamento de Projetos:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Adicionar sprint");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Exibir burndown chart");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite o nome da tarefa: ");
                    String taskName = scanner.nextLine();
                    system.addTask(new Task(taskName));
                    break;
                case 2:
                    System.out.print("Digite o nome da sprint: ");
                    String sprintName = scanner.nextLine();
                    system.addSprint(new Sprint(sprintName));
                    break;
                case 3:
                    System.out.print("Digite o nome da tarefa concluída: ");
                    String completedTaskName = scanner.nextLine();
                    system.completeTask(completedTaskName);
                    break;
                case 4:
                    system.displayBurndownChart();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

class Task {
    private String name;
    private boolean isCompleted;

    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void complete() {
        isCompleted = true;
    }
}

class Sprint {
    private String name;
    private List<Task> tasks;

    public Sprint(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}

class ProjectManagementSystem {
    private List<Task> tasks;
    private List<Sprint> sprints;

    public ProjectManagementSystem() {
        tasks = new ArrayList<>();
        sprints = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Tarefa adicionada: " + task.getName());
    }

    public void addSprint(Sprint sprint) {
        sprints.add(sprint);
        System.out.println("Sprint adicionada: " + sprint.getName());
    }

    public void completeTask(String taskName) {
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(taskName)) {
                task.complete();
                System.out.println("Tarefa concluída: " + task.getName());
                return;
            }
        }
        System.out.println("Tarefa não encontrada: " + taskName);
    }

    public void displayBurndownChart() {
        int totalTasks = tasks.size();
        int completedTasks = 0;
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks++;
            }
        }
        int remainingTasks = totalTasks - completedTasks;

        System.out.println("\nBurndown Chart:");
        System.out.println("Total de tarefas: " + totalTasks);
        System.out.println("Tarefas concluídas: " + completedTasks);
        System.out.println("Tarefas restantes: " + remainingTasks);
    }
}
