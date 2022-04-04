package Bootcamp;

import java.util.Scanner;

public class upstairs {

    private static int recur(int num){
        if(num == 1) return num;
        if(num == 2) return num;
        else return recur(num-2) + recur(num-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(recur(n));
        sc.close();
    }

}
