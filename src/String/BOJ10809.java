package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ10809 {
    public static void main(String[] args) throws IOException{
        //'a'의 아스키코드값은 97
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] answers = new int[26];
        for(int i = 0; i < input.length(); i++){
            int index = Integer.valueOf(input.charAt(i))-97;
            if(answers[index] == 0){
                answers[index] = i+1;
            }
        }
        for(int i : answers) {
            System.out.print(i == 0 ? -1 : i-1);
            System.out.print(" ");
        }
    }
}
