package NHN;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TEST_3 {

    static Boolean[][] map = new Boolean[9][9];
    static int answer = 0;

    public static void solution(int num, int[][] con){
        for(int i = 0; i < num; i++){
            map[con[i][0]][con[i][1]] = map[con[i][1]][con[i][0]] = false;
        }
        int[] array = new int[8];
        for(int i = 0; i < array.length; i++){
            array[i] = i+1;
        }
        permutation(array, 0);
        System.out.println(answer);
    }
    static void permutation(int[] arr, int depth) {
        if (depth == 8) {
            Boolean isValid = true;
           for(int i = 0; i < arr.length-1; i++){
               if(!map[arr[i]][arr[i+1]]) {
                   isValid = false;
                   break;
               }
           }
           if(isValid) answer++;
           return;
        }

        for (int i=depth; i<8; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}
