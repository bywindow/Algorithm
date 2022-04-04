package Solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import BruteForce.connectIsland;

public class BOJ21610 {
  static int n, m;
  static int[][] water;
  static boolean[][] isCloudy; // 구름이 있는 곳 표시
  static int[][] move = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } }; // 구름
                                                                                                                  // 이동
                                                                                                                  // 방향
                                                                                                                  // 순서
  static int[][] dial = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } }; // 대각선 방향 물 있는지 확인

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    water = new int[n][n];
    isCloudy = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        water[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // 첫번째 구름이 있는 곳
    isCloudy[n - 2][1] = isCloudy[n - 2][2] = isCloudy[n - 1][1] = isCloudy[n - 1][2] = true;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (!isCloudy[j][k])
            continue;
          // 구름이 있으면 d 방향으로 s만큼 이동
          int nr = j + move[d][0] * s;
          int nc = k + move[d][1] * s;
          // 범위값 넘어가는 거 체크
          nr = nr < 0 ? n + nr : nr >= n ? nr - n : nr;
          nc = nc < 0 ? n + nc : nc >= n ? nc - n : nc;
          // 처음 구름 있던 곳 해제
          isCloudy[j][k] = false;
          // 이동한 곳에 구름 있음 표시
          isCloudy[nr][nc] = true;
          // 대각선 방향 물의 양으로 물 계산
          int cnt = 0;
          for (int l = 0; l < 4; l++) {
            int dr = nr + dial[l][0];
            int dc = nc + dial[l][1];
            if (0 > dr || n <= dr || 0 > dc || n <= dc)
              continue;
            if (water[dr][dc] > 0)
              cnt++;
          }
          water[nr][nc] += cnt; // 물 증가
        }
      }
      // 구름이 생기는 곳 체크
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (water[j][k] < 2)
            continue;
          // 구름이 있던 곳이면 구름 해제하고 넘어가기
          if (isCloudy[j][k]) {
            isCloudy[j][k] = false;
            continue;
          }
          water[j][k] -= 2;
          isCloudy[j][k] = true;
        }
      }
    }
    int answer = 0;
    for (int[] i : water) {
      for (int j : i) {
        answer += j;
      }
    }
    System.out.println(answer);
  }
}
