package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ17626 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int answer;

        int[] dp = new int[n+1];

//        dp[0] = 0, dp[1] = 1
        dp[1] = 1;
        /**
         * dp[i*i] = 1
         * dp[i] 는 i보다 작거나 같은 제곱수 j 들 중에서 dp[i-j]가 가장 작은 값에서 1을 더한 것
         * ex) n = 18, 18 == 3^2 + 3^2 이므로 2
         * dp[18-1] = 2, dp[18-4] = 3, dp[18-9] = 1, dp[18-16] = 2
         */
        for(int i = 2; i < dp.length; i++){
            answer = 4; // 하나의 수가 최대로 가질 수 있는 제곱수의 개수
            //규칙대로 찾기
            for(int j = 1; j * j <= i; j++){
                answer = Math.min(answer, dp[i - j*j]);
            }
            dp[i] = answer + 1;
        }
        System.out.println(dp[n]);
    }
}
