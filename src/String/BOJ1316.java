/**
 * @Date: 2021-04-25
 * @Algorithm: string
 * @Title: 그룹 단어 체커
 */
package String;


import java.util.*;
import java.io.*;

public class BOJ1316 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int answer = n;
        /**
         * 새로운 알파벳이 나오면 그 알파벳을 배열에 기록
         * input에서 현재 탐색하고 있는 인덱스의 char가 지금까지 배열에 기록한 배열의 char 중 마지막 것과 같은지 비교
         * 다르다면 다른 알파벳과 비교하고 같은 게 있으면 해당 input은 그풉단어가 아닌거고
         * 새로운 알파벳이면 새로운 알파벳이라고 배열에 기록
         */

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            char[] alpha = new char[input.length()];
            alpha[0] = input.charAt(0);
            boolean breakPoint = false;
            int idx = 0; //현재 배열에 마지막으로 등록된 단어의 인덱스
            for(int j = 1; j < input.length(); j++){
                if(input.charAt(j) != alpha[idx]){
                    for(int k = 0; k < idx; k++){
                        if(input.charAt(j) == alpha[k]){
                            breakPoint = true;
                            break;
                        }
                    }
                    if(!breakPoint){
                        idx++;
                        alpha[idx] = input.charAt(j);
                    }
                }
                if(breakPoint) {
                    answer -= 1;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
