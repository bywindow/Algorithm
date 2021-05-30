package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ14502 {

    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int answer = 0;

    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};

    static Queue<int[][]>

    static void spreading(){

    }

    static void dfs(int cnt){
        if(cnt == 3){

        }
        else{

        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());//row
        m = Integer.parseInt(st.nextToken());//col
        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                graph[i][j] = value;
                if(value == 0) answer++;// 빈방의 개수를 미리 기록해둔다
                else {
                    if(value == 2){

                    }
                    visited[i][j] = true;//벽이 있는 곳
                }
            }
        }
    }
}
