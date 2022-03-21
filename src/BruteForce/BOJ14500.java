package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {

  /**
   * dfs로 풀어보자 : 각 칸으로 돌면서 1. 밑 노드로 2. 옆 노드로
   * 포인터 이동 방향을 두가지로 제한했을 때는 L을 시계/반시계 방향으로 90도만큼 회전한 도형에 대해 탐색 못함
   */

  static int n,m;
  static int[][] map;
  static int answer = 0;
  static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static boolean[][] visited;
  static int[][] ecp1 = {{0, -1, 0, 1}, {0, -1, 1, 0}, {0, 1, 1, 0}};
  static int[][] ecp2 = {{1, 0, 0, 1}, {-1, 0, 1, 0}, {-1, 0, 0, 1}};

  static void dfs(int sr, int sc, int r, int c, int cnt, int sum){

    if(cnt == 4){
      answer = Math.max(answer, sum);
      return;
    }

    for(int i = 0; i < 4; i++){
      int nr = r + move[i][0];
      int nc = c + move[i][1];
      if(0 <= nr && nr < n && 0 <= nc && nc < m && !visited[nr][nc]){
        visited[nr][nc] = true;
        dfs(sr, sc, nr, nc, cnt+1, sum+map[nr][nc]);
        visited[nr][nc] = false;
      }
    }


    // shape : ㅜ ㅏ ㅗ ㅓ
    if(cnt == 2){
      if(r-sr == 1 && c-sc == 0){
        for(int i = 0; i < 3; i++){
          int nr1 = r + ecp1[i][0];
          if(nr1 < 0 || nr1 >= n) continue;
          int nc1 = c + ecp1[i][1];
          if(nc1 < 0 || nc1 >= m) continue;
          int nr2 = r + ecp1[i][2];
          if(nr2 < 0 || nr2 >= n) continue;
          int nc2 = c + ecp1[i][3];
          if(nc2 < 0 || nc2 >= m) continue;
          answer = Math.max(answer, sum + map[nr1][nc1] + map[nr2][nc2]);
        }
      }
      else if(r-sr == 0 && c-sc == 1){
        for(int i = 0; i < 3; i++){
          int nr1 = r + ecp2[i][0];
          if(nr1 < 0 || nr1 >= n) continue;
          int nc1 = c + ecp2[i][1];
          if(nc1 < 0 || nc1 >= m) continue;
          int nr2 = r + ecp2[i][2];
          if(nr2 < 0 || nr2 >= n) continue;
          int nc2 = c + ecp2[i][3];
          if(nc2 < 0 || nc2 >= m) continue;
          answer = Math.max(answer, sum + map[nr1][nc1] + map[nr2][nc2]);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken()); // row
    m = Integer.parseInt(st.nextToken()); // col
    map = new int[n][m];
    visited = new boolean[n][m];
    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < m; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        visited[i][j] = true;
        dfs(i, j, i, j, 1, map[i][j]);
        visited[i][j] = false;
      }
    }
    System.out.println(answer);
  }
}
