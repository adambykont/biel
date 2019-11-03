package pl.janusz.buchalka.dsa.pt05.palindrome;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public class PalindromeChecker {

    private static Deque<String> stack = new LinkedList<>();

    public static boolean isPalindrome(String word) {

        if (word == null) {
            return true;
        }

        word = word.trim();
        word = word.toLowerCase();
        word = word.replace(" ", "");

        if (word.length() == 0) {
            return true;
        }

        int left = 0;
        int right = word.length() - 1;

        while (left <= right) {
            stack.push(word.charAt(left) + "");
            left++;
            String corresponding = word.charAt(right) + "";
            right--;
            if (!stack.pop().equals(corresponding)) {
                return false;
            }
        }

        return true;
    }
}
