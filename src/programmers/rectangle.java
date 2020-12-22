package codingtr;

import java.util.Scanner;

public class rectangle {

    public static int[] solution(int[][] v){
        //static 함수에서 호출당해야되므로 static형
        int[] answer = new int[2];

        //x축 찾기
        if(v[0][0] == v[1][0])  answer[0] = v[2][0];
        else if(v[0][0] == v[2][0]) answer[0] = v[1][0];
        else answer[0] = v[0][0];

        //y축 찾기
        if(v[0][1] == v[1][1])  answer[1] = v[2][1];
        else if(v[0][1] == v[2][1]) answer[1] = v[1][1];
        else answer[1] = v[0][1];
        return answer;
    }

    public static void main(String[] args) {
        //static이어야 main mathod를 인식한다...
        Scanner stdin = new Scanner(System.in);

        int a;
        int[][] point = new int[3][2];
        for(int i =0;i<3;i++){
            for(int j =0;j<2;j++){
                a=stdin.nextInt();
                point[i][j] = a;
            }
        }

        int[] ans = solution(point);

        System.out.println(ans[0] +","+ ans[1]); //배열의 각 요소를 따로 적어주지 않으면 배열의 주소를 출력한다

        stdin.close();
    }

}

