package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /**
         * 가장 긴 증가하는 부분 수열의 길이를 찾는다
         * 뒤로 갈수록 커져야한다: 현재 인덱스의 수는 이전 인덱스의 수와 비교
         * dp 배열을 만들고
         * 수열 배열을 돌면서 현재의 수가 수열들 중 몇 번째로 큰 수인지 기록한다
         * dp[0] = 1 , 자기자신을 포함해서 카운팅한다
         * dp[1]부터 시작해서 arr[1]이 arr[0]보다 작으면 dp[1]=1, 크면 dp[1]=dp[0]+1
         * 만약 arr[m]이 arr[0]~arr[m-1] 중에서 가장 크다면 dp[m]은 max(dp[0]~dp[m-1])
         */

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n]; //몇 번째로 작은지 저장하는 dp
        dp[0] = 1;
        int answer = 1;

        for(int i = 1; i < n; i++){
            dp[i] = 1; //dp 초기화
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    //update dp[i]
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            if(answer < dp[i]) answer = dp[i];
        }
        System.out.println(answer);
    }
}
