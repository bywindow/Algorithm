package Solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1025 {

  /**
   * 
   */
  static int n, m;
  static int[][] a;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    a = new int[n][m];
    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      for (int j = 0; j < m; j++) {
        a[i][j] = input.charAt(j) - '0';
      }
    }
    int answer = -1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int cur = a[i][j];
        for (int k = -n + 1; k < n; k++) {
          for (int p = -m + 1; p < m; p++) {

          }
        }
      }
    }
  }

}
