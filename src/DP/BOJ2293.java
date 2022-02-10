package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2293 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] tokens = new int[n+1];
        for(int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            tokens[i] = Integer.parseInt(st.nextToken());
        }
        /**
         * dp를 사용 : dp[n][k]
         * dp[i][j] : tokens[i]를 사용해서 j를 만들 수 있는 경우의 수
         * j가 tokens[i]보다 작으면 : dp[i][j] = dp[i-1][j]
         * j가 tokens[i]보다 크거나 같으면 : dp[i][j] = dp[i-1][j] + dp[i][j-tokens[i]]
         * 만약 k가 6일 때, 1,2,5 세 수로 6을 만드는 경우의 수 = (1,2로 6을 만드는 경우의 수) + (1,2,5로 1을 만드는 경우의 수)
         * 1,2,5로 1을 만드는 경우에 5를 붙이면 6이 되기 때문
         */
        long dp[][] = new long[n+1][k+1];
        dp[0][0] = 1;
        for(int i = 1; i < n+1; i++){
            for(int j = 0; j < k+1; j++){
                if(j < tokens[i]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-tokens[i]];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
