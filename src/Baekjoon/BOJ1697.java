package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1697 {

    static int n; //수빈
    static int k; //동생
    static int[] day = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int answer = 0;

    //하나의 노드에서 다음으로 갈 수 있는 방법은 3가지가 있다.
    //다음 노드로 넘어갈 때 1초가 추가된다
    //값에 k가 있을 경우 반복을 멈춘다
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = true;
        boolean end = false; //k를 찾았을 때
        while(!end){
            int step = q.poll();
            int[] arr_step = {step-1, step+1, step*2};
            for(int i = 0; i < arr_step.length; i++){
                int nStep = arr_step[i];
                if(nStep >= 0 && nStep < 100001){
                    if(!visited[nStep]){
                        day[nStep] = day[step] + 1;
                        visited[nStep] = true;
                        q.offer(nStep);
                    }
                    if(nStep == k){
                        answer = day[nStep];
                        end = true;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(answer);

    }
}
