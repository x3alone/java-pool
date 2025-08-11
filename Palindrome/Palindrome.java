public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) return false;

        String str = s.toLowerCase();

        int len = str.length();
        if (len == 0) return true; 

        int mid = len / 2;

        String firstHalf = str.substring(0, mid);
        String secondHalf;

        if (len % 2 == 0) {
            secondHalf = str.substring(mid);
        } else {
            secondHalf = str.substring(mid + 1);
        }
        String reversedSecond = new StringBuilder(secondHalf).reverse().toString();
        return firstHalf.equals(reversedSecond);
    }
}