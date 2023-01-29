package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] cranes = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cranes);
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> pq = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int cur = Integer.parseInt(st.nextToken());
            pq.add(cur);
        }
        pq.sort(Collections.reverseOrder());
        if (pq.get(0) > cranes[n-1]) {
            System.out.println(-1);
            System.exit(0);
        }
        int answer = 0;
        while(pq.size() > 0){
            answer++;
            int curCrane = n-1, curBox = 0;
            while(curCrane >= 0){
                if(curBox == pq.size()) break;
                // can load
                if(pq.get(curBox) <= cranes[curCrane]){
                    pq.remove(curBox);
                    curCrane--;
                } else {
                    curBox++;
                }
            }
        }
        System.out.println(answer);
    }
}