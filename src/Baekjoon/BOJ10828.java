package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ10828 {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){
                case "push" :
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;

                case "pop" :
                    if(stack.isEmpty()) System.out.println("-1");
                    else{
                        int y = stack.lastElement();
                        stack.pop();
                        System.out.println(y);
                    }
                    break;
                case "size" :
                    System.out.println(stack.size());
                    break;

                case "empty" :
                    if(stack.isEmpty()) System.out.println("1");
                    else System.out.println("0");
                    break;

                case "top" :
                    if(stack.isEmpty()) System.out.println("-1");
                    else System.out.println(stack.lastElement());
                    break;
            }
        }
    }
}
