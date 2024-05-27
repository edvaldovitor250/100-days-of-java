# Day 15

## Desafio:

Implemente um programa Java que simule uma fila de banco, com operações de entrada e saída de clientes.

**Resultado:**

```java


import java.util.ArrayList;
import java.util.List;

public class BancoCaixa {

    private List<Integer> fila;

    public BancoCaixa(int[] filaInicial) {
        fila = new ArrayList<>();
        for (int cliente : filaInicial) {
            fila.add(cliente);
        }
    }

    public List<Integer> getFila() {
        return new ArrayList<>(fila); 
    }

    public void entradaFila(int cliente) {
        fila.add(cliente);
    }

    public void saidaFila() {
        if (!fila.isEmpty()) {
            fila.remove(0);
        } else {
            System.out.println("A fila está vazia.");
        }
    }

    public void exibirFila() {
        System.out.println("Fila atual: " + fila);
    }
}

public class Day015 {

    public static void main(String[] args) {
        int[] filaInicial = {1, 2, 3, 4};
        BancoCaixa b1 = new BancoCaixa(filaInicial);

        b1.exibirFila();

    }
}
