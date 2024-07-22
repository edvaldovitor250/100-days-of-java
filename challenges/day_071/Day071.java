import java.util.ArrayList;
import java.util.List;

public class Day071 {

    List<String> veiculo;
    List<Integer> vendas;
    List<Double> controleEstoque;

    public Day071() {
        veiculo = new ArrayList<>();
        vendas = new ArrayList<>();
        controleEstoque = new ArrayList<>();
    }

    public void adicionarVeiculo(String nomeVeiculo, int venda, double estoque) {
        veiculo.add(nomeVeiculo);
        vendas.add(venda);
        controleEstoque.add(estoque);
    }

    public void vendasVeiculos(String nomeVeiculos, int venda, double estoque){
        int indexVeiculo = veiculo.indexOf(nomeVeiculos);
        System.out.println(indexVeiculo);
    }

    public void controleDeEstoque(String nome){
        int indexVeiculo = veiculo.indexOf(nome);
        System.out.println("Estoque: " + controleEstoque.get(indexVeiculo));
    }

    public static void main(String[] args) {
        Day071 day071 = new Day071();
        day071.adicionarVeiculo("Carro A", 5, 10.0);
        day071.adicionarVeiculo("Carro B", 3, 5.5);
        day071.adicionarVeiculo("Carro C", 8, 7.2);
        day071.vendasVeiculos("Carro A", 5, 10.0);
        day071.controleDeEstoque("Carro B");
        day071.controleDeEstoque("Carro C");
        day071.controleDeEstoque("Carro D");
    }
}
