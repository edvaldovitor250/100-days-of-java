public class Entrega {
    
    String destino;
    double peso;

    public Entrega(String destino, double peso) {
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "destino='" + destino + '\'' +
                ", peso=" + peso +
                '}';
    }
}
