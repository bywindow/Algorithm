package Greedy;

import java.util.*;
import java.io.*;

public class BOJ1931 {

    static int n; //회의 수
    static int[][] time; //각 회의 시간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        time = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        //회의가 끝나는 시간을 기준으로 정렬 : 2차원배열 정렬하는 방법
        Arrays.sort(time, (o1, o2) -> {
            //끝나는 시간이 같을 경우, 시작시간을 기준으로 정렬
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            else
                return o1[1] - o2[1];
        });

        //현재 회의의 종료시간을 위한 변수
        int cur_end = 0;
        //현재 회의의 끝나는 시간보다 크거나 같다면 이어지는 회의로 카운트
        for (int i = 0; i < n; i++) {
            if (cur_end <= time[i][0]) {
                answer++;
                cur_end = time[i][1];
            }
        }

        System.out.println(answer);

    }
}
