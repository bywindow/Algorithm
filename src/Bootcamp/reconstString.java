package Bootcamp;

import java.util.ArrayList;


public class reconstString {

    public static String solution(String input){

        String output = "";
        String[] arr_input = input.split("");//input의 각 글자를 배열형태로 저장
        //위에서 선언한 배열을 Arraylist형태에 복사한다
        ArrayList<String> arr_str = new ArrayList<>();
        for(String s : arr_input){
            arr_str.add(s);
        }

        for(int i = 0; i < arr_str.size();){
            String first = arr_str.get(0);//리스트의 첫번째 글자와 같은 것들을 찾는다
            int sum = 0;//같은 것이 총 몇 개인지 기록
            //뒤에서부터 검색하고 삭제해야 리스트의 인덱스 값에 영향이 없다
            for(int j = arr_str.size()-1; j >= 0; j--){
                //같은 글자가 발견된다면
                if(arr_str.get(j).equals(first)){
                    sum++;//같은 것의 갯수를 1만큼 증가
                    arr_str.remove(j);//리스트에서 그 값을 제거한다
                }
            }
            //같은 글자가 ((총 길이+1)/2)보다 크면 성립하지 않으므로 프로그램 종료
            if(sum > (input.length()+1)/2){
                output = "";
                System.exit(0);
            }
        }
        //해당 인덱스와 그보다 1만큼 작은 인덱스의 값을 비교하고 같으면 해당 인덱스의 값을 다른 것과 스왑한다.
        for(int i = 1; i < arr_input.length-1; i++){
            if(arr_input[i-1].equals(arr_input[i])){
                for(int j = i+1; j < arr_input.length; j++){
                    //다른 것이 발견된다면 스왑!
                    if(!arr_input[j].equals(arr_input[i])){
                        String temp = arr_input[j];
                        arr_input[j] = arr_input[i];
                        arr_input[i] = temp;
                    }
                }
            }
        }

        for(String s : arr_input){
            output += s;
        }

        return output;
    }

    public static void main(String[] args) {

        String input = "aaaacccccchkhhhkkk";
        System.out.println(solution(input));

    }
}
