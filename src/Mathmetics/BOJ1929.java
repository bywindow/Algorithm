package Mathmetics;

import java.util.*;
import java.io.*;

/**
 * 2중 for문을 사용해서 범위 안에 수를 직접 나누어보는 방법 : 시간초과
 * 해결방법 : 에라토스테네스의 체
 */

public class BOJ1929 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] num = new int[n+1];//소수가 아닌 것에 1
        num[1] = 1;//1은 소수가 아니다
        //에라토스테네스의 체
        for(int i = 2; i*i <= n; i++){
            if(num[i] == 0){
                for(int j = i*2; j <= n; j+=i){
                    num[j] = 1;
                }
            }
        }
        for(int i = m; i <= n; i++){
            if(num[i] == 0) System.out.println(i);
        }
    }
}
