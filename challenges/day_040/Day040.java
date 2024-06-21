import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day040 {

    public static void main(String[] args) {
        Day040 solver = new Day040();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int targetSum = 10;
        List<int[]> pairs = solver.findPairsWithSum(nums, targetSum);
        solver.printPairs(pairs);
    }

    public List<int[]> findPairsWithSum(int[] nums, int targetSum) {
        List<int[]> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            int complement = targetSum - num;
            if (seen.contains(complement)) {
                result.add(new int[]{complement, num});
            }
            seen.add(num);
        }

        return result;
    }

    public void printPairs(List<int[]> pairs) {
        for (int[] pair : pairs) {
            System.out.println("Pair: (" + pair[0] + ", " + pair[1] + ")");
        }
    }
}
