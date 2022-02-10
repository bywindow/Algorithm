package DP;

import java.math.*;
import java.util.*;
import java.io.*;

public class BOJ2407 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        /**
         * dp 배열을 만든다. 인덱스 1부터 시작
         * dp[m] = 1,
         * 점화식 : dp[i+1] = dp[i] * (i+1) / (i-m)
         */
        BigInteger[] dp = new BigInteger[n+1];
        dp[m] = new BigInteger("1");
        for(int i = m+1; i < dp.length; i++){
            dp[i] = dp[i-1].multiply(BigInteger.valueOf(i)).divide(BigInteger.valueOf(i-m));
        }
        System.out.println(dp[n]);
    }
}
