package DP;

import java.io.*;
import java.util.*;

public class BOJ1890 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] dp = new long[n][n];
        /**
         * 점화식...
         * dp 배열에는 해당 인덱스에 몇 번 왔는지 기록
         * dp[i][j]에 왔을 때, dp[i+map[i][j]][j]와 dp[i][j+map[i+j]를 dp[i][j]만큼 증가
         */
        dp[0][0] = 1;
        for(int i = 0; i< n; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j] > 0 && map[i][j] > 0){
                    if(i+map[i][j] < n){
                        dp[i+map[i][j]][j] += dp[i][j];
                    }
                    if(j+map[i][j] < n){
                        dp[i][j+map[i][j]] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
