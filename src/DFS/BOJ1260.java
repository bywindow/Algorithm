package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ1260 {

    static int[][] graph;
    static int[] visited;

    static void dfs(int cur, int num){
        visited[cur] = 1;
        System.out.print(cur + " ");
        //입력값을 그대로 사용하기 위해 1부터 시작
        for(int i = 1; i < num+1; i++){
            if(graph[cur][i] == 1 && visited[i] == 0){
                dfs(i, num);
            }
        }
    }

    static void bfs(int start, int num){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;
        System.out.print(start + " ");
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 1; i < num+1; i++){
                if(graph[cur][i] == 1 && visited[i] == 0){
                    visited[i] = 1;
                    q.offer(i);
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        int vert = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new int[vert+1][vert+1];//좌표를 그대로 인수로 쓰기위해 +1
        //간선 연결 상태 기록
        for(int i = 0; i < edge; i++){
            String edge_list = br.readLine();
            StringTokenizer st2 = new StringTokenizer(edge_list, " ");
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }
        visited = new int[vert+1];

        dfs(start, vert);
        System.out.println("");
        Arrays.fill(visited, 0);//초기화
        bfs(start, vert);
    }
}
