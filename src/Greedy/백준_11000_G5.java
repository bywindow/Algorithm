package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] times = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(times, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        // 위와 같이 정렬한다고해서 먼저 시작한 강의가 먼저 끝나리라는 보장이 없다
        // 예를들면, [2,8] [3,5] 와 같은 경우
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        ends.add(times[0][1]);

        for(int i = 1; i < n; i++){
            if(times[i][0] >= ends.peek()) {
                ends.poll();
            }
            ends.offer(times[i][1]);
        }
        System.out.println(ends.size());
    }
}