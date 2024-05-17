public class Day005 {
    public static void main(String[] args) {
        Day005 d1 = new Day005();
        d1.fatorial(4);
    }

    public void fatorial(int numero) {
        if (numero < 0) {
            System.out.println("Digite um número válido, positivo e não negativo.");
            return;
        }

        try {
            int resultadoFatorial = 1;
            for (int i = 1; i <= numero; i++) {
                resultadoFatorial *= i;
            }
            System.out.println("O fatorial de " + numero + " é " + resultadoFatorial);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao calcular o fatorial: " + e.getMessage());
        } finally {
            System.out.println("A execução do projeto foi concluída.");
        }
    }
}
