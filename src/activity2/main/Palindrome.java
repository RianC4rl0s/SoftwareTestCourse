package activity2.main;

public class Palindrome {

    public boolean isPalindrome(String word) {

        int size = word.length();

        if (word.equals("")) {
            throw new IllegalArgumentException();
        }

        if (size == 1) return true;

        boolean isEqual = true;
        if (size % 2 == 0) {//even
            for (int i = 0; i < (size / 2) - 1; i++) {
                if (word.charAt(i) != word.charAt(size - 1 - i)) {
                    return false;
                }
            }

        } else {//odd
            for (int i = 0; i < ((size - 1) / 2) - 1; i++) {
                if (word.charAt(i) != word.charAt(size - 1 - i)) {
                    return false;
                }
            }
        }
        return true;
    }

}
