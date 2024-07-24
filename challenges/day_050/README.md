# Day 50

## Desafio:

	Implemente um algoritmo em Java para encontrar a árvore de abrangência mínima de um grafo usando o algoritmo de Prim.

**Resultado:**


```java

import java.util.ArrayList;
import java.util.List;

public class Day050 {

    public static void main(String[] args) {
        GerenciamentoEscolar sistema = new GerenciamentoEscolar();

        sistema.cadastrarAluno("Alice", "A001");
        sistema.cadastrarAluno("Bob", "A002");

        sistema.cadastrarProfessor("Professor Carlos", "P001");
        sistema.cadastrarProfessor("Professor Diana", "P002");

        sistema.cadastrarMateria("Matemática", "M001");
        sistema.cadastrarMateria("História", "M002");

        sistema.realizarMatricula("A001", "M001"); 
        sistema.realizarMatricula("A003", "M002"); 
    }

    static class GerenciamentoEscolar {

        List<String> cadastroAluno;
        List<String> cadastroProfessor;
        List<String> cadastroMateria;
        List<String> realizarMatricula;

        public GerenciamentoEscolar() {
            this.cadastroAluno = new ArrayList<>();
            this.cadastroProfessor = new ArrayList<>();
            this.cadastroMateria = new ArrayList<>();
            this.realizarMatricula = new ArrayList<>();
        }

        public void cadastrarAluno(String nome, String matricula) {
            this.cadastroAluno.add(nome);
            this.realizarMatricula.add(matricula);
            System.out.println("Aluno cadastrado: " + nome + " (" + matricula + ")");
        }

        public void cadastrarProfessor(String nome, String matricula) {
            this.cadastroProfessor.add(nome);
            this.realizarMatricula.add(matricula);
            System.out.println("Professor cadastrado: " + nome + " (" + matricula + ")");
        }

        public void cadastrarMateria(String nome, String codigo) {
            this.cadastroMateria.add(nome);
            this.realizarMatricula.add(codigo);
            System.out.println("Matéria cadastrada: " + nome + " (" + codigo + ")");
        }

        public void realizarMatricula(String matricula, String codigo) {
            int index = this.realizarMatricula.indexOf(matricula);
            if (index != -1) {
                this.realizarMatricula.set(index, codigo);
                System.out.println("Matrícula realizada: " + matricula + " em " + codigo);
            } else {
                System.out.println("Matrícula não encontrada!");
            }
        }
    }
}
