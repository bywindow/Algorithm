package Bootcamp;

import java.util.ArrayList;

public class ConvertInttoWords {
    public static void main(String[] args) {
        int input = 1234567891;
        ArrayList<Integer> arr_int = new ArrayList<>();
        while(input > 0){
            int num = input % 1000;
            arr_int.add(num);
            input /= 1000;
        }

    }
}
