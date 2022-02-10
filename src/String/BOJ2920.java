package String;

import java.util.*;
import java.io.*;

public class BOJ2920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int start = Integer.parseInt(st.nextToken());
        for(int i = 1; i < 8; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(start < cur){
                cnt++;
            }
            else{
                cnt--;
            }
            start = cur;
        }
        System.out.println(cnt == 7 ? "ascending" : cnt == -7 ? "descending" : "mixed");
    }
}