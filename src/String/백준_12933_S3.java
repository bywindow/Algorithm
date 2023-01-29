package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * List를 만들어서 새롭게 오리가 추가되는 경우 추가
 * q,u,a,c,k 에 대해 1,2,3,4,5로 저장하고 값을 보고 적절한 원소를 업데이트
 */

class Main12933{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if(input.charAt(0) != 'q' || input.length() % 5 != 0){
            System.out.println(-1);
            return;
        }
        ArrayList<Integer> ducks = new ArrayList<>();
        ducks.add(1);

        for(int i = 1; i < input.length(); i++){
            char cur = input.charAt(i);
            boolean isFind = false;
            if(cur == 'q'){
                for(int j = 0; j < ducks.size(); j++){
                    if(ducks.get(j) == 5){
                        isFind = true;
                        ducks.set(j, 1);
                        break;
                    }
                }
                if(!isFind) ducks.add(1);
            } else if (cur == 'u') {
                for(int j = 0; j < ducks.size(); j++){
                    if(ducks.get(j) == 1){
                        isFind = true;
                        ducks.set(j, 2);
                        break;
                    }
                }
                if(!isFind) {
                    System.out.println(-1);
                    return;
                }
            } else if (cur == 'a') {
                for(int j = 0; j < ducks.size(); j++){
                    if(ducks.get(j) == 2){
                        isFind = true;
                        ducks.set(j, 3);
                        break;
                    }
                }
                if(!isFind) {
                    System.out.println(-1);
                    return;
                }
            } else if (cur == 'c') {
                for(int j = 0; j < ducks.size(); j++){
                    if(ducks.get(j) == 3){
                        isFind = true;
                        ducks.set(j, 4);
                        break;
                    }
                }
                if(!isFind) {
                    System.out.println(-1);
                    return;
                }
            } else {
                for(int j = 0; j < ducks.size(); j++){
                    if(ducks.get(j) == 4){
                        isFind = true;
                        ducks.set(j, 5);
                        break;
                    }
                }
                if(!isFind) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        for(int i : ducks){
            if(i != 5){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(ducks.size());
    }
}