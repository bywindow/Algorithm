package Test;

import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] arr_str = input.split(" ");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char[][] skill = new char[n][2];
        for(int i = 0; i < skill.length; i++){
            st = new StringTokenizer(br.readLine());
            skill[i][0] = st.nextToken().charAt(0);
            skill[i][1] = st.nextToken().charAt(0);
        }
        String[] answer = new String[n];
        for(int i = 0; i < skill.length; i++){
            answer[i] = skill[i][0] + " " + skill[i][1];
            for(int j = i+1; j < skill.length; j++){
                if(answer[i].charAt(answer[i].length()-1) == skill[j][0]){
                    answer[i] += " " + skill[j][1];
                }
            }
            System.out.println(answer);
        }
    }
}

