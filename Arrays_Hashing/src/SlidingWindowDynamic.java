import java.util.HashMap;
import java.util.Map;

public class SlidingWindowDynamic {
    public static void main(String[] args) {
        //String str = "my name is anitha";
        String str = "aabcbcdbca";
        char[] chars = {'d', 'b', 'c' , 'a'};
        String result = findSmallestSubstring(str, chars);
        System.out.println("Smallest substring: " + result);
    }
    public static String findSmallestSubstring(String str, char[] chars) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : chars) {
            charCount.put(c, 0);
        }

        int required = chars.length;
        int left = 0, right = 0, formed = 0;
        int minLength = Integer.MAX_VALUE;
        String result = "";

        while (right < str.length()) {
            char rightChar = str.charAt(right);
            if (charCount.containsKey(rightChar)) {
                charCount.put(rightChar, charCount.get(rightChar) + 1);
                if (charCount.get(rightChar) == 1) {
                    formed++;
                }
            }
            right++;
            while (formed == required) {
                if (right - left < minLength) {
                    minLength = right - left;
                    result = str.substring(left, right);
                }

                char leftChar = str.charAt(left);
                if (charCount.containsKey(leftChar)) {
                    charCount.put(leftChar, charCount.get(leftChar) - 1);
                    if (charCount.get(leftChar) == 0) {
                        formed--;
                    }
                }
                left++;
            }
        }

        return result;
    }
}
