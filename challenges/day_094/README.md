# Day 94

## Desafio:

Escreva um programa Java que simule um sistema de gerenciamento de aluguel de carros, permitindo cadastrar veículos, realizar reservas e emitir recibos.

**Resultado:**

import java.util.ArrayList;
import java.util.List;

public class Day094 {

    static class GerenciamentoCarro {

        List<String> cadastrarVeiculo;
        List<String> reservasVeiculo;
        List<String> reciboVeiculo; 

        public GerenciamentoCarro() {
            cadastrarVeiculo = new ArrayList<>();
            reservasVeiculo = new ArrayList<>();
            reciboVeiculo = new ArrayList<>();
        }

        public void cadastrarVeiculo(String placa, String modelo, String marca, int ano) {
            String veiculo = placa + " - " + modelo + " - " + marca + " - " + ano;
            cadastrarVeiculo.add(veiculo);
            System.out.println("Veículo cadastrado: " + veiculo);
        }

        public void reservarVeiculo(String placa, String dataReserva) {
            String reserva = placa + " - " + dataReserva;
            reservasVeiculo.add(reserva);
            System.out.println("Veículo reservado: " + reserva);
        }

        public void gerarRecibo(String placa, int valorReserva) {
            String recibo = placa + " - R$" + valorReserva;
            reciboVeiculo.add(recibo);
            System.out.println("Recibo gerado: " + recibo);
        }
    }

    public static void main(String[] args) {
        GerenciamentoCarro gerenciamento = new GerenciamentoCarro();

        gerenciamento.cadastrarVeiculo("ABC-1234", "Civic", "Honda", 2020);
        gerenciamento.cadastrarVeiculo("XYZ-5678", "Corolla", "Toyota", 2021);

        gerenciamento.reservarVeiculo("ABC-1234", "2024-08-15");
        gerenciamento.reservarVeiculo("XYZ-5678", "2024-08-16");

        gerenciamento.gerarRecibo("ABC-1234", 200);
        gerenciamento.gerarRecibo("XYZ-5678", 250);
    }
}
