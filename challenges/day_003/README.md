# Day 3

## Desafio:

Declare uma variável em Java, atribua um número a ela e imprima o número no console.

**Resultado:**

```java

import java.util.Scanner;

public class Day003 {
    public static void main(String[] args) {
        Scanner n1 = new Scanner(System.in);
        
        try {

            System.out.println("Informe seu primeiro numero para calcular: ");
            double numero1 = n1.nextDouble();
    
            System.out.println("Informe seu segundo numero para calcular: ");
            double numero2 = n1.nextDouble();
    
            double soma = numero1 + numero2;
    
            
            System.out.println("Seu resultado da soma " + soma);
    
            
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, insira números válidos.");
        } finally {
        n1.close();
    }
       


  
    }

}
