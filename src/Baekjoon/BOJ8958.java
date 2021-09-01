package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ8958 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            int cnt = 0;
            int answer = 0;
            String cur = br.readLine();
            for(int j = 0; j < cur.length(); j++){
                if(cur.charAt(j) == 'O'){
                    ++cnt;
                    answer += cnt;
                } else {
                    cnt = 0;
                }
            }
            System.out.println(answer);
        }
    }
}
