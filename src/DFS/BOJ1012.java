package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ1012 {

    static int xLen;
    static int yLen;
    static int n;//배추 개수
    static boolean[][] map;
    static boolean[][] visited;
    static int answer = 0;//지렁이 수
    static int cnt = 0;//인접해있는 배추의 개수

    static void dfs(int curX, int curY){

        if(map[curY][curX] == false) return; // 배추가 있는지 확인
        else if(visited[curY][curX] == true) return; // 방문한 곳인지 확인
        //배추가 있고 방문한 곳도 아니라면
        else{
            cnt++;
            visited[curY][curX] = true;
            if(curX+1 < xLen && curY < yLen) dfs(curX+1, curY); // move right
            if(curX < xLen && curY+1 < yLen) dfs(curX, curY+1); // move down
            if(curX < xLen && curY-1 >= 0) dfs(curX, curY-1); // move up
            if(curX-1 >= 0 && curY < yLen) dfs(curX-1, curY); // move left
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str_ans = "";
        int testCase = Integer.parseInt(br.readLine());
        //테스트케이스만큼 실행
        while(testCase > 0){
            testCase--;
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            xLen = Integer.parseInt(st.nextToken());
            yLen = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            map = new boolean[yLen][xLen];
            visited = new boolean[yLen][xLen];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine()); // StringTokenizer는 한번 선언한 것을 다시 쓰면 된다
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = true;
            }

            for(int i = 0; i < xLen; i++){
                for(int j = 0; j < yLen; j++){
                    dfs(i, j);
                    if(cnt > 0) answer++;
                    cnt = 0;
                }
            }
            str_ans += (answer + "\n");
        }
        System.out.println(str_ans);
    }
}
