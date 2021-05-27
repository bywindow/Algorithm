package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ14496 {

    static int start;
    static int end;
    static int answer = 1001;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i = 0; i < list.length; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++) {
            st= new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            list[prev].add(next);
            list[next].add(prev);
        }
        /**
         * 우선순위큐
         * int형 배열로 문자와 변환 횟수를 쌍으로 가진다
         * 변환 횟수를 기준으로 정렬
         */
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        boolean[] visited = new boolean[n+1];
        pq.add(new int[] {start, 0});//시작하는 문자 삽입
        visited[start] = true;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();//[0]은 현재 문자, [1]은 변환 횟수
            //end와 같은 수가 발견되면 답 비교
            if(cur[0] == end){
                if(cur[1] < answer) answer = cur[1];
                continue;
            }
            for(int i = 0; i < list[cur[0]].size(); i++){
                int nextChar = list[cur[0]].get(i);
                if(!visited[nextChar]){
                    pq.add(new int[] {nextChar, cur[1] + 1});
                    visited[nextChar] = true;
                }

            }
        }
        if(answer == 1001) System.out.println(-1);
        else System.out.println(answer);
    }
}
