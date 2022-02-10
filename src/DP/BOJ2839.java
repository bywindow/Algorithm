/**
 * @Date : 2021-04-11
 * @Title : 설탕배달
 * @Desc : 설탕 N kg을 배달하는데 3kg과 5kg 봉지에 담아서 배달한다. 가장 적은 봉지로 배달할 때의 봉지 개수
 *         3과 5로 딱 나누어떨어지도록 담을 수 없는 경우 -1을 반환
 */

package DP;

import java.util.*;
import java.io.*;

public class BOJ2839 {

    static int n; //총 배달해야할 설탕의 무게
    static int answer = 0; //필요한 최소 봉지 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        /**
         * n을 5로 나누었을때
         * -> 1. mod == 0 : 몫이 답
         * -> 2. mod != 0 : n-3, cnt+1, 다시 검사
         */
        while (n > 0) {
            if(n % 5 == 0) {
                System.out.println((n/5) + answer);
                return;
            } else {
                n -= 3;
                answer++;
            }
        }
        if(n == 0) System.out.println(answer);
        /* n이 0보다 작아졌을 경우 : 봉지로 나눌 수 없는 경우 */
        else System.out.println(-1);
    }
}
