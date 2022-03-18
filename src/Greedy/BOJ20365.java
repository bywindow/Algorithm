package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20365 {

    static int n;

    static int stringCheck(String s, String t){
        int result = 1;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == t.charAt(i)) continue;
            result++;
            for(int j = i; j < n; j++){
                if(s.charAt(j) == t.charAt(j)) break;
                i = j;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        StringBuilder allB = new StringBuilder();
        StringBuilder allR = new StringBuilder();

        for(int i = 0; i < n; i++){
            allB.append("B");
            allR.append("R");
        }

        System.out.println(Math.min(stringCheck(allB.toString(), input), stringCheck(allR.toString(), input)));
    }
}
