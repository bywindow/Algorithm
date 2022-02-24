package DP;

import java.util.*;
import java.io.*;

public class BOJ2156 {
    public static void main(String[] args) throws IOException{

        /**
         * dp[i]는
         * dp[i-1]과
         * wine[i]+wine[i-1]+dp[i-3]과
         * wine[i]+dp[i-2]
         * 중 큰 값
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] wine = new int[n+1];

        for(int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            wine[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        for(int i = 3; i < dp.length; i++){
            dp[i] = Math.max(Math.max(wine[i] + wine[i-1] + dp[i-3], dp[i-1]), wine[i]+dp[i-2]);
        }
        System.out.println(dp[n]);
    }
}
