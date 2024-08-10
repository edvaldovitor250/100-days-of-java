# Day 89

## Desafio:

	Desenvolva um aplicativo em Java que simule um sistema de gerenciamento de reservas em uma companhia aérea, permitindo reservar voos, gerenciar assentos e emitir bilhetes.

**Resultado:**


```java

import java.util.ArrayList;
import java.util.List;

public class Day089 {

    static class CompanhiaVoos{
        List<String> nomevoos;
        List<String> assentosVoos;
        List<Integer> bilhetesVoos;

        public CompanhiaVoos() {
            this.nomevoos = new ArrayList<>();
            this.assentosVoos = new ArrayList<>();
            this.bilhetesVoos = new ArrayList<>();
        }

        public void reservarVoos (String nomeVoo, String assentosVoo, int bilhetesVoo) {
            this.nomevoos.add(nomeVoo);
            this.assentosVoos.add(assentosVoo);
            this.bilhetesVoos.add(bilhetesVoo);
        }

        public void gerenciarVoos(){
            System.out.println("Voos reservados:");
            for (int i = 0; i < nomevoos.size(); i++) {
                System.out.println("Voo: " + nomevoos.get(i) + ", Assentos: " + assentosVoos.get(i) + ", Bilhetes: " + bilhetesVoos.get(i));
            }
        }
        
        public void emitirBilhete(){
            int randomIndex = (int) (Math.random() * nomevoos.size());
            System.out.println("Bilhete emitido para o voo: " + nomevoos.get(randomIndex));
        }
    }



    public static void main(String[] args) {
        CompanhiaVoos companhia = new CompanhiaVoos();

        companhia.reservarVoos("Voo 101", "10A", 1);
        companhia.reservarVoos("Voo 202", "12B", 2);
        companhia.reservarVoos("Voo 303", "14C", 1);

        companhia.gerenciarVoos();

        companhia.emitirBilhete();
    }



}
