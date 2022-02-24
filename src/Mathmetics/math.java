package Mathmetics;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class math {
    
    public static int[] mathForegiver(int[] answers){

        int[] m1 = {1,2,3,4,5};//수포자1의 규칙
        int[] m2 = {2,1,2,3,2,4,2,5};//수포자2의 규칙
        int[] m3 = {3,3,1,1,2,2,4,4,5,5};//수포자3의 규칙
        int[] cnt = {0,0,0};//각 수포자가 맞힌 문제의 개수
        for(int i = 0; i<answers.length;i++){
            if(answers[i] == m1[i%5]) cnt[0]++;
            if(answers[i] == m2[i%8]) cnt[1]++;
            if(answers[i] == m3[i%10]) cnt[2]++;
        }
        int[] c_cnt = cnt.clone();//배열의 복제 clone()
        Arrays.sort(c_cnt);//복제한 배열을 오름차순으로 정렬
        List<Integer> man = new ArrayList<>();//각 수포자를 순위 매기는 배열
        for(int i =0; i <3; i++){
            if(c_cnt[2]==cnt[i]) man.add(i+1);//i+1로 수포자를 표현
        }
        int[] answer = new int[man.size()];
        for(int i =0;i<answer.length;i++){
            answer[i] = man.get(i);
        }
        
        return answer;
    }
    
    
    
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,2};
        int[] sol = mathForegiver(arr);
        for(int i : sol){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}