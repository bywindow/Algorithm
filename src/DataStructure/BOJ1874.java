package DataStructure;

import java.util.*;
import java.io.*;

public class BOJ1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        /**
         * 입력받은 숫자가 나올때까지
         * 스택에 순서대로 수를 넣는다
         * 입력받은 수가 나오면 pop한다
         *
         */
        Stack<Integer> stack = new Stack<>();
        int curInput = 0;//현재 몇 번째까지 넣었는지 기록

        for(int i = 0; i < n; i++){
            int cur = Integer.parseInt(br.readLine());
            //필요한경우 스택에 push
            for(int j = curInput+1; j <= cur; j++){
                stack.push(j);
                sb.append("+\n");
                curInput = j;
            }
            if(cur == stack.peek()){
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(stack.size() > 0 ? "NO" : sb.toString());
    }
}
