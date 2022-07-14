package Solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16234 {

    static int n, r, l;
    static int[][] a;
    static boolean[][] visited;
    static int[] moveY = {-1, 0, 1, 0};
    static int[] moveX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        a = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = -1;
        boolean isEnd = false;
        Queue<int[]> q;
        ArrayList<int[]> changePeople;
        while(!isEnd){
            // 더이상 인구를 변경하지 못할 때까지 반복
            isEnd = true;
            visited = new boolean[n][n];
            // 한칸씩 이동하며 영역 찾기
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(visited[i][j]) continue;
                    q = new LinkedList<>();
                    changePeople = new ArrayList<>(); // 인구 이동할 국경 저장
                    q.offer(new int[] {i, j});
                    changePeople.add(new int[] {i, j});
                    visited[i][j] = true;
                    int sum = a[i][j];
                    while(!q.isEmpty()){
                        int[] curPos = q.poll();
                        int y = curPos[0];
                        int x = curPos[1];
                        for(int k = 0; k < 4; k++){
                            int ny = y + moveY[k];
                            int nx = x + moveX[k];
                            if(0<=ny && ny<n && 0<=nx && nx<n && !visited[ny][nx]){
                                int diff = Math.abs(a[y][x] - a[ny][nx]);
                                if(diff < l || diff > r) continue;
                                q.offer(new int[] {ny, nx});
                                visited[ny][nx] = true;
                                sum += a[ny][nx];
                                changePeople.add(new int[] {ny, nx});
                            }
                        }
                    }
                    if(changePeople.size() > 1){
                        // 열린 국경이 있다는 말이니까 아직 끝나지 않게 한다
                        isEnd = false;
                        int newPeople = sum / changePeople.size();
                        for(int[] cur : changePeople){
                            a[cur[0]][cur[1]] = newPeople;
                        }
                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}
