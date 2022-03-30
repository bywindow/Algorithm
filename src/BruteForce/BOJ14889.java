package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
  /**
   * 백트래킹과 브루트포스로 반을 나눈다
   */

  static int[][] stat;
  static boolean[] isStart;
  static int n;
  static int answer = Integer.MAX_VALUE;

  static void solution(int s, int cnt){
    if(cnt == n/2){
      int start = 0;
      int link = 0;
      for(int i = 0; i < n; i++){
        if(isStart[i]){
          for(int j = 0; j < n; j++){
            if(isStart[j]) start += stat[i][j];
          }
        } else {
          for(int j = 0; j < n; j++){
            if(!isStart[j]) link += stat[i][j];
          }
        }
      }
      answer = Math.min(Math.abs(start - link), answer);
      return;
    }
    for(int i = s; i < n; i++){
      isStart[s] = true;
      solution(i+1, cnt+1);
      isStart[s] = false;
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    stat = new int[n][n];
    StringTokenizer st;
    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++){
        stat[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    isStart = new boolean[n];
    solution(0, 0);
    System.out.println(answer);
  }
}
