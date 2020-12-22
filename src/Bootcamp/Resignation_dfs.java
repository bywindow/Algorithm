/*
백준14501 퇴사
 */
package Bootcamp;


import java.util.Scanner;

public class Resignation_dfs {

    static int answer = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] Ti = new int[N];
        int[] Pi = new int[N];
        for(int i = 0; i < N; i++){
            Ti[i] = sc.nextInt();
            Pi[i] = sc.nextInt();
        }

        recur(N, 0, Ti, Pi, 0);

        System.out.println(answer);

    }

    static void recur(int N, int idx, int[] Ti, int[] Pi, int sum){

        if(idx > N){
            return;
        }

        else{
           answer = Math.max(answer, sum);
           if(idx == N) return;
        }
        //그날의 상담을 하는 경우
        recur(N, idx+Ti[idx], Ti, Pi, sum+Pi[idx]);
        //그날의 상담을 하지 않는 경우 -> sum에 그날의 Pi를 더하지 않는다
        recur(N, idx+1, Ti, Pi, sum);
    }
}
