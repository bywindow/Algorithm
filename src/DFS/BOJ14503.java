package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int n, m, r, c, d;
    static int[][] map; //빈칸: 0, 벽: 1
    static boolean[][] visited;
    static int[] moveY = {-1, 0, 1, 0}; //북동남서
    static int[] moveX = {0, 1, 0, -1};
    static int answer = 0;

    static void dfs(int curR, int curC, int curD){

        visited[curR][curC] = true;
        answer++;

        for(int i = 1; i <= 4; i++){
            int nd = (curD - i + 4) % 4;
            int nr = curR + moveY[nd];
            int nc = curC + moveX[nd];
            if(nr<0 || nr>=n || nc<0 || nc >=m) continue;
            if(visited[nr][nc] || map[nr][nc]==1) continue;
            dfs(nr, nc, nd);
        }

        int backD = (curD+2) % 4;
        int backR = curR + moveY[backD];
        int backC = curC + moveX[backD];
        if(backR>=0 && backR<n || backC>=0 && backC<m){
            if(map[backR][backC] == 0){
                answer--;
                //뒤로 가는 방향은 유지되어야 한다.
                dfs(backR, backC, curD);
            } else {
                System.out.println(answer);
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(r,c,d);
    }
}
