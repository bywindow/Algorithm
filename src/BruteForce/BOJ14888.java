package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {

  /**
   * dfs로 개수 체크하면서 하나씩 넣어주는 방법
   */

  static int n;
  static int[] nums;
  static int[] cals;
  static int max, min;

  static void dfs(int nn, int plus, int minus, int mul, int mod, int result){
    // stop point
    if(plus < 0 || minus < 0 || mul < 0 || mod < 0) return;
    if(nn == n-1){
      max = Math.max(max, result);
      min = Math.min(min, result);
      return;
    }
    // recur
    dfs(nn+1, plus-1, minus, mul, mod, result+nums[nn+1]);
    dfs(nn+1, plus, minus-1, mul, mod, result-nums[nn+1]);
    dfs(nn+1, plus, minus, mul-1, mod, result*nums[nn+1]);
    dfs(nn+1, plus, minus, mul, mod-1, result/nums[nn+1]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    nums = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++){
      nums[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    cals = new int[4];
    for(int i = 0; i < 4; i++){
      cals[i] = Integer.parseInt(st.nextToken());
    }
    max = -1000000000;
    min = 1000000000;

    dfs(0, cals[0], cals[1], cals[2], cals[3], nums[0]);
    System.out.println(max + "\n" + min);
  }
}
