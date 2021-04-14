package Test;

import java.util.*;
import java.io.*;

public class Test1 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < n * n; i++){
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            for(int k = 0; k < time; k++){
                int each = Integer.parseInt(st.nextToken());
                if(!hm.containsKey(each)) hm.put(each, score);
                else if(hm.get(each) < score) hm.put(each, score);
            }
        }
        int answer = 0;
        for(int i = 0; i < hm.size()+1; i++){
            if(hm.containsKey(i)){
                answer += hm.get(i);
            }
        }
        System.out.println(answer);
    }
}
