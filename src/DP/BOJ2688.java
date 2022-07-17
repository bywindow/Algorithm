package DP;

import java.util.Scanner;

public class BOJ2688 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            long[][] dp = new long[10][n+1]; //n의 최댓값이 64이다. 출력결과의 범위를 생각하자
            for(int j = 0; j < 10; j++){
                dp[j][0] = 1;
            }
            for(int j = 0; j < n+1; j++){
                dp[0][j] = 1;
            }
            for(int j = 1; j < n+1; j++){
                for(int k = 1; k < 10; k++){
                    dp[k][j] = dp[k-1][j] + dp[k][j-1];
                }
            }
            System.out.println(dp[9][n]);
        }
    }
}
