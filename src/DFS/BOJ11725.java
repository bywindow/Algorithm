package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11725 {

  // 최대 사이즈인 100001 * 100001 크기의 배열을 만들면 메모리 초과 발생 -> 동적할당으로 바꿔야한다
  static int n;
  static ArrayList<Integer>[] edge; // 노드 연결 정보
  static boolean[] visited; // 방문 체크
  static int[] answers;

  static void dfs(int cur){
    // backtracking
    visited[cur] = true;

    for(int i = 0; i < edge[cur].size(); i++){
      int child = edge[cur].get(i);
      if(!visited[child]){
        answers[child] = cur;
        dfs(child);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    edge = new ArrayList[n+1];
    for(int i = 0; i < edge.length; i++){
      edge[i] = new ArrayList<>();
    }
    visited = new boolean[n+1];
    answers = new int[n+1];

    for(int i = 0; i < n-1; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      edge[a].add(b);
      edge[b].add(a);
    }

    dfs(1);

    StringBuilder sb = new StringBuilder();
    for(int i = 2; i < n+1; i++){
      sb.append(answers[i]).append("\n");
    }
    System.out.println(sb.toString());
  }
}