package String;

import java.util.*;
import java.io.*;

public class BOJ1181 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String[] input = new String[n];
        /**
         * 사전순 배열 -> for문을 50번 반복해서 해당 글자 길이의 문자열을 순서대로 출력
         */
        st = new StringTokenizer(br.readLine());
        input[0] = st.nextToken();
        for(int i = 1; i < n; i++){
            boolean same = false;
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            //같은 단어가 있는지 찾는다
            for(int j = 0; j < i; j++){
                if(str.equals(input[j])) same = true;
            }
            //같은 단어가 있다면 문자열 대신 1을 넣음
            if(same) input[i] = "1";
            else input[i] = str;
        }
        Arrays.sort(input);
        for(int i = 1; i <= 50; i++){
            for(int j = 0; j < n; j++){
                if(input[j].length() == i && !input[j].equals("1")) System.out.println(input[j]);
            }
        }
    }
}
