package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2606 {

    static int v;
    static int answer = 0;
    static int[][] edge;
    static int[] visited;

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 1; i < v+1; i++){
                if(visited[i]==0 && edge[cur][i]==1){
                    q.offer(i);
                    visited[i] = 1;
                    answer+=1;//큐에 새로운 것이 추가될 때마다 +1을 해준다
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());//컴퓨터 개수
        int e = Integer.parseInt(br.readLine());//간선 개수
        visited = new int[v+1];//방문여부 기록
        //간선이 연결된 정보
        edge = new int[v+1][v+1];
        for(int i = 0; i < e; i++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edge[x][y] = edge[y][x] = 1;
        }
        bfs(1);
        System.out.println(answer);
    }
}
