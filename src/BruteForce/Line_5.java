package BruteForce;

import java.util.Arrays;

public class Line_5 {

  public static long solution(int[] abilities, int k) {
    long answer = 0;
    Arrays.sort(abilities);

    int[] e = new int[abilities.length / 2 + 1];
    int[] m = new int[e.length];
    int curE = 0;
    int curM = 0;
    for (int i = abilities.length - 1; i >= 0; i--) {
      if (i % 2 == 0) {
        e[curE] = abilities[i];
        curE++;
      } else {
        m[curM] = abilities[i];
        curM++;
      }
    }
    long[] dp = new long[k + 1];
    for (int i : m) {
      dp[0] += i;
    }
    for (int i = 1; i < k + 1; i++) {
      int diff = 0;
      int point = 0;
      for (int j = 0; j < e.length; j++) {
        if (diff < e[j] - m[j]) {
          diff = e[j] - m[j];
          point = j;
        }
      }
      int temp = e[point];
      e[point] = m[point];
      m[point] = temp;
      dp[i] = dp[i - 1] + diff;
    }
    answer = dp[k];
    return answer;
  }

  public static void main(String[] args) {
    int[] a = { 7, 6, 8, 9, 10 };
    solution(a, 1);
  }
}
