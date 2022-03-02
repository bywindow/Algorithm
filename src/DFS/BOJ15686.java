package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15686 {

    /**
     * dfs와 backtracking을 사용해서 풀자
     */

    static int n, m;
    static int[][] town;
    static ArrayList<int[]> chicken;
    static ArrayList<int[]> house;
    static boolean[] isOpen;
    static int answer = Integer.MAX_VALUE;

    static void dfs(int cur, int cnt){
        // 치킨집이 m개 열려있을 때
        if(cnt == m){
            int[] dist = new int[house.size()]; // 각 집의 치킨거리
            Arrays.fill(dist, Integer.MAX_VALUE);

            for(int i = 0; i < chicken.size(); i++){
                if(!isOpen[i]) continue; // 닫혀 있는 치킨집은 패스
                int[] curChicken = chicken.get(i);
                for(int j = 0; j < house.size(); j++){
                    int[] curHouse = house.get(j);
                    dist[j] = Math.min(dist[j],
                            (Math.abs(curChicken[0] - curHouse[0]) + Math.abs(curChicken[1] - curHouse[1])));
                }
            }
            // sum chicken distance
            int sum = 0;
            for(int i : dist){
                sum += i;
            }
            answer = Math.min(answer, sum);
            return;
        }

        // backtracking
        for(int i = cur; i < chicken.size(); i++){
            isOpen[i] = true;
            dfs(i+1, cnt+1);
            isOpen[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        town = new int[n+1][n+1];
        chicken = new ArrayList<>();
        house = new ArrayList<>();

        for(int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n+1; j++){
                town[i][j] = Integer.parseInt(st.nextToken());
                // 치킨집의 위치를 저장
                if(town[i][j] == 2) chicken.add(new int[]{i, j});
                else if(town[i][j] == 1) house.add(new int[]{i, j});
            }
        }
        isOpen = new boolean[chicken.size()]; // 치킨집의 오픈 여부


        dfs(0, 0);
        System.out.println(answer);
    }
}
