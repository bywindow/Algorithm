package DFS;

import java.util.*;
import java.io.*;

public class Kakao2022_4 {
    static int apeach = 0;
    static int lion;
    static int[] apeachInfo;
    static int[] lionInfo = new int[11];
    static int MIN = 10;

    static void dfs(int n, int[] info, int cnt, int score){
        if(n < cnt) return;
        if(n == cnt) {
            if(lion < score) {
                lionInfo = info.clone();
                for(int i = 10; i < info.length; i++){
                    if(info[i] == 0) continue;
                    MIN = Math.min(MIN, i);
                    break;
                }
                return;
            }
            if(lion == score){
                for(int i = 10; i >= 0; i--){
                    if(info[i] == 0) continue;
                    if(i < MIN){
                        lionInfo = info.clone();
                        MIN = i;
                        break;
                    }
                }
            }
        }
    }

    public static int[] solution(int n, int[] info) {
        int[] answer = {};
        apeachInfo = info.clone();
        for(int i = 0 ; i < info.length; i++){
            apeach += (10 - i) * info[i];
        }
        return answer;
    }
}
