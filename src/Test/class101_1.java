package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class class101_1 {

    public String solution(String[] A, String[] B, String P) {
        // write your code in Java SE 8
        String answer = "zzzzzzzzz";
        boolean isFind = false;
        for(int i = 0; i < B.length; i++){
            if(B[i].contains(P)){
                if(A[i].compareTo(answer) < 0){
                    answer = A[i];
                    isFind = true;
                }
            }
        }

        return isFind ? answer : "NO CONTACT";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}
