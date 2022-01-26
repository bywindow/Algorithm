package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11723 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int[] s = new int[21];

    for(int i = 0; i < m; i++){
      st = new StringTokenizer(br.readLine());
      String func = st.nextToken();
      int num = 0;
      if(st.hasMoreTokens()) {
        num = Integer.parseInt(st.nextToken());
      }
      if(func.equals("add") && s[num] == 0){
        s[num] = 1;
        continue;
      }
      if(func.equals("remove") && s[num] == 1){
        s[num] = 0;
        continue;
      }
      if(func.equals("check")){
        sb.append(s[num]).append("\n");
        continue;
      }
      if(func.equals("toggle")){
        s[num] = s[num] == 1 ? 0 : 1;
        continue;
      }
      if(func.equals("all")){
        Arrays.fill(s, 1);
        continue;
      }
      if(func.equals("empty")){
        Arrays.fill(s, 0);
      }
    }
    System.out.println(sb.toString());
  }
}
