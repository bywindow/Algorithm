package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ15486 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[2][n+2];
        for(int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                board[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dp = new int[n+2];
        /**
         * dp 배열에는 해당 날짜에서 받을 수 있는 금액을 적는다
         * 만약, board[_][1] = { 3, 10 }, board[_][4] = { 1, 20 } 이라면
         * dp[4]은 10, dp[5]는 10 + 20 = 30이 된다.
         */
        int curMax = 0;
        for(int i = 1; i < n+2 ; i++){
            if(curMax < dp[i]) curMax = dp[i];//최댓값 업데이트
            if(i + board[0][i] > n+1) continue; //범위 밖일 때는 스킵
            dp[i + board[0][i]] = Math.max(dp[i + board[0][i]], curMax + board[1][i]);
        }
        System.out.println(curMax);
    }
}
