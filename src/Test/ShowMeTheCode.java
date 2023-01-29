package Test;

import java.util.*;
import java.io.*;

/**
 * 1번문제
 * - 2중 for문 : 시간초과
 */

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] stones = new int[n];
        for(int i = 0; i < n; i++){
            stones[i] = Integer.parseInt(st.nextToken());
        }
        int[] sums1 = new int[n];
        int[] sums2 = new int[n];
        int answer = 1;
        if(stones[0] == 1) sums1[0] = 1;
        else sums2[0] = 1;
        for(int i = 1; i < n; i++){
            if(stones[i] == 1) {
                sums1[i] = sums1[i-1] + 1;
                sums2[i] = Math.max(sums2[i-1] - 1, 0);
            } else {
                sums2[i] = sums2[i-1] +1;
                sums1[i] = Math.max(sums1[i-1] - 1, 0);
            }
            answer = Math.max(Math.max(sums2[i], sums1[i]), answer);
        }
        System.out.println(answer);
    }
}

class Main1{
    static int n, m;
    static int[][] donut;
    static int[][] visited;

    static int[] moveX = new int[]{0, 0, -1, 1};
    static int[] moveY = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        donut = new int[n][m];
        visited = new int[n][m];
        boolean isArea = false;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                donut[i][j] = Integer.parseInt(st.nextToken());
                if(donut[i][j] == 0){
                    visited[i][j] = 1;
                    isArea = true;
                }
            }
        }
        if(!isArea) {
            System.out.println(0);
            return;
        }

        int answer = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(donut[i][j] == 1) continue;
                if(visited[i][j] == 0) {
                    answer++;
                    visited[i][j] = answer;
                }
                for(int k = 0; k < 4; k++){
                    int nx = j + moveX[k] < 0 ? m-1 : j + moveX[k] >= m ? 0 : j + moveX[k];
                    int ny = i + moveY[k] < 0 ? n-1 : i + moveY[k] >= n ? 0 : i + moveY[k];
                    if(donut[ny][nx] == 1) continue;
                    if(visited[ny][nx] != 0) continue;
                    visited[ny][nx] = visited[i][j];
                }
            }
        }
        System.out.println(answer);
    }
}

class Main3{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] w = new int[c+1][c+1];
        for(int i = 1; i < c+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < c+1; j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] a, b;
        if(n < m){
            a = new int[m];
            b = new int[n];
        } else {
            a = new int[n];
            b = new int[m];
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[Math.max(n, m)];
        dp[0] = w[a[0]][b[0]];
        int end = Math.min(n, m);
        int cur = 0;

    }
}

