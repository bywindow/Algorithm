package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2961 {

    static int n;
    static int[][] method; // 초기 재료
    static boolean[] isUsed; // 사용되는 재료 체크
    static long answer = 1000000000;

    //재귀함수로 해당 재료가 사용되는 경우, 사용되지 않는 경우를 모두 진행
    //부분집합을 만든다
    static void recur(int cnt){
        //하나의 부분집합이 만들어졌을 때
        if (cnt == n) {
            //신맛 쓴맛 계산
            int s = 1;
            int b = 0;
            int using = 0; //사용되는 재료의 개수 : 공집합 체크용
            for(int i = 0; i < isUsed.length; i++){
                if(!isUsed[i]) continue;
                using++;
                s *= method[i][0];
                b += method[i][1];
            }
            if(using < 1) return;
            int curMin = Math.abs(s - b);
            if (curMin < answer) answer = curMin;
            return;
        }
        //recursion
        //사용하는 경우
        isUsed[cnt] = true;
        recur(cnt+1);
        //사용하지 않는 경우
        isUsed[cnt] = false;
        recur(cnt+1);
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        method = new int[n][2];
        isUsed = new boolean[n];
        for(int i = 0; i < method.length; i++){
            st=new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                method[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0);
        System.out.println(answer);
    }
}
