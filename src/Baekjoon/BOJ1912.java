package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1912 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        /**
         * 첫번째 인덱스부터 계속 더해나가는 dp 배열을 만든다
         * 더했을 때 0보다 작으면 초기화하고 해당 인덱스부터 다시 더해나간다
         */
        dp[0] = numbers[0];
        int answer = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i-1] + numbers[i], numbers[i]);
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);
    }
}
