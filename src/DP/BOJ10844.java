package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ10844 {

    final static long DIVIDER = 1000000000;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /**
         * dp 배열을 만든다
         * dp[i][j] : i번째 자리수 숫자 j를 넣을 수 있는 경우의 수
         */
        long[][] dp = new long[n+1][10];
        //첫번째 자리에는 0을 제외한 모든 j에서 경우의 수가 1
        for(int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }
        for(int i = 2; i < n+1; i++){
            for(int j = 0; j < 10; j++){
                if(j == 0){
                    //0이 있다는 것은 현재 자릿수보다 한 단계 높은 자릿수의 숫자가 1이라는 것
                    dp[i][j] = dp[i-1][1];
                }
                else if(j == 9){
                    //9가 있다는 것은 현재 자릿수보다 한 단계 높은 자릿수의 숫자가 8이라는 것
                    dp[i][j] = dp[i-1][8];
                }
                else{
                    //0,9를 제외한 모든 숫자는 한 단계 높은 자릿수가 자신보다 -1 or +1인 경우를 더한 것
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                }
                //수가 DIVIDER를 넘지 않도록 나누어준다
                dp[i][j] %= DIVIDER;
            }
        }
        //dp의 마지막 인덱스들만 더하면 된다
        long answer = 0;
        for(int i = 0; i < 10; i++){
            answer += dp[n][i];
        }
        System.out.println(answer % DIVIDER);//n이 100일 때 DIVIDER를 넘는다
    }
}
