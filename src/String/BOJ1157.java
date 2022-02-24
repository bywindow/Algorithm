package String;

import java.util.*;
import java.io.*;

public class BOJ1157 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //'A' == 65 'a' == 97
        int[] map = new int[26];
        for(int i = 0; i < input.length(); i++){
            int cur = Integer.valueOf(input.charAt(i));
            if(cur > 96) cur -= 32;
            map[cur-65]++;
        }
        boolean isTwo = false;
        int max = map[0];
        char answer = 'A';
        for(int i = 1; i < map.length; i++){
            if(max < map[i]){
                max = map[i];
                answer = Character.toChars(i+65)[0];
                isTwo = false;
            }
            else if(max == map[i]){
                isTwo = true;
            }
        }
        System.out.println(isTwo ? "?" : answer);
    }
}
