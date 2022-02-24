package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {

  static int n, m;
  static StringBuilder sb = new StringBuilder();

  //dfs로 탐색
  static void dfs(int cnt, int cur, String r){
    if(cnt == m){
      sb.append(r).append("\n");
      return;
    }
    for(int i = cur; i < n+1; i++){
      dfs(cnt+1, i, r+" "+i);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for(int i = 1; i < n+1; i++){
      dfs(1, i, String.valueOf(i));
    }
    System.out.println(sb.toString());
  }
}
