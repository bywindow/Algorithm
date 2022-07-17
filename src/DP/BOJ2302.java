package DP;

import java.util.Scanner;

public class BOJ2302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[n+1];
        boolean[] isVip = new boolean[n+1];
        for(int i = 0; i < m; i++){
            int vip = sc.nextInt();
            isVip[vip] = true;
        }
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n+1; i++){
            if(isVip[i] || isVip[i-1]){
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = dp[i-2] + dp[i-1];
        }
        System.out.println(dp[n]);
    }
}
