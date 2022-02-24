package String;

import java.util.*;
import java.io.*;

public class BOJ9342 {

    

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * A,B,C,D,E,F 중 0개 또는 1개로 시작
         * A 다음에는 F, F 다음에는 C 가 와야한다
         * C로 끝날 수도 있고 C 다음에 ABDEF 중 하나가 올 수도 있따
         */
        int t = Integer.parseInt(st.nextToken());
        String start = "ABCDEF";
        char[] element = {'A', 'F', 'C'};
        
        while(t>0){
            t--;
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            boolean check = true;
            
            //첫 글자 검사
            if(start.indexOf(input.charAt(0)) < 0){
                System.out.println("Good");
                continue;
            }
            //A,F,C
            int cur = input.charAt(0) == 'A' ? 0 : 1;
            for(int i = 0; i < element.length; i++){
                if(input.charAt(cur) != element[i]){
                    System.out.println("Good");
                    check = false;
                    break;
                }
                else{
                    for(int j = cur; j < input.length(); j++){
                        if(input.charAt(j) != element[i]){
                            cur = j;
                            break;
                        }
                        else cur++;
                    }
                }
            }
            //마지막 글자
            if(check){
                if(cur == input.length()){
                    System.out.println("Infected!");
                }
                else if(input.length() - cur > 1){
                    System.out.println("Good");
                }
                else{
                    if(start.indexOf(input.charAt(cur)) < 0){
                        System.out.println("Good");
                    }
                    else System.out.println("Infected!");
                }
            }
        }
    }
}