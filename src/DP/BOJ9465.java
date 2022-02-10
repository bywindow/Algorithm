package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ9465 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int i = 0; i < t; i ++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            for(int j = 0; j < 2; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k < n+1; k++){
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            /**
             * 1행, 2행을 기준으로 1열->n+1열 방향으로 더해나갈 때, 각 인덱스에서 계산될 수 있는 최댓값을 dp에 저장한다
             * [0][i]: [1][i-2]와 [1][i-1]에서의 최댓값에 자기자신의 값을 더한다
             * [1][i]: [0][i-2]와 [0][i-1]에서의 최댓값에 자기자신의 값을 더한다
             */
            //dp 초기화
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            int answer = 0;

            for(int j = 2; j < n+1; j++){
                dp[0][j] = Math.max(dp[1][j-2], dp[1][j-1]) + sticker[0][j];
                dp[1][j] = Math.max(dp[0][j-2], dp[0][j-1]) + sticker[1][j];
            }
            answer = Math.max(dp[0][n], dp[1][n]);
            System.out.println(answer);
        }
    }
}
