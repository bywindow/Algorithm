package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    static int[][] board = new int[19][19];

    static int[] moveX = {1, 0, 1, 1}; // right, down, up-right, down-right
    static int[] moveY = {0, 1, -1, 1};

    static void bfs(int x, int y) {

        int stone = board[y][x];

        for(int i = 0; i < 4; i++){
            int nx = x + moveX[i];
            int ny = y + moveY[i];
            int cnt = 1;
            while(0<=nx && nx<19 && 0<=ny && ny<19 && board[ny][nx] == stone){
                cnt++;
                if(cnt==5){
                    int px = x - moveX[i];
                    int py = y - moveY[i];
                    if (0 <= px && px < 19 && 0 <= py && py < 19 && board[py][px] == stone) break;
                    px = nx + moveX[i];
                    py = ny + moveY[i];
                    if (0 <= px && px < 19 && 0 <= py && py < 19 && board[py][px] == stone) break;
                    System.out.println(stone);
                    y++;
                    x++;
                    System.out.println(y + " " + x);
                    System.exit(0);
                }
                nx += moveX[i];
                ny += moveY[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0){
                    bfs(j, i);
                }
            }
        }
        System.out.println(0);
    }
}