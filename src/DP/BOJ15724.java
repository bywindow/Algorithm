package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15724 {

    public static void main(String[] args) throws IOException {
        /**
         * 직사각형 범위로 구하니까 dp 배열을 만들어서 해당 칸에는 (자신 + 자신의 왼쪽 + 위쪽)의 수를 적는다
         * a b c d -> dp[c][d] - dp[c][b-1] - dp[a-1][d] + dp[a-1][b-1]
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][m+1];
        long[][] dp = new long[n+1][m+1];

        for(int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < m+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + (long) map[i][j] - dp[i-1][j-1];
            }
        }

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()); //r
            int y2 = Integer.parseInt(st.nextToken()); //c
            System.out.println(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]);
        }
    }
}
