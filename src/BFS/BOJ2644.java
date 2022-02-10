package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2644 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * bfs로 풀자
         */
        int n = Integer.parseInt(st.nextToken()); //사람 수
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); //촌수계산할 사람1
        int end = Integer.parseInt(st.nextToken()); //촌수계산할 사람2
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());//edge 수

        int[] visited = new int[n+1];
        boolean[][] map = new boolean[n+1][n+1];
        Queue<Integer> q= new LinkedList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = true; //연결되어 있는 것 기록
        }
        q.add(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 1; i <= n; i++){
                //촌수관계인지 검사
                //예외 : 방문햇던 곳, 시작점인 곳
                if(visited[i] != 0) continue;
                if(i == start) continue;
                if(map[cur][i]) {
                    q.add(i);
                    visited[i] = visited[cur] + 1;
                }
            }
        }
        System.out.println(visited[end] == 0 ? -1 : visited[end]);
    }
}
