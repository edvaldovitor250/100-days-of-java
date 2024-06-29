import java.util.ArrayList;
import java.util.List;

public class Day048 {

    public static void main(String[] args) {
        SistemaGerenciamento sistema = new SistemaGerenciamento();

        sistema.adicionarProjeto("Projeto A", "Alice", 1000, "Em Progresso");
        sistema.adicionarProjeto("Projeto B", "Bob", 1500, "Concluído");

        sistema.atribuirTarefa(1500);

        sistema.acompanharProgresso("Em Progresso");

        sistema.listarProjetos();
    }

    public static class SistemaGerenciamento {

        List<String> nomeProjeto;
        List<String> nomeResponsavel;
        List<Integer> tarifa;
        List<String> statusProjeto;

        public SistemaGerenciamento() {
            nomeProjeto = new ArrayList<>();
            nomeResponsavel = new ArrayList<>();
            tarifa = new ArrayList<>();
            statusProjeto = new ArrayList<>();
        }

        public void adicionarProjeto(String nome, String responsavel, int tarifa, String status) {
            nomeProjeto.add(nome);
            nomeResponsavel.add(responsavel);
            this.tarifa.add(tarifa);
            statusProjeto.add(status);

            System.out.println("Projeto adicionado: " + nome);
            System.out.println("Responsável: " + responsavel);
            System.out.println("Tarifa: " + tarifa);
            System.out.println("Status do Projeto: " + status);
        }

        public void atribuirTarefa(int tarifa) {
            boolean allEqual = true;
            for (int i = 1; i < this.tarifa.size(); i++) {
                if (!this.tarifa.get(i).equals(this.tarifa.get(0))) {
                    allEqual = false;
                    break;
                }
            }
            if (allEqual) {
                System.out.println("Todas as tarifas são iguais, não é possível atribuir tarefa.");
            } else {
                System.out.println("Tarifa atribuída ao Projeto.");
            }
        }

        public void acompanharProgresso(String status) {
            System.out.println("Status do Projeto: " + status);
        }

        public void listarProjetos() {
            for (int i = 0; i < nomeProjeto.size(); i++) {
                System.out.println("Projeto: " + nomeProjeto.get(i) + ", Responsável: " + nomeResponsavel.get(i) + ", Tarifa: " + tarifa.get(i) + ", Status: " + statusProjeto.get(i));
            }
        }
    }
}
