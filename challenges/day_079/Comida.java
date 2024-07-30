public class Comida {
    
    String nome;
    String precico;
    double peso;

    public Comida(String nome, String precio, double peso) {
        this.nome = nome;
        this.precico = precio;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "nome='" + nome + '\'' +
                ", precio='" + precico + '\'' +
                ", peso=" + peso +
                '}';
     }


   

   
}
