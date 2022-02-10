package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2178 {

    static int[][] map; //미로
    static boolean[][] visited;
    static int n; //row
    static int m; //col
    static int[] moveX = {1, 0, -1, 0};//우-하-좌-상
    static int[] moveY = {0, 1, 0, -1};//우-하-좌-상

    static void bfs(){
        //bfs니까 큐를 만든다
        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();
        //시작 포인트
        x.offer(0);
        y.offer(0);

        while(!x.isEmpty() && !y.isEmpty()){
            //방문할 곳
            int col = x.poll();
            int row = y.poll();
            visited[row][col] = true;//방문
            for(int i = 0; i < 4; i++){
                //이동할 곳
                int nx = col + moveX[i];
                int ny = row + moveY[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if(map[ny][nx] == 1 && !visited[ny][nx]){
                        x.offer(nx);
                        y.offer(ny);
                        visited[ny][nx] = true;
                        map[ny][nx] = map[row][col] + 1;//한 칸씩 움직일 때마다 수를 더해간다
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String r = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(r.substring(j,j+1));
            }
        }

        bfs();
        System.out.println(map[n-1][m-1]);
    }
}
