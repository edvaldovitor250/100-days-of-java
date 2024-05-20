public class Day008 {
    public static void main(String[] args) {
        Day008 d1 = new Day008();
        d1.soma(2, 3);
        d1.subtracao(2, 3);
        
    }

      double soma(double numero, double numero2) {
        double somar = numero + numero2;
        return somar;
    }

    double subtracao(double numero, double numero2) {
        double subtrair = numero - numero2;
        System.out.println(subtrair);
        return subtrair;
    }

    double multiplicacao(double numero, double numero2) {
        double multiplicar = numero * numero2;
        System.out.println(multiplicar);
        return multiplicar;
    }

    double divisao(double numero, double numero2) {
        double dividir = numero / numero2;
        System.out.println(dividir);
        return dividir;
    }
}
