package Mathmetics;

import java.util.*;
import java.io.*;

public class BOJ11720 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int answer = 0;
        for(int i = 0; i < n; i++){
            int cur = Integer.parseInt(input.substring(i,i+1));
            answer += cur;
        }
        System.out.println(answer);
    }
}
