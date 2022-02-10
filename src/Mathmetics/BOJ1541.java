package Mathmetics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l = br.readLine();
        int[] nums = new int[50];
        int pm = 1;
        int cur = 0;
        int cnt = 0;
        for(int i = 0; i < l.length(); i++){
            // numeric? make number
            if(0 <= l.charAt(i)-'0' && l.charAt(i)-'0' <= 9){
                cur = cur * 10 + l.charAt(i)-'0';
                if(i == l.length()-1) nums[cnt] = cur * pm;
            }
            else{
                // save number
                nums[cnt] = cur * pm;
                cur = 0;
                cnt++;
                pm = l.charAt(i) == '-' ? -1 : 1;
            }
        }
        // - 바로 뒤에 +가 있다면 그 수는 -로 바꾸기
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] < 0 && nums[i] > 0){
                nums[i] *= -1;
            }
        }
        int answer = 0;
        for(int i: nums){
            answer += i;
        }
        System.out.println(answer);
    }
}
