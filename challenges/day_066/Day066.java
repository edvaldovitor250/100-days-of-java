import java.util.ArrayList;
import java.util.List;

public class Day066 {
    
    List<String> nomeCarro;
    List<Integer> anoDoCarro;
    List<Integer> tempoParaDevolver;

    public Day066() {
        nomeCarro = new ArrayList<>();
        anoDoCarro = new ArrayList<>();
        tempoParaDevolver = new ArrayList<>();
    }

    public void carrosDisponiveis() {
        for (int i = 0; i < nomeCarro.size(); i++) {
            System.out.println("Nome: " + nomeCarro.get(i) + ", Ano: " + anoDoCarro.get(i) + ", Tempo para devolver: " + tempoParaDevolver.get(i) + " meses");
        }
    }

    public void adicionarCarro(String nome, int ano, int tempo) {
        nomeCarro.add(nome);
        anoDoCarro.add(ano);
        tempoParaDevolver.add(tempo);
        System.out.println("Nome do carro adicionado: " + nome);
    }

    public void reservarCarro(String nome, int ano, int tempo) {
        int index = nomeCarro.indexOf(nome);
        if (index != -1) {
            if (anoDoCarro.get(index) >= ano && tempoParaDevolver.get(index) >= tempo) {
                System.out.println("Carro reservado com sucesso!");
            } else {
                System.out.println("Carro não disponível para reserva.");
            }
        } else {
            System.out.println("Carro não encontrado.");
        }
    }

    public static void main(String[] args) {
        Day066 sistema = new Day066();

        sistema.adicionarCarro("Honda Civic", 2020, 6);
        sistema.adicionarCarro("Toyota Corolla", 2019, 12);
        sistema.adicionarCarro("Ford Mustang", 2021, 3);

        System.out.println("Carros disponíveis:");
        sistema.carrosDisponiveis();

        System.out.println("\nTentando reservar 'Toyota Corolla' para 10 meses:");
        sistema.reservarCarro("Toyota Corolla", 2019, 10);

        System.out.println("\nTentando reservar 'Honda Civic' para 7 meses:");
        sistema.reservarCarro("Honda Civic", 2020, 7);

        System.out.println("\nTentando reservar 'Ford Mustang' para 2 meses:");
        sistema.reservarCarro("Ford Mustang", 2021, 2);
    }
}
