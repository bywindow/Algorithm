package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ3052 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] results = new int[42];
        for(int i = 0; i < 10; i++){
            int cur = Integer.parseInt(br.readLine()) % 42;
            results[cur]++;
        }
        int answer = 0;
        for(int i = 0; i < results.length; i++){
            if(results[i] > 0) answer++;
        }
        System.out.println(answer);
    }
}
