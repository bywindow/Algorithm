package DP;

import java.util.*;
import java.io.*;

public class BOJ2294 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    /**
     * dp[n+1][k+1]에서 dp[i][j] : 동전 i까지를 사용해서 j를 만들 때 사용되는 동전의 개수
     * 점화식
     * 1. 동전 i 가격 > j 일 때: dp[i][j] = dp[i-1][j]
     * 2. 동전 i 가격 = j 일 때: dp[i][j] = 1
     * 3. 동전 i 가격 < j 일 때: dp[i][j] = dp[i][j-동전 i 가격] == 0 이라면 dp[i-1][j],
     */
    int[] tokens = new int[n+1];
    for(int i = 1; i < n+1; i++){
      st = new StringTokenizer(br.readLine());
      tokens[i] = Integer.parseInt(st.nextToken());
    }
    int[][] dp = new int[n+1][k+1];
    dp[0][0] = 1;
    for(int i = 1; i < n+1; i++){
      for(int j = 1; j < k+1; j++){
        if(j == tokens[i]){
          dp[i][j] = 1;
        }
        else if(j < tokens[i]){
          dp[i][j] = dp[i-1][j];
        }
        else{
          if(dp[i][j-tokens[i]] == 0) dp[i][j] = dp[i-1][j];
          //1번째 동전 ~ i-1번째 동전까지 사용해서 j를 만들 수 없는 경우도 생각해야된다
          else{
            dp[i][j] = dp[i-1][j] == 0 ? dp[i][j-tokens[i]]+1 : Math.min(dp[i-1][j], dp[i][j-tokens[i]]+1);
          }
        }
      }
    }
    System.out.println(dp[n][k] == 0 ? -1 : dp[n][k]);
  }
}
