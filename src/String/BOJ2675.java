package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2675 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for(int i = 0; i < t; i++){
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      String input = st.nextToken();
      String answer = "";
      for(int j = 0; j < input.length(); j++){
        char cur = input.charAt(j);
        for(int k = 0; k < r; k++){
          if(cur == '\n') answer += cur;
          answer += cur;
        }
      }
      System.out.println(answer);
    }
  }
}
