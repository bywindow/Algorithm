package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11057 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    // dp[i][j] = 수의 길이가 i일 때 숫자 j를 써서 나타낼 수 있는 수의 개수
    int[][] dp = new int[n+1][10];
    for(int i = 0; i < 10; i++){
      dp[1][i] = 1;
    }
    for(int i = 0; i < n+1; i++){
      dp[i][0] = 1;
    }
    for(int i = 2; i < n+1; i++){
      for(int j = 1; j < 10; j++){
        dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 10007;
      }
    }
    int answer = 0;
    for(int i : dp[n]){
      answer += i;
    }
    System.out.println(answer % 10007);
  }
}
