package DFS;

import java.util.*;
import java.io.*;

public class BOJ14502 {

    static int n, m;
    static int[][] graph;

    static int result = 0;//처음 빈방의 개수
    static int answer = 0;//최종 답

    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};

    static Queue<int[]> isVirus = new LinkedList<>();
    static boolean[][] visited;

    static int spreading(){
        Queue<int[]> q = new LinkedList<>(isVirus); //바이러스가 있는 곳으로 초기화
        int newVirus = 0;
        boolean[][] curVisited = new boolean[n][m]; //현재 방문 여부를 복사해서 사용
        for(int i = 0; i < n; i++){
            System.arraycopy(visited[i], 0, curVisited[i], 0, visited[i].length);
        }
        while(!q.isEmpty()){
            int[] curVirus = q.poll();
            int curRow = curVirus[0];
            int curCol = curVirus[1];
            for(int i = 0; i < 4; i++){
                int nextRow = curRow + moveY[i];
                int nextCol = curCol + moveX[i];
                if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) continue;
                if(curVisited[nextRow][nextCol]) continue;
                //그래프 범위이고, 방문하지 않았다(값이 0이다) -> 바이러스 전파
                q.add(new int[] {nextRow, nextCol});
                curVisited[nextRow][nextCol] = true;
                newVirus++;
            }
        }
        return newVirus;
    }

    static void dfs(int cnt){
        if(cnt == 3){
            int safeArea = result - spreading() - 3;
            if(answer < safeArea) answer = safeArea;
            return;
        }
        else{
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(!visited[i][j]){
                        visited[i][j] = true;
                        dfs(cnt+1);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());//row
        m = Integer.parseInt(st.nextToken());//col
        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                graph[i][j] = value;
                if(value == 0) result++;// 빈방의 개수를 미리 기록해둔다
                else {
                    if(value == 2){
                        isVirus.add(new int[] {i, j}); //초기에 바이러스가 존재하는 곳 기록
                    }
                    visited[i][j] = true;//벽 또는 바이러스가 있는 곳
                }
            }
        }
        dfs(0);
        System.out.println(answer);
    }
}
