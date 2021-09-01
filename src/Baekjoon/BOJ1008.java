//package Baekjoon;
//
//import java.util.*;
//import java.io.*;
//
//public class BOJ1008 {
//  public static void main(String[] args) throws IOException{
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    double a = Integer.parseInt(st.nextToken());
//    double b = Integer.parseInt(st.nextToken());
//    System.out.println(a/b);
//  }
//}

package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1008 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int max = 0;
    for(int i = 0; i < 2; i++){
      String input = st.nextToken();
      String temp = "";
      for(int j = 2; j >= 0; j--){
        temp += String.valueOf(input.charAt(j));
      }
      max = Math.max(max, Integer.parseInt(temp));
    }
    System.out.println(max);
  }
}