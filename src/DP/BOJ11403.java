package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ11403 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * 방향이 있는, 가중치가 없는 그래프
         * 플로이드-와샬 알고리즘
         */

        int n = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int input = Integer.parseInt(st.nextToken());
                graph[i][j] = input; //간선이 존재한다 == i -> j로 갈 수 있다 == 출력에서도 1인 곳은 1 출력
            }
        }
        //dp의 방식으로 한 정점을 거쳐서 갈 수 있는 곳을 1로 바꿔준다

        //start -> middle -> end
        for(int middle = 0; middle < n; middle++){
            for(int start = 0; start < n; start++){
                for(int end = 0; end < n; end++){
                    if (graph[start][middle] == 1 && graph[middle][end] == 1) graph[start][end] = 1;
                }
            }
        }

        for(int[] i: graph){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }
}
