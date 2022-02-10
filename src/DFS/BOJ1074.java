package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1074 {

  /**
   * 목표좌표가 있는 곳의 숫자만 확인한다. 모든 칸을 방문하면 시간초과 남
   */

  static int n;
  static int r;
  static int c;
  static long cnt, answer;

  static void recur(int n, int curR, int curC){
    // (0,0)에서 시작
    // 해당 칸에 도착하면
    if(r == curR && c == curC){
      answer = cnt;
      return;
    }
    // (r,c)가 범위 안에 있으면 재귀
    if(curR <= r && r < curR+n && curC <= c && c < curC+n){
      int curN = n/2;
      recur(curN, curR, curC);
      recur(curN, curR, curC+curN);
      recur(curN, curR+curN, curC);
      recur(curN, curR+curN, curC+curN);
    }
    else{
      // 정사각형 범위 안에 (r,c)가 없다면
      cnt += n * n;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    cnt = answer = 0;
    int len = (int) Math.pow(2, n);

    recur(len, 0, 0);
    System.out.println(answer);
  }
}
