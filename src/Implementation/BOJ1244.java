package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {

  static int n; // # of switch
  static int[] sw; // switch

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    sw = new int[n+1]; // 스위치 번호를 인덱스로
    for(int i = 1; i <= n; i++){
      sw[i] = Integer.parseInt(st.nextToken());
    }
    int student = Integer.parseInt(br.readLine());
    for(int i = 0; i < student; i++){
      st = new StringTokenizer(br.readLine());
      int gender = Integer.parseInt(st.nextToken());
      int target = Integer.parseInt(st.nextToken());
      // boy
      if(gender == 1){
        // target의 배수에 해당하는 스위치의 상태를 변경
        for(int j = target; j < n+1; j+=target){
          sw[j] = sw[j] == 0 ? 1 : 0;
        }
      }
      // girl
      else {
        // target에 대해 최대 몇 번까지 대칭인지 판단하고 상태 변경
        for(int j = 0; target - j > 0 && target + j <= n; j++){
          if(sw[target+j] == sw[target-j]){
            // 대칭이라면 바로 변경
            sw[target+j] = sw[target+j] == 0 ? 1 : 0;
            sw[target-j] = sw[target-j] == 0 ? 1 : 0;
          }
          else break;
        }
        sw[target] = sw[target] == 0 ? 1 : 0;
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 1; i < n+1; i++){
      sb.append(sw[i]).append(" ");
      if(i % 20 == 0) sb.append("\n");
    }
    System.out.println(sb.toString());
  }
}
