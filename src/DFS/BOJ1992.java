package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {

  static int[][] board;
  static StringBuilder sb = new StringBuilder();

  static void dfs(int n, int r, int c){
    //2X2 : check and return
    if(n==2){
      if(board[r][c] == board[r+1][c] && board[r][c] == board[r][c+1] && board[r][c] == board[r+1][c+1]){
        sb.append(board[r][c]);
      }
      else{
        sb.append("(")
          .append(board[r][c])
          .append(board[r][c+1])
          .append(board[r+1][c])
          .append(board[r+1][c+1])
          .append(")");
      }
      return;
    }

    sb.append("(");
    int cur = n/2;
    dfs(cur, r, c);
    dfs(cur, r, c+cur);
    dfs(cur, r + cur, c);
    dfs(cur, r+cur, c+cur);
    sb.append(")");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    board = new int[n][n];
    for(int i = 0; i < n; i++){
      String input = br.readLine();
      for(int j = 0; j < n; j++){
        board[i][j] = Integer.parseInt(input.substring(j,j+1));
      }
    }
    // n == 1인 경우 예외처리
    if(n == 1){
      System.out.println(board[n][n]);
      return;
    }
    dfs(n, 0, 0);
    String answer = sb.toString();
    // make group
    while(answer.contains("(1111)") || answer.contains("(0000)")){
      answer = answer.replace("(1111)", "1");
      answer = answer.replace("(0000)", "0");
    }
    System.out.println(answer);
  }
}
