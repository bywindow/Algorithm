package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {

  /**
   * dfs로 푸니까 시간초과
   * dp로 풀어보자
   */

  static int n;
  static int[][] tree;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    tree = new int[n][n];
    StringTokenizer st;
    tree[0][0] = Integer.parseInt(br.readLine());
    for(int i = 1; i < n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j <= i; j++){
        // prev : tree[i-1][j] or tree[i-1][j-1]
        int input = Integer.parseInt(st.nextToken());
        // col : 0
        if(j == 0){
          tree[i][j] = tree[i-1][j] + input;
        }
        else if(j == i){
          tree[i][j] = tree[i-1][j-1] + input;
        }
        else{
          tree[i][j] = Math.max(tree[i-1][j], tree[i-1][j-1]) + input;
        }
      }
    }
    for(int i : tree[n-1]){
      answer = Math.max(answer, i);
    }
    System.out.println(answer);
  }
}
