//두 정렬된 배열의 원소를 모두 살펴보고 중간값을 리턴
//두 배열을 결합해서 배열하고, 결합한 배열의 크기가 홀수이면 중간값을, 짝수이면 중간의 두 수의 평균을 리턴
package Bootcamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class medianOfSort {
    public static String CalMedian(ArrayList<Integer> num1, ArrayList<Integer> num2){
        float median_f = 0;//구하려는 중앙값
        //두 리스트를 합쳐서 새로운 리스트를 생성
        ArrayList<Integer> joined = new ArrayList<>();
        joined.addAll(num1);
        joined.addAll(num2);
        //합쳐진 리스트를 정렬
        Collections.sort(joined);
        //리스트의 크기가 홀수일 때 중간값을 리턴
        if(joined.size() % 2 ==1){
            median_f = joined.get(joined.size()/2);
        }
        //리스트의 크기가 짝수일 때 중앙의 두 수의 평균을 리턴
        else{
            median_f = (joined.get((joined.size()/2)-1) + joined.get(joined.size()/2)) / 2.0f;
        }
        String median_str = String.format("%.5f", median_f);
        return median_str;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> num1 = new ArrayList<>();
        ArrayList<Integer> num2 = new ArrayList<>();
        //리스트에 값을 입력
//        num1.add(1);
//        num1.add(2);
//        num2.add(3);
//        num2.add(4);

        System.out.println("num1 = ");
        for(int i = 0; scanner.hasNextInt();i++){
            int input1 = scanner.nextInt();
            num1.add(input1);
        }
        System.out.println("num2 = ");
        //버퍼 초기화
        scanner.next();
        for(int i = 0; scanner.hasNextInt();i++){
            int input2 = scanner.nextInt();
            num2.add(input2);
        }
        System.out.println("중앙값 : " + CalMedian(num1,num2));
        scanner.close();
    }
}
