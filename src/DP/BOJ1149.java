package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {

  /**
   * time limit : 0.5s
   * dfs로 풀려했으나 시간제한 때문에 DP 알고리즘 시도
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] cost = new int[n+1][3];
    StringTokenizer st;
    for(int i = 1; i <= n; i++){
      st = new StringTokenizer(br.readLine());
      // for문 없이 각 비용을 받아서 바로 최솟값을 업데이트한다
      int r = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      // 이전 집에서 같은 색깔을 제외하고 최솟값을 찾는다
      cost[i][0] = r + Math.min(cost[i-1][1], cost[i-1][2]);
      cost[i][1] = g + Math.min(cost[i-1][0], cost[i-1][2]);
      cost[i][2] = b + Math.min(cost[i-1][0], cost[i-1][1]);
    }
    int answer = Integer.MAX_VALUE;
    // find min value
    for(int i : cost[n]){
      answer = Math.min(i, answer);
    }
    System.out.println(answer);
  }
}
