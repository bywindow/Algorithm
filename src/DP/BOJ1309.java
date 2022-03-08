package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1309 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    /**
     * dp[n][0] : n번째 줄에 사자가 없는 경우
     * dp[n][1] : n번째 줄 왼쪽에 사자가 있는 경우
     * dp[n][2] : n번째 줄 오른쪽에 사자가 있는 경우
     */
    int[][] dp = new int[n+1][3];
    //init
    dp[1][0] = dp[1][1] = dp[1][2] = 1;
    for(int i = 2; i < n+1; i++){
      // no lion
      dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
      // lion is in left
      dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
      // lion is in right
      dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
    }
    System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);
  }
}
