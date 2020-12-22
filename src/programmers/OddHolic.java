/*
백준 20164번
 */
package codingtr;

import java.util.Scanner;

public class OddHolic {

    static int min = Integer.MAX_VALUE;
    static int max = 0;

    static void dfs(String input, int odd_cnt){

        //수가 한 자리이면 더 이상 아무것도 하지 못하고 종료한다.
        if(input.length()==1){
            min = Math.min(min, odd_cnt);
            max = Math.max(max, odd_cnt);
            return;
        }
        //수가 두 자리이면 2개로 나눠서 합을 구하여 새로운 수로 생각한다.
        if(input.length() == 2){
            int num = Integer.parseInt(input)/10 + Integer.parseInt(input)%10;
//            if((Integer.parseInt(input)/10)%2 == 1) cnt++;
//            if((Integer.parseInt(input)%10)%2 == 1) cnt++;
            int cnt = 0;
            if((num / 10) % 2 == 1) cnt++;
            if((num%10) % 2 == 1) cnt++;
            dfs(Integer.toString(num), odd_cnt+cnt);
            return;
        }
        //수의 각 자리 숫자 중에서 홀수의 개수를 종이에 적는다.
        //수가 세 자리 이상이면 임의의 위치에서 끊어서 3개의 수로 분할하고, 3개를 더한 값을 새로운 수로 생각한다.
        int x;

        for(int i = 0; i <= input.length()-3; i++){
            for(int j = i+1; j <= input.length()-2; j++){
                String s1 = input.substring(0,i+1); //0 ~ i번째까지
                String s2 = input.substring(i+1, j+1); //i+1 ~ j번째까지
                String s3 = input.substring(j+1, input.length()); //j+1 ~ 끝까지

                x = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                int n = x;
                int cnt = 0;
                while(x>0){
                    int num = x % 10;
                    if(num % 2 ==1) cnt++;
                    x /= 10;
                }
                dfs(Integer.toString(n), odd_cnt+cnt);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int cnt = 0;
        int x = Integer.parseInt(input);
        while(x > 0){
            int num = x % 10;
            if(num % 2 ==1) cnt++;
            x /= 10;
        }

        dfs(input, cnt);
        System.out.println("최솟값 : " + min + "\t" + "최댓값 : " + max);

    }
}
