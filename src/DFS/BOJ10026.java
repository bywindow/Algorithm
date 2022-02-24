package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026 {

  static int n;
  static char[][] board;
  static char[][] nBoard; // 적록색약
  static int[][] visited;
  static int[][] nVisited; // 적록색약
  static int[] moveX = {0, 0, -1, 1};
  static int[] moveY = {-1, 1, 0, 0};

  static void dfs(char[][] b, int[][] v, int g, int r, int c, char cur){
    if(v[r][c] != 0) return;
    if(b[r][c] != cur) return;

    v[r][c] = g;

    for(int i = 0; i < 4; i++){
      int nr = r + moveY[i];
      int nc = c + moveX[i];
      if(0<=nr && nr<n && 0<=nc && nc < n){
        dfs(b, v, g, nr, nc, cur);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new char[n][n];
    nBoard = new char[n][n];
    visited = new int[n][n];
    nVisited = new int[n][n];
    for(int i = 0; i < n; i++){
      String input = br.readLine();
      for(int j = 0; j < input.length(); j++){
        char c = input.charAt(j);
        board[i][j] = c;
        nBoard[i][j] = c == 'B' ? c : 'R'; // 적록색약은 G 대신 R
      }
    }
    int cnt = 0;
    int nCnt = 0;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        if(visited[i][j] == 0) dfs(board, visited, ++cnt, i, j, board[i][j]);
        if(nVisited[i][j] == 0) dfs(nBoard, nVisited, ++nCnt, i, j, nBoard[i][j]);
      }
    }
    System.out.println(cnt + " " + nCnt);
  }
}
