# Day 4

## Desafio:

	Escreva um programa Java que verifique se um número é par ou ímpar e imprima o resultado.

**Resultado:**

```java

import java.util.Scanner;

public class Day004 {
    public static void main(String[] args) {
        Scanner n1 = new Scanner(System.in);
        
        try {

            System.out.println("Informe o numero para verificar se é par ou impar: ");
            int numero1 = n1.nextInt();

            if (numero1 % 2 == 0) {
                System.out.println("O número " + numero1 + " é par.");
            } else {
                System.out.println("O número " + numero1 + " é impar.");
            }
            
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, insira número válido.");
        } finally {
        n1.close();
    }
    }

}
