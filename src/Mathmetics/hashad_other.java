package codingtr;

import java.util.Scanner;

public class hashad_other {
    public boolean isHarshad(int num) {

        String[] temp = String.valueOf(num).split("");

        int sum = 0;
        for (String s : temp) {
            sum += Integer.parseInt(s);
        }
        if (sum > 0) {
            if (num % sum == 0) {
                return true;
            } else {
                return false;
            }

        } else
            return false;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        hashad_other sn = new hashad_other();
        Scanner stdin = new Scanner(System.in);
        int arr = stdin.nextInt();
        System.out.println(sn.isHarshad(arr));
    }
}
