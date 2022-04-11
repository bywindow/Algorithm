package Solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Show_3 {
    static int n;
    static int q;
    static int[] a;
    static boolean[][] road;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int s, int e, boolean[] visited, String result){

        visited[s] = true;
        String str = result + a[s];
        long cur = Long.parseLong(str);
        int mod = (int) (cur % 1000000007);

        if(s == e){
            sb.append(mod).append("\n");
            return;
        }
        for(int i = 1; i < road[s].length; i++){
            if(road[s][i] && !visited[i]) {
                dfs(i, e, visited, String.valueOf(mod));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        a = new int[n+1];
        road = new boolean[n+1][n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            road[s][e] = road[e][s] = true;
        }
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            boolean[] visited = new boolean[n+1];
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            dfs(s, e, visited, "");
        }
        System.out.println(sb.toString());
    }
}
