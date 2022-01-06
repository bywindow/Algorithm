package Baekjoon;

import java.io.*;
import java.util.*;


public class BOJ11047 {
    public static void main(String[] args) throws IOException{
        // 큰 동전부터 탐색하면서 n > 동전의 가격일 때 카운트
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] tokens = new int[n];

        for(int i = 0; i < n; i++){
            tokens[i] = Integer.parseInt(br.readLine());
        }

        int cur = k;
        int answer = 0;

        while(cur > 0){
            for(int i = n-1; i >= 0; i--){
                if(cur - tokens[i] < 0) continue;
                cur -= tokens[i];
                answer++;
                break;
            }
        }
        System.out.println(answer);
    }
}
