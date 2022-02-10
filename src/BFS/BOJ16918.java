package BFS;

import java.util.*;
import java.io.*;

public class BOJ16918 {

    static int r;//row
    static int c;//column
    static int n;//second
    static int[][] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[] moveX = {0, 0, -1, 1};
        int[] moveY = {-1, 1, 0, 0};

        Queue<int[]> q = new LinkedList<>();//폭탄을 설치할 곳을 담는다

        graph= new int[r][c];
        //처음 0초와 1초의 상태
        for(int i = 0; i < r; i++){
            String input = br.readLine();
            for(int j = 0; j < c; j++){
                char curInput = input.charAt(j);
                if(curInput == 'O'){
                    graph[i][j] = 3; //3초 후에 터진다
                } else {
                    graph[i][j] = 0; //현재 폭탄이 없다
                    q.add(new int[]{i, j});
                }
            }
        }
        int curN = 1;//현재 지난 시간
        while(curN < n){
            curN++;
            //빈 곳에 폭탄 설치
            while(!q.isEmpty()){
                int[] curPoint = q.poll();
                graph[curPoint[0]][curPoint[1]] = curN + 3;
            }
            //폭발
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(graph[i][j] == curN) {
                        graph[i][j] = 0;
                        q.add(new int[] {i,j});
                        for(int k = 0; k < 4; k++){
                            if(i+moveY[k] >= 0 && i+moveY[k] < r && j+moveX[k] >= 0 && j+moveX[k] < c){
                                if(graph[i+moveY[k]][j+moveX[k]] != curN){
                                    graph[i+moveY[k]][j+moveX[k]] = 0;
                                    q.add(new int[] {i+moveY[k], j+moveX[k]});
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(graph[i][j] == 0) System.out.print(".");
                else System.out.print("O");
            }
            System.out.println("");
        }
    }
}
