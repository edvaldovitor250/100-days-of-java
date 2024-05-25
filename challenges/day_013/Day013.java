public class Day013 {

    public static void main(String[] args) {
        String[] testStrings = { "arara", "radar", "palindrome", "A man, a plan, a canal, Panama" };

        for (String testString : testStrings) {
            boolean result = isPalindrome(testString);
            System.out.println("\"" + testString + "\" é um palíndromo? " + result);
        }
    }

    public static boolean isPalindrome(String str) {
        String cleanedStr = str.replaceAll("[\\W_]", "").toLowerCase();

        int left = 0;
        int right = cleanedStr.length() - 1;

        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
