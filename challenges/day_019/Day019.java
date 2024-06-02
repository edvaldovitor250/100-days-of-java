import java.util.Scanner;

public class Day019 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            System.out.println("The first " + n + " terms of the Fibonacci sequence are:");
            for (int i = 0; i < n; i++) {
                System.out.print(fibonacci(i) + " ");
            }
        }
    }
    
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
