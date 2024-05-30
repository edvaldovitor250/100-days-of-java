public class Day018 {

    public static void main(String[] args) {
        int numTerms = 1000000; 
        double pi = calculatePi(numTerms);
        System.out.println("Aproximação de π usando " + numTerms + " termos: " + pi);
    }

    public static double calculatePi(int numTerms) {
        double sum = 0.0;

        for (int i = 0; i < numTerms; i++) {
            double term = Math.pow(-1, i) / (2 * i + 1);
            sum += term;
        }

        return 4 * sum;
    }
}
