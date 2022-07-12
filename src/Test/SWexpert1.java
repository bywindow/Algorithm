package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SWexpert1 {

    static int n;
    static int[][] land;
    static ArrayList<int[]>[] heights = new ArrayList[101];
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    static boolean[][] visited;
    static int answer;

    static void findSection(int x, int y){
        visited[y][x] = true;
        //move
        for(int i = 0; i < 4; i++){
            int nx = x + moveX[i];
            int ny = y + moveY[i];
            if(0 <= ny && ny < n && 0 <= nx && nx < n && land[ny][nx] != 0 && !visited[ny][nx])
                findSection(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Integer.MAX_VALUE);
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int i = 0; i < heights.length; i++){
            heights[i] = new ArrayList<int[]>();
        }
        for(int test_case = 1; test_case <= T; test_case++){
            n = sc.nextInt();
            land = new int[n][n];
            answer = 0;
            for(int j = 0; j < n; j++){
                int cur;
                for(int k = 0; k < n; k++){
                    cur = sc.nextInt();
                    land[j][k] = cur;
                    heights[land[j][k]].add(new int[] {j, k});
                }
            }
            for(int j = 1; j < 101; j++){
                if(heights[j].size() == 0) continue;
                int section = 0;
                visited = new boolean[n][n];
                for(int k = 0; k < heights[j].size(); k++){
                    int[] p = heights[j].get(k);
                    land[p[0]][p[1]] = 0;
                }
                for(int k = 0; k < n; k++){
                    for(int m = 0; m < n; m++){
                        if(land[k][m] != 0 && !visited[k][m]){
                            findSection(m, k);
                            section++;
                        }
                    }
                }
                answer = Math.max(answer, section);
                heights[j].clear();
            }
            System.out.println("#" + test_case + " " + answer);
        }
        sc.close();
    }
}
