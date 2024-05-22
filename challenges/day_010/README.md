# Day 10

## Desafio:

Escreva um programa Java que converta uma temperatura de Celsius para Fahrenheit e vice-versa.

**Resultado:**

```java

public class Day010 {
    public static void main(String[] args) {
       
       Day010 d9 = new Day010();
       d9.TransformacaoDeGParaF(20);
       d9.TransformacaoDeFParaG(80);


    }

    static void TransformacaoDeGParaF(int C){
        double calcular = (C * 1.8) + 32;
        System.out.println(calcular + " De graus");

    }

    static int TransformacaoDeFParaG(int F ){
        double calcular = (F - 32) / 1.8;
        System.out.println(calcular + " De Fahrenheit");
        return (int) calcular;
    }

}
