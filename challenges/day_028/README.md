# Day 28

## Desafio:

		Escreva um programa Java que simule um sistema de votação, contando votos e anunciando o vencedor.

**Resultado:**

```java


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day028 {

    private static Map<String, Integer> votos = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean votacaoAtiva = true;

        System.out.println("Sistema de Votação");
        System.out.println("------------------");
        System.out.println("Candidatos disponíveis:");
        System.out.println("1. Alice");
        System.out.println("2. Bob");
        System.out.println("3. Charlie");

        votos.put("Alice", 0);
        votos.put("Bob", 0);
        votos.put("Charlie", 0);

        while (votacaoAtiva) {
            System.out.println("Digite o nome do candidato para votar (ou 'sair' para encerrar a votação):");
            String voto = scanner.nextLine().trim();

            if (voto.equalsIgnoreCase("sair")) {
                votacaoAtiva = false;
            } else if (votos.containsKey(voto)) {
                votos.put(voto, votos.get(voto) + 1);
                System.out.println("Voto registrado para " + voto);
            } else {
                System.out.println("Candidato inválido. Tente novamente.");
            }
        }

        anunciarVencedor();
        scanner.close();
    }

    private static void anunciarVencedor() {
        String vencedor = null;
        int maxVotos = 0;
        boolean empate = false;

        System.out.println("\nResultados da Votação:");
        for (Map.Entry<String, Integer> entry : votos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votos");
            if (entry.getValue() > maxVotos) {
                maxVotos = entry.getValue();
                vencedor = entry.getKey();
                empate = false;
            } else if (entry.getValue() == maxVotos) {
                empate = true;
            }
        }

        if (empate) {
            System.out.println("A votação terminou em empate.");
        } else {
            System.out.println("O vencedor é " + vencedor + " com " + maxVotos + " votos!");
        }
    }
}
