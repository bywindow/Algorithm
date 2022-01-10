package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {

  static int n;
  static int r;
  static int c;
  static int[][] map;

  static void recur(int cnt, int n){
    if(n == 1){

    }
    else{
      recur(cnt, n-1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    long cnt = 0;
    map = new int[r][c];


  }
}
