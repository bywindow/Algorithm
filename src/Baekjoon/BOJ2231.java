package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2231 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //분해합

        int answer = 0;
        /*
        생성자를 구해라
        abc -> abc + a + b + c -> def 라고 하면
        우리가 구해야 할 abc == def - (a+b+c)
        abc < def
         */
        for(int i = n; i > 0; i--){
            int sum = 0; //각 자리 수의 합
            for(int j = i; j > 0; j/=10){
                sum += (j % 10);
            }
            if(n == i + sum) answer = i;
        }
        System.out.println(answer);
    }
}
