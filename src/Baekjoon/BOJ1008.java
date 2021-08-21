package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1008 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    double a = Integer.parseInt(st.nextToken());
    double b = Integer.parseInt(st.nextToken());
    System.out.println(a/b);
  }
}
