package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1913 {

    // [0][0]부터 반대로 진행
    // 남 -> 동 -> 북 -> 서 방향으로 진행
    // 카운트를 -1씩 하면서 진행

    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // N, E, S, W
    static int[][] map;
    static int n;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());

        map = new int[n][n];

        int dir = 0; // moving direction
        int row = 0;
        int col = 0;

        String answer = "";

        // 한 바퀴가 한 세트로
        for(int i = n*n; i > 0; i--){
            map[row][col] = i;
            if(i == target) answer = row+1 + " " + (col + 1);
            int nr = row + move[dir][0];
            int nc = col + move[dir][1];
            if(nr < 0 || nr >= n || nc < 0 || nc >= n || map[nr][nc] != 0) {
                dir = (dir + 1) % 4;
                nr = row + move[dir][0];
                nc = col + move[dir][1];
            }
            row = nr;
            col = nc;
        }

        for(int[] i : map){
            for(int j : i){
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString() + answer);
    }
}
