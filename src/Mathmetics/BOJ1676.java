package Mathmetics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1676 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cntTow = 0;

        for(int i = 2; i < n+1; i*=2){
            for(int j = i; j < n+1; j+=i){
                cntTow++;
            }
        }

        int cntFive = 0;

        for(int i = 5; i < n+1; i*=5){
            for(int j = i; j < n+1; j+=i){
                cntFive++;
            }
        }

        System.out.println(Math.min(cntTow, cntFive));
    }
}
