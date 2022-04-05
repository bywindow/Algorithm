package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21610 {
  static int n, m;
  static int[][] water;
  static boolean[][] isCloudy; // 구름이 있는 곳 표시
  static int[][] move = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } }; // 구름
  static int[][] dial = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } }; // 대각선 방향 물 있는지 확인
  static Queue<int[]> q;

  // 구름의 이동과 빗물 계산을 같이 하면 계산결과가 달라진다.
  // 한칸씩 구름의 이동을 구현하면 isCluody를 체크하고 해제하는 과정에서 오류가 발생할 수 있다.
  // 1. 헌재 구름이 있는 좌표에서 구름이 이동한 좌표를 큐에 넣는다. isCloudy는 false로
  // 2. 모든 구름의 이동이 완료되면 물을 뿌리고, isCloudy를 true로 바꾼다
  // 3. 물복사버그
  // 4. 현재 isCloudy에서 false인 부분 중 물의 양이 2이상인 곳을 true로, 이미 true인 곳은 false로 바꾼다

  public static void main(String[] args) throws IOException {
    // System.out.println((-5) % 5);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    water = new int[n + 1][n + 1];
    isCloudy = new boolean[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        water[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    q = new LinkedList<>();
    isCloudy[n - 1][1] = isCloudy[n - 1][2] = isCloudy[n][1] = isCloudy[n][2] = true;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken()) - 1;
      int s = Integer.parseInt(st.nextToken());
      // 현재 구름에서 이동한 후의 좌표를 큐에 넣는다
      for (int j = 1; j < n + 1; j++) {
        for (int k = 1; k < n + 1; k++) {
          if (!isCloudy[j][k])
            continue;
          int nr = fixRange(j + move[d][0] * s);
          int nc = fixRange(k + move[d][1] * s);
          q.add(new int[] { nr, nc });
          isCloudy[j][k] = false;
        }
      }
      // 비 내리고 다음에 구름 안 생기도록 체크
      while (!q.isEmpty()) {
        int[] cur = q.poll();
        water[cur[0]][cur[1]]++;
        isCloudy[cur[0]][cur[1]] = true;
      }
      // 물복사버그
      for (int j = 1; j < n + 1; j++) {
        for (int k = 1; k < n + 1; k++) {
          if (!isCloudy[j][k])
            continue;
          int cnt = 0;
          for (int l = 0; l < 4; l++) {
            int dr = j + dial[l][0];
            int dc = k + dial[l][1];
            if (dr < 1 || dr > n || dc < 1 || dc > n)
              continue;
            if (water[dr][dc] > 0)
              cnt++;
          }
          water[j][k] += cnt;
        }
      }
      for (int j = 1; j < n + 1; j++) {
        for (int k = 1; k < n + 1; k++) {
          if (isCloudy[j][k]) {
            isCloudy[j][k] = false;
          } else {
            if (water[j][k] >= 2) {
              isCloudy[j][k] = true;
              water[j][k] -= 2;
            }
          }
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

  static int fixRange(int p) {
    if (p % n == 0)
      return n;
    else if (p < 0)
      return p % n + n;
    else if (p > n)
      return p % n;
    else
      return p;
  }
}
