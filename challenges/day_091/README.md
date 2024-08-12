# Day 91

## Desafio:

	Crie um sistema em Java para gerenciar um festival de música, incluindo venda de ingressos, programação de shows e controle de acesso.

**Resultado:**

```java

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Day091 {

    static class FestivalMusica {

        List<Integer> ingressos;
        List<String> shows;
        int limiteAcesso;

        public FestivalMusica() {
            this.ingressos = new ArrayList<>();
            this.shows = new ArrayList<>();
            this.limiteAcesso = 15000;
        }

        public void vendasDeIngresso(String nomeShow, String nomeUsuario) {
            Random gerador = new Random();
            int ingressoNumero = gerador.nextInt(10000); 

            this.shows.add(nomeShow);
            this.ingressos.add(ingressoNumero);

            System.out.println("Seu ingresso foi " + ingressoNumero + " para o show " + nomeShow);
        }

        public void programarShow(String nomeShow) {
            this.shows.add(nomeShow);
            System.out.println("Show " + nomeShow + " programado com sucesso!");
        }

        public void controleDeAcesso() {
            Random controle = new Random();
            int ingressosVendidos = this.ingressos.size();
            if (ingressosVendidos > limiteAcesso) {
                System.out.println("Atenção: Limite de acesso excedido! Capacidade máxima: " + limiteAcesso);
            } else {
                System.out.println("Acesso permitido. Ingressos vendidos: " + ingressosVendidos + "/" + limiteAcesso);
            }
        }

        public void exibirProgramacao() {
            System.out.println("Programação dos Shows:");
            for (String show : shows) {
                System.out.println("- " + show);
            }
        }
    }

    public static void main(String[] args) {
        FestivalMusica festival = new FestivalMusica();

        festival.programarShow("ROCK RIO");
        festival.programarShow("JAZZ FESTIVAL");
        festival.programarShow("ELECTRO BEATS");

        festival.vendasDeIngresso("ROCK RIO", "Carlos Luiz");
        festival.vendasDeIngresso("JAZZ FESTIVAL", "Maria Silva");

        festival.exibirProgramacao();

        festival.controleDeAcesso();
    }
}
