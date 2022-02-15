package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16953 {

  static long a, b;
  static int answer = 1000000000;

  static void dfs(long init, long target, int cnt){
    if(init == target){
      answer = Math.min(answer, cnt+1);
      return;
    }
    if(init > target) return;

    dfs(init * 2, target, cnt+1);
    dfs(init * 10 + 1, target, cnt+1);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Long.parseLong(st.nextToken());
    b = Long.parseLong(st.nextToken());

    dfs(a, b, 0);
    System.out.println(answer == 1000000000 ? -1 : answer);
  }
}
