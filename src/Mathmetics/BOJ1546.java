package Mathmetics;

import java.util.*;
import java.io.*;

public class BOJ1546 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] scores = new double[n];
        double max = 0;
        double answer = 0;
        for(int i = 0; i < n; i++){
            scores[i] = Double.valueOf(st.nextToken());
            max = Math.max(max, scores[i]);
        }
        for(int i = 0; i < n; i++){
            scores[i] *= ((100 / max) / n);
            answer += scores[i];
        }
        System.out.println(answer);
    }
}
