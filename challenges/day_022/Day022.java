
public class Day022 {

    public static void main(String[] args) {
        Day022 day022 = new Day022();
        day022.verificadorDeNumeros(4);
    }


    
    public void verificadorDeNumeros(int numero) {
        System.out.println("O número está sendo girado em " + numero);
        String mensagem = (numero >= 1 && numero <= 6) 
            ? "O número do dado é " + numero 
            : "O número não foi encontrado, tente novamente.";
        System.out.println(mensagem);
    }
    

}