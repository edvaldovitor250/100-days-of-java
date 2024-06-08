# Day 27

## Desafio:

		Implemente um programa Java que calcule o determinante de uma matriz.

**Resultado:**

```java


public class Day027 {

public static void main(String[] args) {
    int[] somaMatriz = {2,3,4,5,6,3,6,};
    int soma = 0;

    for (int i = 0; i < somaMatriz.length; i++) {
        soma += somaMatriz[i];
    }
    System.out.println("A soma de todos os valores na matriz é: " + soma);


}
    

}