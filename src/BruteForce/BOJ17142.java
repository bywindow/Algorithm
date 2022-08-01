package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17142 {

    static int n, m;
    static int[][] board;
    static List<int[]> viruses = new LinkedList<>();
    static int[][] active;
    static int[] moveY = {-1, 1, 0, 0}; //상하좌우
    static int[] moveX = {0, 0, -1, 1};
    static int total = 0;
    static int answer = Integer.MAX_VALUE;

    static void setSpreading(){
        int day = 0;
        Queue<int[]> spreading = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        for(int[] cur : active){
            spreading.add(new int[] {cur[0], cur[1]});
            visited[cur[0]][cur[1]] = true;
        }
        int cnt = 0;
        while(!spreading.isEmpty()) {
            int size = spreading.size();
            for (int i = 0; i < size; i++) {
                int[] cur = spreading.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = cur[0] + moveY[j];
                    int nc = cur[1] + moveX[j];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    if (board[nr][nc] == 1) continue;
                    if (visited[nr][nc]) continue;
                    if (board[nr][nc] == 0) cnt++;
                    spreading.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
            day++;
            if (day > answer) return;
            if (cnt >= total) answer = day;
        }
    }

    static void comb(int start, int cnt){
        if(cnt==m){
            // spread function - bfs
            setSpreading();
            return;
        }
        for(int i = start; i < viruses.size(); i++){
            active[cnt] = viruses.get(i);
            comb(i+1, cnt+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        active = new int[m][2];
        total = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int input = Integer.parseInt(st.nextToken());
                board[i][j] = input;
                if(input == 0) {
                    total++;
                }
                else if(input == 2){
                    viruses.add(new int[]{i,j});
                }
            }
        }
        //빈칸 예외처리
        if(total==0){
            System.out.println(0);
            return;
        }
        comb(0,0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
