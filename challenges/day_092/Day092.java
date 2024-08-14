import java.util.ArrayList;
import java.util.List;

public class Day092 {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public static int lcmOfList(List<Integer> numbers) {
        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result = lcm(result, numbers.get(i));
        }
        return result;
    }
    

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(15);
        numbers.add(20);

        int result = lcmOfList(numbers);
        System.out.println("LCM of the list is: " + result);
    }
}
