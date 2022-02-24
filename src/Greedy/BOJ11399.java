package Greedy;

import java.util.*;
import java.io.*;

public class BOJ11399 {

    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] p = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }
        //소요시간이 적은 사람이 앞에 있을수록 총 소요시간이 적어진다
        Arrays.sort(p);
        int answer = p[0];
        for(int i = 1; i < p.length; i++){
            p[i] = p[i-1] + p[i];
            answer += p[i];
        }
        System.out.println(answer);
    }
}
