import java.util.List;

public class Day075 {

 public static void main(String[] args) {
        CentroFitness centroFitness = new CentroFitness();

        centroFitness.cadastrarMembro("João Silva", "joao.silva@email.com");
        centroFitness.agendarTreino("João Silva", 20240726, 2, 50.0);
        centroFitness.controlePagamento("João Silva", 20240726);

        centroFitness.cadastrarMembro("Maria Oliveira", "maria.oliveira@email.com");
        centroFitness.agendarTreino("Maria Oliveira", 20240727, 1, 30.0);
        centroFitness.controlePagamento("Maria Oliveira", 20240727);
    }

    static class CentroFitness{

        List<String> cadastroMembro;
        List<Integer> agendamento;
        List<Integer> pagamentos;

        public void cadastrarMembro(String nome, String email){
            System.out.println("Membro cadastrado: " + nome + " - " + email);
            cadastroMembro.add(nome + " - " + email);
        }

        public void agendarTreino(String nome, int data, int duracao, double preco){
            System.out.println("Treino agendado: " + nome + " - " + data + " - " + duracao + " horas - R$ " + preco);
            agendamento.add(data);
            agendamento.add(duracao);
        }

        public void controlePagamento(String nomeAulo, int diaPagemento){
            System.out.println("Treino agendado: " + nomeAulo + " - " + diaPagemento + " - " +  " horas - R$ " );
            pagamentos.add(diaPagemento);
        }

    }

}