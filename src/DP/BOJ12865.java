package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {

    /**
     *  1. dfs로 풀어보자 : time out...
     *  2. dfs를 dp로 바꿔보자
     */

    static int n, k;
    static int[][] comp; // weight, value

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        comp = new int[n+1][2];

        for(int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            comp[i][0] = Integer.parseInt(st.nextToken()); //weight
            comp[i][1] = Integer.parseInt(st.nextToken()); //value
        }

        int[][] dp = new int[n+1][k+1];
        //dp[i][j] : 가방의 제한 무게가 j이고 넣을 수 있는 i번째 보석까지 넣을 수 있을 때의 최대 가치
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < k+1; j++){
                // 가방의 제한 무게가 넣으려는 보석의 무게보다 가벼울 때: i-1번째 보석을 넣은 dp값 사용
                if(j < comp[i][0]) dp[i][j] = dp[i-1][j];
                // i번째 보석을 넣을 수 있는 경우
                // i번째 보석의 무게를 뺐을 때의 value+i번째 보석 value와 dp[i-1][j]를 비교
                else dp[i][j] = Math.max(dp[i-1][j-comp[i][0]] + comp[i][1], dp[i-1][j]);
            }
        }
        System.out.println(dp[n][k]);
    }
}
