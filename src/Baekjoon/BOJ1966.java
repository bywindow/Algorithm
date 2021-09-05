package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1966 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());//문서 개수
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ArrayList<int[]> list = new ArrayList<>();
            for(int j = 0; j < n; j++){
                list.add(new int[] {j, Integer.parseInt(st.nextToken())});
            }
            int cnt = 0;
            while(!list.isEmpty()){
                int[] cur = list.get(0);
                boolean moveLast = false;
                for(int j = 1; j < list.size(); j++){
                    if(cur[1] < list.get(j)[1]) {
                        moveLast = true;
                        break;
                    }
                }
                if(moveLast){
                    list.add(cur);
                    list.remove(0);
                }else{
                    if(cur[0] == m){
                        cnt++;
                        System.out.println(cnt);
                        break;
                    }else{
                        list.remove(0);
                        cnt++;
                    }
                }
            }
        }

    }
}
