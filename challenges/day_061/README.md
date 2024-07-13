# Day 62

## Desafio:

	Implemente um sistema em Java para gerenciar uma escola de idiomas, incluindo matrículas, aulas e avaliações de alunos.
    
**Resultado:**


```java


import java.util.*;

public class Day061 {

    
    public static void main(String[] args) {
        escolaIdiomas escola = new escolaIdiomas(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        escola.addMatricula(1);
        escola.addMatricula(2);
        escola.addMatricula(3);

        escola.addAula("Inglês Básico");
        escola.addAula("Espanhol Intermediário");

        escola.addAvaliacao(5);
        escola.addAvaliacao(4);

        escola.listarMatriculas();
        escola.listarAulas();
        escola.listaAvaliacao();
    }
    

    static class escolaIdiomas{
        List<Integer> matriculas;
        List<String> aulas;
        List<Integer> avaliacao;

        public escolaIdiomas(List<Integer>matriculas, List<Integer> aulas, List<String> avaliacao){
            matriculas = new ArrayList<>();
            aulas = new ArrayList<>();
            avaliacao = new ArrayList<>();
        }

        public void listarMatriculas(){
            System.out.println("Matrículas:");
            for (int matricula : this.matriculas) {
                System.out.println(matricula);
            }
        }

        public void listarAulas(){
            System.out.println("Aulas:");
            for (String aula : this.aulas) {
                System.out.println(aula);
            }
        }

        public void listaAvaliacao(){
            System.out.println("Avaliações:");
            for (Integer avaliacao : this.avaliacao) {
                System.out.println(avaliacao);
            }
        }


        public void addMatricula(int matriculas){
            this.matriculas.add(matriculas);
            if(this.matriculas.size() > 100){
                throw new IllegalArgumentException("Número máximo de matrículas atingido.");
            }
            System.out.println("Matrícula realizada com sucesso.");
        }

        public void addAula(String aulas){
            this.aulas.add(aulas);
            if(this.aulas.size() > 10){
                throw new IllegalArgumentException("Número máximo de aulas atingido.");
            }
            System.out.println("Aula adicionada com sucesso.");
        }

        public void addAvaliacao(int avaliacao){
            this.avaliacao.add(avaliacao);
            if(this.avaliacao.size() > 10){
                throw new IllegalArgumentException("Número máximo de avaliações atingido.");
            }
            System.out.println("Avaliação adicionada com sucesso.");
        }


    }


   

    
}
