package BruteForce;

import java.io.*;
import java.util.*;

public class BOJ22943 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken()); //사용할 숫자의 개수
        int m = Integer.parseInt(st.nextToken()); //나누는 수
        int len = (int) Math.pow(10, k) + 1;
        int[] check = new int[len];

        //서로 다른 두개의 소수의 합
        //소수를 구한다
        boolean[] isPrime = new boolean[len];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i * i < isPrime.length-1; i++){
            if(!isPrime[i]) continue; //이미 소수가 아니라고 체크했으면 넘어가기
            for(int j = i*i; j < isPrime.length; j += i){
                isPrime[j] = false;
            }
        }

        //서로 다른 두 소수의 합 중 범위에 속하는 걸 찾는다
        //한번씩만 사용하여 만들 수 있는 수...?
        for(int i = 2; i < isPrime.length; i++){
            if(!isPrime[i]) continue;
            for(int j = i+1; j < isPrime.length; j++){
                if(!isPrime[j]) continue;
                if(i + j >= Math.pow(10, k-1) && i+j < Math.pow(10,k)){
                    check[i+j] = 1;
                }
            }
        }

        for(int i=0; i < check.length; i++){
            if(check[i] == 0) continue;
            int cur = i;
            while(cur % m == 0){
                cur /= m;
            }
            //두 소수의 곱인 경우 : 나눈 후 몫이 소수다
            for(int j = 2; j < cur; j++){
                if(!isPrime[j]) continue;
                if(cur % j == 0 && isPrime[cur/j]) {
                    check[i]=2;
                    break;
                }
            }
        }

        int answer = 0;
        for(int i =0 ; i < check.length; i++){
            if(check[i]==2){
                boolean isDouble = false;
                String str = String.valueOf(i);
                for(int j = 0; j < str.length(); j++){
                    if(str.length() - str.replace(str.substring(j,j+1), "").length() > 1){
                        isDouble = true;
                        break;
                    }
                }
                if(!isDouble) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
