package DFS;

import java.io.*;
import java.util.*;

public class BOJ11724 {

    static int answer = 0;
    static int n;
    static int m;
    static boolean[] visited;
    static boolean[][] edge;

    static void dfs(int r){
        if(visited[r]) return;

        else{
            visited[r] = true;
            for(int i = 1; i <= n; i++){
                if(edge[r][i]){
                    dfs(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());//정점의 개수
        m = Integer.parseInt(st.nextToken());//간선의 개수
        visited = new boolean[n+1];
        edge = new boolean[n+1][n+1];//정점들이 연결된 정보

        //간선을 입력받는다
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            edge[v1][v2] = edge[v2][v1] = true;
        }

        for(int i = 1; i <= n; i++){
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
