package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14891 {

  static int[][] wheels = new int[4][8];
  static int[] point;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 4; i++) {
      String input = br.readLine();
      for (int j = 0; j < 8; j++) {
        wheels[i][j] = input.charAt(j) - '0'; // N - 0, S - 1
      }
    }
    int n = Integer.parseInt(br.readLine());
    point = new int[4]; // 혅재 몇 번째 톱니가 12시 방향인지 체크
    int[][] curPair = new int[4][2];
    int[] isRotate = new int[4]; // -1 : 반시계, 0 : 회전안함, 1 : 시계
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int rot = Integer.parseInt(st.nextToken()) - 1;
      int dir = Integer.parseInt(st.nextToken());
      for (int j = 0; j < 4; j++) {
        // left
        curPair[j][0] = wheels[j][(point[j] + 6) % 8];
        // right
        curPair[j][1] = wheels[j][(point[j] + 2) % 8];
        isRotate[j] = 0; // init
      }
      isRotate[rot] = dir; // 현재 바퀴의 회전방향
      // 회전 여부 판단
      for (int j = 1; j < 4; j++) {
        // right
        int nr = rot + j;
        if (nr < 4 && curPair[nr - 1][1] != curPair[nr][0]) {
          isRotate[nr] = -isRotate[nr - 1]; // 오른쪽에 있는 톱니의 회전 방향
        }
        int nl = rot - j;
        if (nl >= 0 && curPair[nl + 1][0] != curPair[nl][1]) {
          isRotate[nl] = -isRotate[nl + 1];
        }
      }
      for (int j = 0; j < 4; j++) {
        if (isRotate[j] == 0)
          continue;
        if (isRotate[j] == 1) {
          point[j] = (point[j] + 7) % 8;
          continue;
        }
        if (isRotate[j] == -1) {
          point[j] = (point[j] + 1) % 8;
        }
      }
    }
    int answer = 0;
    for (int i = 0; i < 4; i++) {
      answer += wheels[i][point[i]] == 1 ? Math.pow(2, i) : 0;
    }
    System.out.println(answer);
  }
}
