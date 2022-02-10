package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2805 {

  //변수들 모두 int 범위
  static int n;
  static int m;
  static long[] trees;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    trees = new long[n];
    long maxH = 0;//나무 높이
    st = new StringTokenizer(br.readLine());
    for(int i = 0;i < n; i++){
      trees[i] = Integer.parseInt(st.nextToken());
      maxH = Math.max(trees[i], maxH);//최대 나무 높이
    }
    // 구하려는 절단된 나무들의 길이가 가장 높은 나무의 높이보다 클 수도 있다.
    // 절단기 높이 유효 범위
    long start = 1;
    long end = maxH;
    long answer = 0;
    while(start <= end){
      long mid = (start + end) / 2;//현재 절단기 높이
      long result = 0;
      for(int i = 0; i < n; i++){
        if(trees[i] > mid) result += (trees[i] - mid);
      }
      if(result >= m){
        start = mid+1;
        answer = Math.max(answer, mid);
      }
      else{
        end = mid-1;
      }
    }
    System.out.println(answer);
  }
}
