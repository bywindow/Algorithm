package BFS;

import java.util.*;
import java.io.*;
public class BOJ7562 {

    static int t;
    //나이트가 이동할 수 있는 방향
    static int[] moveY = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] moveX = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int[][] visited = new int[l][l]; //각 칸에 최소 몇 번으로 도달했는지 기록한다
            st= new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            st= new StringTokenizer(br.readLine());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            Queue<int[]> q= new LinkedList<>();
            q.add(new int[] {startY, startX});

            while(!q.isEmpty()){
                int[] curPnt = q.poll();
                int curY = curPnt[0];
                int curX = curPnt[1];
                if(curX == endX && curY == endY) {
                    System.out.println(visited[curY][curX]);
                    break;
                }
                for(int j = 0; j < 8; j++){
                    int nextY = curY + moveY[j];
                    int nextX = curX + moveX[j];
                    //이전 칸의 수에서 1씩 더해준다
                    //범위 검사
                    if(nextX < 0 || nextX >= l || nextY < 0 || nextY >= l) continue;
                    if(visited[nextY][nextX] != 0) continue;
                    q.add(new int[] {nextY, nextX});
                    visited[nextY][nextX] = visited[curY][curX] + 1;
                }
            }
        }
    }
}
