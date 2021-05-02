package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ16171 {

    public static void main(String[] args) throws IOException{
        //System.out.println('0' - 48);//0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = st.nextToken();
        /**
         * 문자열에서 숫자를 뺐을 때 연속된 문자이면 된다
         * 1. 두 문자열의 현재 커서의 문자가 같을 때:input과 keyword의 커서 +1
         * 2. 아닐 때
         *  - input의 해당 문자가 숫자인지 판단
         *      - 숫자가 아니면 키워드의 인덱스를 0으로 하고 다시 탐색
         *      - 숫자면 input의 커서 +1
         *      - **아직 키워드랑 일치하는 첫 문자를 찾지 못하면 조건없이 넘어감**
         */
        st = new StringTokenizer(br.readLine());
        String keyword = st.nextToken();
        int keyword_idx = 0;
        int start = 0;
        boolean isAnswer = false;

        for(int i = 0; i < input.length(); i++){

            char cur = input.charAt(i);
            //같을 때
            if(cur == keyword.charAt(keyword_idx)){
                if (keyword_idx == 0) start = i;
                keyword_idx++;
                if(keyword_idx == keyword.length()) {
                    isAnswer = true;
                    break;
                }
            }
            //다를 때
            else {
                if(keyword_idx == 0) continue;
                //숫자가 아니라면
                if(cur - 48 > 9 || cur - 48 < 0){
                    keyword_idx = 0;
                    i = start;
                }
            }
        }
        if(isAnswer) System.out.println(1);
        else System.out.println(0);
    }
}
