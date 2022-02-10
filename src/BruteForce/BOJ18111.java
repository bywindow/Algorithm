package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111 {

    /*
    인벤토리에 가지고 있는 블록과 맵에 있는 블록의 합계를 구해서
    맵 격자 수만큼 나눠서 쌓는다
    높이를 1씩 줄여가면서 해당 높이에서 소요되는 시간을 구한다
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        long total = b;
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }
        int height = (int) (total / (n*m)); //격자 하나당 가질 수 있는 최대 높이
        if (height > 256) height = 256;
        int time = Integer.MAX_VALUE;
        int answerHeight = height;
        while(height >= 0){
            int curTime = 0;
            //현재 높이에서의 시간 구하기
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] <= height) curTime += (height - map[i][j]);
                    else curTime += ( 2 * (map[i][j] - height));
                }
            }
            if(curTime < time){
                time = curTime;
                answerHeight = height;
            }
            height--;
        }
        System.out.println(time + " " + answerHeight);
    }
}
