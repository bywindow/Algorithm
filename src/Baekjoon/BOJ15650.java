package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {

  static int n,m;
  static StringBuilder sb = new StringBuilder();

  static void dfs(int cur, int cnt, String str){
    if(cnt == m) {
      sb.append(str).append("\n");
      return;
    }
    if(cur > n) return;
    for(int i = cur+1; i <= n; i++){
      String curStr = str + " " + i;
      dfs(i, cnt+1, curStr);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for(int i = 1; i <= n+1-m; i++){
      dfs(i, 1, String.valueOf(i));
    }
    System.out.println(sb.toString());
  }
}
