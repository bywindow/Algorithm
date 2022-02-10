package DFS;

import java.io.*;
import java.util.*;

public class BOJ2468 {

    static int[][] graph;//높이 정보가 저장된 배열
    static int highest = 0;//가장 높은 높이
    static int lowest = 100;//가장 낮은 높이
    static boolean[][] visited;
    static int cnt = 0;

    static void dfs(int curH, int r, int c){
        if(visited[r][c]) return;

        else if(graph[r][c] > curH){
            visited[r][c] = true;
            if(r+1 < graph.length) dfs(curH, r+1,  c); //move down
            if(c+1 < graph[r].length) dfs(curH, r, c+1); //move right
            if(r-1 >= 0) dfs(curH, r-1, c); //move up
            if(c-1 >= 0) dfs(curH, r, c-1); //move left
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());// 배열의 크기 n X n
        int answer= 0;
        graph = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                highest = Math.max(highest, graph[i][j]);
                lowest = Math.min(lowest, graph[i][j]);
            }
        }
        int curH = lowest;
        while(curH <= highest) {
            visited = new boolean[n][n];
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    if (!visited[i][j] && graph[i][j] > curH) {
                        dfs(curH, i, j);
                        cnt++; //dfs를 돌고 나오면 하나의 영역이 생긴 것이다
                    }
                }
            }
            answer = Math.max(answer, cnt);
            curH++;
            cnt = 0;
        }
        System.out.println(answer);
    }
}
