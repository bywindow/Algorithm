package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ5430 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int t = Integer.parseInt(br.readLine());
    for(int i = 0; i < t; i++){
      String p = br.readLine();
      int len = p.length();
      int n = Integer.parseInt(br.readLine());
      boolean isError = false;
      List<String> list = new ArrayList<>();
      String arr = br.readLine();
      st = new StringTokenizer(arr.substring(1, arr.length()-1), ",");
      for(int j = 0; j < n; j++){
        list.add(st.nextToken());
      }
      int point = 0;
      for(int j = 0; j < len; j++){
        char cur = p.charAt(j);
        // 배열을 뒤집기 - 뒤집는 것과 같은 효과
        if(cur == 'R'){
          point = point == 0 ? list.size()-1 : 0;
        }
        // 배열 앞의 수 버리기
        else{
          // 배열 길이가 0일 경우 예외처리
          if(list.size() == 0){
            isError = true;
            break;
          }
          list.remove(point);
          point = Math.max(point-1, 0); // 0 이하로 갈 수 있다
        }
      }
      if(point == list.size()-1) Collections.reverse(list);
      String answer = String.join(",", list);
      bw.write(isError ? "error" + "\n" : "[" + answer + "]\n");
    }
    bw.flush();
    bw.close();
  }
}
