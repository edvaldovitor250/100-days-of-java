# Day 81

## Desafio:

		Desenvolva um aplicativo em Java que simule um sistema de gerenciamento de tarefas pessoais, permitindo criar listas de tarefas, definir prioridades e acompanhar o progresso.

**Resultado:**


```java

import java.util.ArrayList;
import java.util.List;

public class Day081 {

    public static class TarefasPessoas {
        List<String> tarefa;
        List<String> lista;
        List<Integer> tempo;

        public TarefasPessoas() {
            this.tarefa = new ArrayList<>();
            this.lista = new ArrayList<>();
            this.tempo = new ArrayList<>();
        }

        public void criarListaTarefas(String tarefas, String listas) {
            System.out.println("Foi criado sua lista: " + listas);
            System.out.println("Foi criado sua tarefa: " + tarefas);
            tarefa.add(tarefas);
            lista.add(listas);
        }

        public void prioridadeTarefa(String mensagem, String tarefas) {
            System.out.println("Sua prioridade é " + mensagem + " para essa tarefa: " + tarefas);
        }

        public void acompanharProgresso(String tarefas, int tempo) {
            System.out.println("Sua tarefa " + tarefas + " está sendo realizada e o tempo é " + tempo + " minutos.");
        }

        public static void main(String[] args) {
            TarefasPessoas tp = new TarefasPessoas();

            tp.criarListaTarefas("Estudar Java", "Estudos");
            tp.criarListaTarefas("Comprar pão", "Compras");
            tp.prioridadeTarefa("Alta", "Estudar Java");
            tp.acompanharProgresso("Estudar Java", 60);
            tp.acompanharProgresso("Comprar pão", 15);
        }
    }
}
