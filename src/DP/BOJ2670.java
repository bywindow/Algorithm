package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] dp = new double[n+1];
        dp[0] = 1.0;
        double answer = 0.0;
        for(int i = 1; i < n+1; i++){
            double input = Double.parseDouble(br.readLine());
            dp[i] = Math.max(dp[i-1] * input, input);
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(String.format("%.3f",answer));
    }
}
