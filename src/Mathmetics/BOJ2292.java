package Mathmetics;

import java.util.*;
import java.io.*;

public class BOJ2292 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        n -= 1;
        int answer = 1;
        while(n > 0){
            n -= (answer * 6);
            answer++;
        }
        System.out.println(answer);
    }
}
