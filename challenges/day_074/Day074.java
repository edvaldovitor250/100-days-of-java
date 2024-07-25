import java.util.ArrayList;
import java.util.List;

public class Day074 {

    static class Gbiblioteca {

        List<String> livros = new ArrayList<>();
        List<Integer> devolucoes = new ArrayList<>();

        public void cadastroLivro(String titulo, int ano) {
            System.out.println("Livro cadastrado: " + titulo + " (" + ano + ")");
            livros.add(titulo);
        }

        public void devolverLivro(String titulo, int dataDevolucao) {
            int index = livros.indexOf(titulo);
            if (index != -1) {
                devolucoes.add(index, dataDevolucao);
            } else {
                System.out.println("Livro não encontrado para devolução: " + titulo);
            }
        }

        public void emprestimos() {
            for (int i = 0; i < livros.size(); i++) {
                String dataDevolucao = (devolucoes.size() > i) ? String.valueOf(devolucoes.get(i)) : "Não devolvido";
                System.out.println("Livro: " + livros.get(i) + ", Data devolução: " + dataDevolucao);
            }
        }
    }

    public static void main(String[] args) {
        Gbiblioteca biblioteca = new Gbiblioteca();
        biblioteca.cadastroLivro("O Senhor dos Anéis", 1954);
        biblioteca.cadastroLivro("O Hobbit", 1937);

        biblioteca.devolverLivro("O Senhor dos Anéis", 20240719);
        biblioteca.devolverLivro("O Hobbit", 20240720);

        biblioteca.emprestimos();
    }
}
