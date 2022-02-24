package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2667 {

  /**
   * dfs로 인접한 칸을 탐색
   */

  static int n, cnt;
  static int[][] map;
  static boolean[][] visited;
  static int[] moveR = {-1, 0, 1, 0};
  static int[] moveC = {0, 1, 0, -1};

  // dfs 탐색
  static void dfs(int r, int c){
    // already visited : skip
    if(visited[r][c]) return;
    // 0 : skip
    if(map[r][c] == 0) return;
    // if 1
    cnt++;
    visited[r][c] = true;
    for(int i = 0; i < 4; i++){
      int nr = r + moveR[i];
      int nc = c + moveC[i];
      // check range and move
      if(0<=nr && nr<n && 0<=nc && nc<n){
        dfs(nr, nc);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    visited = new boolean[n][n];
    for(boolean[] v: visited){
      Arrays.fill(v, false);
    }

    for(int i = 0; i < n; i++){
      String str = br.readLine();
      for(int j = 0; j < n; j++){
        map[i][j] = Integer.parseInt(str.substring(j,j+1));
      }
    }
    cnt = 0;
    ArrayList<Integer> ans = new ArrayList<>();
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        if(map[i][j] == 0 || visited[i][j]) continue;
        // not 0 and not visited : 1
        cnt = 0;
        dfs(i, j);
        ans.add(cnt);
      }
    }
    System.out.println(ans.size());
    if(ans.size() > 0){
      Collections.sort(ans);
      for(int answer: ans){
        System.out.println(answer);
      }
    } else System.out.println(0);
  }
}
