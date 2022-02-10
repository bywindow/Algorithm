package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107 {
  /**
   * 고장난 숫자키를 제외하고 정상적인 숫자키로 목표 숫자와 가장 가까운 수를 만든다
   * 몇 자리 수인지 확인 -> 버튼 누르는 횟수 카운트
   * +나 - 버튼을 몇 번 누르는지 확인 -> 카운트
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String n = br.readLine();
    int nNum = Integer.parseInt(n);
    int m = Integer.parseInt(br.readLine());
    String[] error = new String[m];
    // m이 0일 때는 예외처리
    if(m > 0){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i = 0; i < m; i++){
        error[i] = st.nextToken();
      }
    }
    else{
      System.out.println(Math.min(n.length(), Math.abs(nNum-100)));
      return;
    }

    int plus, minus;
    int cnt = 0;
    boolean numPadPlus = false;
    boolean numPadMinus = false;
    int answer = 0;
    // 반복을 멈춰야할 때 : +, -로 n이 만들어졌을 때, +,-로 만들 수 있는 수를 찾았을 때
    while(true){
      // 목표 숫자에서 + or - 를 누른 횟수를 더하거나 뺀 수
      plus = nNum + cnt;
      minus = Math.max(nNum - cnt, 0);
      // 현재 수를 숫자 패드로 만들 수 있는지 체크
      for(int i = 0; i < m; i++){
        if(Integer.toString(plus).contains(error[i])){
            numPadPlus = false;
            break;
        }
        else{
          numPadPlus = true;
        }
      }
      // minus 숫자 체크
      for(int i = 0; i < m; i++){
        if(Integer.toString(minus).contains(error[i])){
          numPadMinus = false;
          break;
        }
        else{
          numPadMinus = true;
        }
      }
      // 숫자 패드로의 이동이 빠른지 +-버튼으로의 이동이 빠른지 체크
      int pl = 500000;
      int mi = 500000;
      if(numPadPlus || numPadMinus){
        if(numPadPlus){
          pl = Math.min(Integer.toString(plus).length() + cnt , Math.abs(nNum-100));
        }
        if(numPadMinus){
          mi = Math.min(Integer.toString(minus).length() + cnt,  Math.abs(nNum-100));
        }
        answer = Math.min(pl, mi);
        break;
      }
      if(plus == 100 || minus == 100){
        answer = cnt;
        break;
      }
      cnt++;
    }
    System.out.println(answer);
  }
}
