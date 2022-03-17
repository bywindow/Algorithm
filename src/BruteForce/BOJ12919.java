package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12919 {
    /**
     * 두가지 경우를 recursive하게 탐색 -> 시간초과
     * 1. StringBuilder를 이용한 reverse()는 시간초과
     * 2. for문을 활용한 뒤집기는 시간초과
     *
     * BFS를 사용하여 탐색 -> 메모리초과
     *
     * t에서 주어진 경우에 따라 문자열을 제거하면서(재귀) s가 나오는지 확인
     *
     */

    static boolean answer = false;
    static StringBuilder sb;

    static void recur(String s, String t){
        // stop condition
        if(s.equals(t)) {
            answer = true;
            return;
        }
        if(s.length() >= t.length()) return;

        // t의 끝자리가 A인 경우
        if(t.charAt(t.length()-1) == 'A'){
            recur(s, t.substring(0, t.length()-1));
        }
        // t의 첫번째 글자가 B인 경우
        String temp = "";
        if(t.charAt(0) == 'B'){
            // 뒤집고 B를 제거
            sb = new StringBuilder(t);
            temp = sb.reverse().toString().substring(0, t.length()-1);
            recur(s, temp);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        recur(s, t);

        System.out.println(answer ? 1 : 0);
    }
}
