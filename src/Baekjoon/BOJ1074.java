package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {

  static int n;
  static int r;
  static int c;
  static long[][] map;
  static long cnt;

  static void recur(int n, int r, int c){

    if(n == 0){
      map[r][c] = cnt;
      cnt++;
      return;
    }

    else{
      recur(n-1, r/2, c/2);
      recur(n-1, r/2, c); //r,c : 배열의 길이
      recur(n-1, r, c/2);
      recur(n-1, r, c);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    cnt = 0;
    int len = (int) Math.pow(2, n);
    map = new long[len][len];
    recur(n, len, len);
    System.out.println((int) map[r][c]);
  }
}
