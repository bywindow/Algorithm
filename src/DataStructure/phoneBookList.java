package DataStructure;

public class phoneBookList {

    public static boolean solution(String[] input) {
        boolean output = true;
        boolean breakpoint = false;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i != j && input[i].length() <= input[j].length()) {
                    if (input[i].equals(input[j].substring(0, input[i].length()))) {
                        output = false;
                        breakpoint = true;
                        break;
                    }
                }
            }
            if (breakpoint) break;
        }
        return output;
    }

    public static void main(String[] args) {
        String[] input = {"119", "97674223", "1195524421"};
        System.out.println(solution(input));
    }
}

/*
import java.util.Arrays;

class Solution {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        boolean result = true;
        for (int i=0; i<phoneBook.length-1; i++) {
            if (phoneBook[i+1].contains(phoneBook[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
 */
