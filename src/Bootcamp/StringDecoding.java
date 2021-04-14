/*
숫자와 문자로 이루어진 문자열을 입력받아 정해진 규칙대로 디코딩하는 프로그램
예시) 3[a]2[bc] --> aaabcbc
*/
package Bootcamp;

import java.util.Scanner;

public class StringDecoding {
    public static String recur(String input_str, int cur_pos, String update_str){
        if(cur_pos<0) return update_str;
        //열린 꺽쇠를 만났을 때
        if(input_str.charAt(cur_pos)=='['){
            return recur(input_str, cur_pos-1, update_str);
        }
        //숫자를 만났을 때
        else if(input_str.charAt(cur_pos)>=48&&input_str.charAt(cur_pos)<=57){
            //update_str += update_str.repeat((input_str.charAt(cur_pos)-'0')-1);
            return recur(input_str,cur_pos-1,update_str);
        }
        //문자를 만났을 때
        else {
            update_str = input_str.charAt(cur_pos)+update_str;
            return recur(input_str, cur_pos-1, update_str);
        }
    }
    public static String print_str(String input_str){
        String[] array_str = input_str.split("]");
        String update_str = "";
        String output_str = "";
        for (int i = 0; i < array_str.length; i++) {
            array_str[i]= recur(array_str[i], array_str[i].length()-1, update_str);
            output_str += array_str[i];
        }
        return output_str;
    }

    public static void main(String[] args) {
        String input = "5[a]2[bc]";
        System.out.println(print_str(input));
    }
}
