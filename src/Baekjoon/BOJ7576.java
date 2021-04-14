package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ7576 {

    static int m; //col
    static int n; //row
    static int[][] map; //tomato box
    static Queue<Integer> x = new LinkedList<>();// x coordinate
    static Queue<Integer> y = new LinkedList<>();// y coordinate
    static int[] moveX = {1, 0, -1, 0}; //우하좌상
    static int[] moveY = {0, 1, 0, -1}; //우하좌상
    static boolean[][] visited;
    static int answer = 0;

    static void bfs(){
        //1인 곳의 좌표를 꺼내서 그 인접한 곳이 0이라면 그 곳의 값을 날짜로 바꾸고 방문표시한다
        while(!x.isEmpty() && !y.isEmpty()){
            int curX = x.poll();
            int curY = y.poll();
            visited[curY][curX] = true;
            //다음 포인터로 이동
            for(int i = 0; i < 4; i++){
                int nx = curX+moveX[i];
                int ny = curY+moveY[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if(map[ny][nx] == 0 && !visited[ny][nx]){
                        map[ny][nx] = map[curY][curX] + 1;
                        answer = map[ny][nx] -1;
                        x.offer(nx);
                        y.offer(ny);
                    }
                }
            }
        }

        //다 익었는지 검사
        if(check()) answer = -1;
    }

    static boolean check(){
        for(int i[] : map){
            for(int j : i){
                if( j == 0) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                //시작점을 큐에 저장
                if(map[i][j] == 1){
                    x.offer(j);
                    y.offer(i);
                }
            }
        }

        bfs();
        System.out.println(answer);

    }

}
