# Day 87

## Desafio:

	Crie um sistema em Java para gerenciar um evento esportivo, incluindo inscrições de participantes, controle de resultados e premiações.
**Resultado:**


```java


import java.util.ArrayList;
import java.util.List;

public class Day087 {

    static class EventoEsport {
        List<String> nome;
        List<Double> id;
        List<String> esport;

        public EventoEsport() {
            nome = new ArrayList<>();
            id = new ArrayList<>();
            esport = new ArrayList<>();
        }

        public void inscricoesEvento(String nome, double id, String esport) {
            this.nome.add(nome);
            this.id.add(id);
            this.esport.add(esport);
            System.out.println("Novo evento adicionado: " + nome + ", ID: " + id + ", Esporte: " + esport);
        }

        public void resultadoSport(String nome, String esport, double resultado) {
            int index = this.nome.indexOf(nome);
            if (index != -1) {
                this.esport.set(index, esport);
                this.id.set(index, resultado);
                System.out.println("Resultado do evento modificado: " + nome + ", Esporte: " + esport + ", ID: " + resultado);
            } else {
                System.out.println("Evento não encontrado!");
            }
        }

        public void premiacao(double id) {
            int index = this.id.indexOf(id);
            if (index != -1) {
                System.out.println("Premiação concedida ao evento: " + this.nome.get(index) + ", Esporte: " + this.esport.get(index) + ", ID: " + this.id.get(index));
            } else {
                System.out.println("ID não encontrado!");
            }
        }
    }

    public static void main(String[] args) {
        EventoEsport eventoEsport = new EventoEsport();

        eventoEsport.inscricoesEvento("Campeonato de Futebol", 1, "Futebol");
        eventoEsport.inscricoesEvento("Torneio de Basquete", 2, "Basquete");

        eventoEsport.resultadoSport("Campeonato de Futebol", "Futebol", 1.1);
        eventoEsport.resultadoSport("Torneio de Basquete", "Basquete", 2.2);

        eventoEsport.premiacao(1.1);
        eventoEsport.premiacao(2.2);

        eventoEsport.resultadoSport("Corrida de Rua", "Atletismo", 3.3);

        eventoEsport.premiacao(3.3);
    }
}
