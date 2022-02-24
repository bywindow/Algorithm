package programmers;

import java.util.*;

public class Kaka02022_2 {
    public static int solution(int n, int k) {
        int answer = 0;
        int input = n;
        String output = "";
        while(input > 0){
            output = input % k + output;
            input /= k;
        }
        String[] primes = output.split("0");
        for(int i = 0; i < primes.length; i++){
            if(primes[i].length() > 0){
                if(findPrime(Integer.parseInt(primes[i]))) answer += 1;
            }
        }
        return answer;
    }

    public static boolean findPrime(int n){
        int[] num = new int[n+1];
        num[0] = num[1] = 1;
        for(int i = 2; i*i <= n; i++){
            if(num[i] == 0){
                for(int j = i*2; j <= n; j+=i){
                    num[j] = 1;
                }
            }
        }
        return num[n] == 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(999999, 10));
    }
}
