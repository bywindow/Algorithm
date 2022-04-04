package Solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Show_1 {
    static int n;
    static int[] c;
    static ArrayList<int[]>[] p;
    static boolean[] isSell;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        c = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++){
            c[i] = Integer.parseInt(st.nextToken());
            answer += c[i];
        }
        p = new ArrayList[n+1];
        for(int i = 0; i < p.length; i++){
            p[i] = new ArrayList<>();
        }
        isSell = new boolean[n+1];
        for(int i = 1; i < n+1; i++){
            int cnt = Integer.parseInt(br.readLine());
            for(int j = 0; j < cnt; j++){
                st = new StringTokenizer(br.readLine());
                p[i].add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
        }
        int[] dp = new int[n+1];
        dp[0] = answer;
        for(int i = 1; i < n+1; i++){
            int sum = dp[i-1];
            int step = 0;
            int next = 0;
            for(int j = 1; j < n+1; j++){
                if(isSell[j]) continue;
                int curStep = 0;
                for(int k = 0; k < p[j].size(); k++){
                    int[] cur = p[j].get(k);
                    if(isSell[cur[0]]) continue;
                    curStep += Math.min(c[cur[0]]-1, cur[1]);
                }
                if(step <= curStep){
                    next = j;
                    step = curStep;
                }
            }
            isSell[next] = true;
            dp[i] = sum - step;
            for(int j = 0; j < p[next].size(); j++){
                int[] cur = p[next].get(j);
                c[cur[0]] = Math.max(1, c[cur[0]] - cur[1]);
            }
        }
        System.out.println(dp[n]);
    }
}
