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
