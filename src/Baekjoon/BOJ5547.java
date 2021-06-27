package Baekjoon;

import java.util.*;
import java.io.*;

/**
 * 0과 1이 만나는 곳을 찾으면 된다
 * 0인 곳과 1인 곳이 인접하면 그 면은 외부
 * 가장자리에 있는 면은 따로 기록
 */

public class BOJ5547 {

  static int w;
  static int h;
  static int[][] graph;
  static boolean[][] isOut;
  static int[][] moveOdd = {{-1, 0}, {0, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
  static int[][] moveEven = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {0, 1}, {-1 ,0}};
  static Queue<int[]> q = new LinkedList<>();

  static void checkingOuter(int[][] moving, int curRow, int curCol, int i) {

    int nextRow = curRow + moving[i][0];
    int nextCol = curCol + moving[i][1];
    if(nextRow >= 0 && nextRow <= h+1 && nextCol>=0 && nextCol<=w+1){
      if(!isOut[nextRow][nextCol]){
        if(graph[nextRow][nextCol] == 0){
          isOut[nextRow][nextCol] = true;
          q.offer(new int[] {nextRow, nextCol});
        }
      }
    }
  }

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    w = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    graph = new int[h+2][w+2];
    isOut = new boolean[h+2][w+2];

    for(int i = 1; i < h+1; i++){
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < w+1; j++){
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    //벽으로 둘러싸인 곳을 제외하기 위해 건물의 벽 외부의 여백에만 isOut을 표시해둔다
    q.offer(new int[]{0, 0}); //{row, col}
    isOut[0][0] = true;

    while(!q.isEmpty()){
      int[] cur = q.poll();
      int curRow = cur[0];
      int curCol = cur[1];
      for(int i = 0; i < 6; i++){
        if(curRow % 2 == 0){
          checkingOuter(moveEven, curRow, curCol, i);
        } else {
          checkingOuter(moveOdd, curRow, curCol, i);
        }
      }
    }

    int answer = 0;
    for(int i = 1; i < h+1; i++){
      for(int j = 1; j < w+1; j++){
        if(graph[i][j] == 0) continue;
        for(int n = 0; n < 6; n++){
          int nextRow;
          int nextCol;
          if(i%2 == 0){
            nextRow = i + moveEven[n][0];
            nextCol = j + moveEven[n][1];
          }else{
            nextRow = i + moveOdd[n][0];
            nextCol = j + moveOdd[n][1];
          }
          if(isOut[nextRow][nextCol]) answer++;
        }
      }
    }
    System.out.println(answer);
  }
}
