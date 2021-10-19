package Baekjoon;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));//내림차순
        for(int i = 0; i < n; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            } else {
                pq.add(input);
            }
        }
        System.out.println(sb);

    }
}
