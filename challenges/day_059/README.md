# Day 59

## Desafio:

Escreva um programa Java que simule o funcionamento de um sistema de recomendação de filmes, utilizando algoritmos de filtragem colaborativa
**Resultado:**


```java


import java.util.*;

public class Day059 {

    public static void main(String[] args) {
        Day059 day = new Day059();
        day.terror();
        day.comedia();
        day.acao();
        day.drama();
        day.animacao();
    }

    String[] terror = {"A noite do demônio", "A vida é a posta", "Você é o inverno"};
    String[] comedia = {"Todo Mundo em Pânico", "As Branquelas", "O Máskara"};
    String[] acao = {"Velozes e Furiosos", "Mad Max: Estrada da Fúria", "John Wick"};
    String[] drama = {"Um Sonho de Liberdade", "A Vida é Bela", "Clube da Luta"};
    String[] animacao = {"Toy Story", "Procurando Nemo", "O Rei Leão"};

    public void terror(){
        System.out.println("Filmes de Terror:");
        for (String filme : terror) {
            System.out.println(filme);
        }
    }

    public void comedia(){
        System.out.println("Filmes de Comédia:");
        for (String filme : comedia) {
            System.out.println(filme);
        }
    }

    public void acao(){
        System.out.println("Filmes de Ação:");
        for (String filme : acao) {
            System.out.println(filme);
        }
    }

    public void drama(){
        System.out.println("Filmes de Drama:");
        for (String filme : drama) {
            System.out.println(filme);
        }
    }

    public void animacao(){
        System.out.println("Filmes de Animação:");
        for (String filme : animacao) {
            System.out.println(filme);
        }
    }
}
