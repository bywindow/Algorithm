package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1916 {

  /**
   * 방향성이 있고, 가중치가 있다 -> 다익스트라로 풀자
   */

  static int n, m;
  static ArrayList<int[]>[] road;
  static int[] pay; // 해당 정류장으로 가는 최소 비용이 담긴 배열


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    road = new ArrayList[n+1]; // 리스트형을 자료형으로 가지는 배열
    for(int i = 0; i < n+1; i++){
      road[i] = new ArrayList<>(); // 초기화
    }
    pay = new int[n+1];
    Arrays.fill(pay, Integer.MAX_VALUE); // 최댓값을 넣고 시작

    StringTokenizer st;
    for(int i = 0; i < m; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int dist = Integer.parseInt(st.nextToken());
      road[s].add(new int[] {e, dist}); // 배열의 인덱스는 출발점, 각 인덱스에 도착점과 비용 삽입
    }
    st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());

    // dijkstra
    PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1[1], o2[1]))); // 우선순위큐 : 비용이 작은 것부터 탐색
    boolean[] visited = new boolean[n+1]; // 방문여부 검사
    pq.add(new int[] {start, 0}); // add start point
    pay[start] = 0;
    while(!pq.isEmpty()){
      int[] cur = pq.poll();
      // 방문하지 않은 곳에 대해서만 추가
      if(!visited[cur[0]]){
        visited[cur[0]] = true;

        for(int[] i : road[cur[0]]){
          if(pay[i[0]] > pay[cur[0]] + i[1]){
            pay[i[0]] = pay[cur[0]] + i[1];
            pq.add(new int[] {i[0], pay[i[0]]}); // 현재 해당 칸으로 가는 최소 비용으로 삽입한다.
          }
        }
      }
    }
    System.out.println(pay[end]);
  }
}
