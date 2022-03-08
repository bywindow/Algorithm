package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[n+1];
        for(int i = 1; i < n+1; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j <= i; j++){
                cards[i] = Math.max(cards[j]+cards[i-j], cards[i]);
            }
        }
        System.out.println(cards[n]);
    }
}
