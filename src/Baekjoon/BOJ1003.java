package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {

  /**
   * dp로 풀어보자
   * 0 -> 0: 1, 1: 0
   * 1 -> 0: 0, 1: 1
   * 2 -> 1 + 0 -> 0: 1, 1: 1
   * 3 -> 2 + 1 -> 0: 1, 1: 1
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    int[][] dp = new int[2][41];
    dp[0][0] = dp[1][1] = 1;
    dp[1][0] = dp[0][1] = 0;

    for(int i = 2; i < 41; i++){
      dp[0][i] = dp[0][i-2] + dp[0][i-1];
      dp[1][i] = dp[1][i-2] + dp[1][i-1];
    }
    for(int i = 0; i < t; i++){
      int cur = Integer.parseInt(br.readLine());
      sb.append(dp[0][cur]).append(" ").append(dp[1][cur]).append("\n");
    }
    System.out.println(sb.toString());
  }
}
