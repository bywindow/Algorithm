package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {

  /**
   * bfs로 풀자
   */

  static int n, m, h;
  static int[][] tomatoes;
  static int[] moveR;
  static int[] moveC;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken()); //col
    n = Integer.parseInt(st.nextToken()); //row
    h = Integer.parseInt(st.nextToken()); //height

    moveR = new int[]{-n, n, 0, 0, -1, 1}; //up, down, left, right, front, back
    moveC = new int[]{0, 0, -1, 1, 0, 0};

    tomatoes = new int[n*h][m];
    Queue<int[]> curTomato = new LinkedList<>(); // {r, c, day}
    int cntZero = 0;

    for(int j = 0; j < n * h; j++){
      st = new StringTokenizer(br.readLine());
      for(int k = 0; k < m; k++){
        tomatoes[j][k] = Integer.parseInt(st.nextToken());
        if(tomatoes[j][k] == 1) {
          curTomato.add(new int[]{j, k});
        }
        else if(tomatoes[j][k] == 0){
          cntZero++;
        }
      }
    }

    int answer = 0;

    while(!curTomato.isEmpty()){
      int[] cur = curTomato.poll();
      int curR = cur[0];
      int curC = cur[1];
      int curDay = tomatoes[curR][curC];
      answer = curDay;
      // move next index
      for(int i = 0; i < 6; i++){
        int nr = curR + moveR[i];
        int nc = curC + moveC[i];
        // 2차원배열로 설정했으므로 층이 다른데 이동할 수 있는 경우가 생김
        if(curR % n == n-1 && nr % n == 0) continue;
        // 반대
        if(curR % n == 0 && nr % n == n-1) continue;
        int nDay = curDay + 1;
        if(0<=nr && nr<n*h && 0<=nc && nc<m){
          if(tomatoes[nr][nc] != 0) continue;
          tomatoes[nr][nc] = nDay;
          curTomato.add(new int[]{nr, nc});
          cntZero--;
        }
      }
    }

    System.out.println(cntZero == 0 ? answer-1 : -1);
  }
}
