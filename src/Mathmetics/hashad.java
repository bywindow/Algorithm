package codingtr;

import java.util.Scanner;

public class hashad {
    public boolean hashadAnswer(int x) {
        boolean answer = true;

        int i, j = 0;
        int z, y, sum = 0;
        if (x >= 1 && x <= 10) {
            answer = true;
        } else if (x >= 11 && x <= 99) {
            i = x / 10;
            j = x % 10;
            sum = i + j;
            if (x % sum == 0) {
                answer = true;
            } else
                answer = false;
        } else if (x >= 100 && x <= 999) {
            i = x / 100;
            j = (x % 100) / 10;
            z = (x % 100) % 10;
            sum = i + j + z;
            if (x % sum == 0) {
                answer = true;
            } else
                answer = false;
        } else if (x >= 1000 && x <= 10000) {
            i = x / 1000;
            j = (x % 1000) / 100;
            z = ((x % 1000) % 100) / 10;
            y = ((x % 1000) % 100) % 10;
            sum = i + j + z + y;
            if (x % sum == 0) {
                answer = true;
            } else
                answer = false;
        } else {
            System.out.println("1이상 10000이하인 정수를 입력해주시기 바랍니다.");
            answer = false;
        }
        return answer;
    }

    public static void main(String[] args) {
        while (true) {
            hashad h = new hashad();
            Scanner stdin = new Scanner(System.in);
            int arr = stdin.nextInt();
            System.out.println(h.hashadAnswer(arr));
            if(arr == 0) break;
        }
    }
}