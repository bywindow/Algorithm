package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1463 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    int[] dp = new int[x+1];
    Arrays.fill(dp, x);
    dp[1] = 1;
    for(int i = 1; i < dp.length; i++){
      if(i*3 < x+1){
        dp[i*3] = Math.min(dp[i*3], dp[i]+1);
      }
      if(i*2 < x+1){
        dp[i*2] = Math.min(dp[i*2], dp[i]+1);
      }
      if(i+1 < x+1){
        dp[i+1] = Math.min(dp[i+1], dp[i]+1);
      }
    }
    System.out.println(dp[x]-1);
  }
}
