package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2798 {

    static int n; //number of card
    static int m; //upper limit
    static int[] card;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        card = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < card.length; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int answer = 0;
        Arrays.sort(card);

        for(int i = 0; i < card.length-2; i++){
            for(int j = i+1; j < card.length-1; j++){
                for(int k = j+1; k < card.length; k++){
                    sum = card[i] + card[j] + card[k];
                    if(sum > m) {
                        break;
                    }
                    else if(sum <= m && sum > answer){
                        answer = sum;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
