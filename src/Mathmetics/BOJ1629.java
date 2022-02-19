package Mathmetics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {

  static long mod(long a, long b, long c){
    // exponent == 1 : return a mod c
    if(b == 1){
      return a % c;
    }
    // recursion
    long result = mod(a, b/2, c);
    // 모듈러 성질
    // if exponent is odd : one more multiply itself
    if(b % 2 == 1){
      return (result * result % c) * a % c;
    }
    return result * result % c;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long c = Long.parseLong(st.nextToken());
    // 나머지를 제곱하고 c로 나눈 후 그 나머지를 제곱하여 다시 나누기를 반복 (시간초과)
    // 분할정복
    // 모듈로 성질 : (a * b) % c = ((a % c) * (b % c)) % c
    long answer = mod(a, b, c);
    System.out.println(answer);
  }
}
