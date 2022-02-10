package Dijkstra;

import java.util.*;
import java.io.*;

public class BOJ18352 {

    static int n, m, k, x;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //도시의 개수
        m = Integer.parseInt(st.nextToken()); //도로의 개수
        k = Integer.parseInt(st.nextToken()); //거리 정보
        x = Integer.parseInt(st.nextToken()); //출발 도시

        /**
         * 다익스트라 - 우선순위큐를 이용하여 풀기
         */
        // 각 도시마다 단방향으로 연결되어 있는 도시를 리스트로 정의
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        //도로의 개수만큼 입력받기
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            graph[prev].add(next);
        }
        boolean[] visited = new boolean[n+1];//방문 체크를 위한 배열
        //배열로 "도시","거리"를 가지는 우선순위큐-최소 거리를 찾아내야함
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        //출발하는 도시 추가
        pq.add(new int[] {x, 0});
        visited[x] = true;
        //정답을 저장하는 우선순위큐-오름차순 출력을 위함
        PriorityQueue<Integer> result = new PriorityQueue<>();
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curCity = cur[0];
            int curCost = cur[1];
            //거리가 k와 같다면 답으로 저장하고 다음으로 넘어감
            if(curCost == k){
                result.add(curCity);
                continue;
            }
            //현재 도시와 연결되어 있는 도시를 큐에 추가
            for(int i = 0; i < graph[curCity].size(); i++) {
                int nextCity = graph[curCity].get(i);
                if(!visited[nextCity]){
                    pq.add(new int[] {nextCity, curCost+1});
                    visited[nextCity] = true;
                }

            }
        }
        if(result.size() == 0) System.out.println(-1);
        else {
            while (!result.isEmpty()) {
                System.out.println(result.poll());
            }
        }
    }
}
