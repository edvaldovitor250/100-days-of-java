# Day 41

## Desafio:

	Escreva um programa Java que simule o funcionamento de um sistema de reservas em um cinema, permitindo a reserva de assentos e a visualização de sessões disponíveis.

**Resultado:**


```java

import java.util.ArrayList;
import java.util.List;

public class Cinema {

    List<Integer> acentos;
    List<Integer> numerosDisponivel;

    public Cinema() {
        this.acentos = new ArrayList<>();
        this.numerosDisponivel = new ArrayList<>();
    }
    
    public void listarAcentos() {
        for (int i = 0; i < this.acentos.size(); i++) {
            System.out.println(this.acentos.get(i));
        }

        for (int i = 0 ; i < this.numerosDisponivel.size(); i++) {
            System.out.println(this.numerosDisponivel.get(i));
    }
}

   public void escolherAcento(int acento, int numeros){
    this.acentos.add(acento);
    this.numerosDisponivel.add(numeros);
    System.out.println("Acento escolhido: " + acento);
    System.out.println("Número escolhido: " + numeros);
   }


}



public class Day041 {

    public static void main(String[] args) {
      Cinema c1 = new Cinema();
      c1.escolherAcento(2, 3);
      c1.listarAcentos();

    }

}
