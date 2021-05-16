package Baekjoon;

import java.util.*;
import java.io.*;

/**
 * 방향그래프가 주어지면 시작점에서 다른 모든 정점으로의 최단거리를 구한다
 * 모든 간선의 가중치 <= 10
 * 간선(u, v, w) = u에서 v로 가는 가중치 w인 간선
 */

//다음 노드와 간선의 가중치를 가지는 노드 클래스 구현
class Node implements Comparable<Node>{
    int next, weight;
    public Node(int next, int weight){
        this.next = next;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class BOJ1753  {

    static boolean[] visited;
    static ArrayList<Node>[] graph;
    static int[] dist;

    static final int MAX = Integer.MAX_VALUE;
    static int v, e;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken()); //정점 개수
        e = Integer.parseInt(st.nextToken()); //간선 개수
        int start = Integer.parseInt(br.readLine());
        //dist 배열 초기화
        dist = new int[v+1];
        Arrays.fill(dist, MAX);
//        dist[start] = 0;
        //정점 별로 리스트 정의
        graph = new ArrayList[v+1];
        for(int i = 1; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        //(u,v,w)
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }
        visited = new boolean[v+1];

        dijkstra(start);

        for(int i = 1; i < dist.length; i++){
            if(dist[i] == MAX) sb.append("INF\n");
            else {
                sb.append(dist[i]);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));//시작점은 자기 자신에 대한 가중치 0으로 두고 삽입
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            //간선이 연결된 다음 노드로 이동하면서 비용이 가장 적은 것을 고른다
            int cur = curNode.next;
            if(!visited[cur]){
                visited[cur] = true;
                //cur에서 다음 노드로 이동
                for(Node node : graph[cur]){
                    if(dist[node.next] > dist[cur] + node.weight){
                        dist[node.next] = dist[cur] + node.weight;
                        pq.add(new Node(node.next, dist[node.next]));
                    }
                }
            }
        }
    }
}
