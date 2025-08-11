public class Palindrome {
    public static boolean isPalindrome(String s) {
           if (s == null) return false;

        int len = s.length();
        if (len == 0) return true; 

        int mid = len / 2;

        String firstHalf = s.substring(0, mid);
        String secondHalf;

        if (len % 2 == 0) {
            secondHalf = s.substring(mid);
        } else {
            secondHalf = s.substring(mid + 1);
        }
        String reversedSecond = new StringBuilder(secondHalf).reverse().toString();
        return firstHalf.equals(reversedSecond);
    }
}