package DP;

import java.io.*;

public class BOJ9251 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input1 = br.readLine();
        String input2 = br.readLine();


        int[][] board = new int[input2.length()][input1.length()];
        int initial = 0;//첫번째 행, 첫번째 열 초기값 설정
        for(int i = 0; i < input1.length(); i++){
            if(input1.charAt(i)==input2.charAt(0)) initial =1;//서로 같은 문자가 나오면 그 다음부터는 계속 1
            board[0][i] = initial;
        }
        initial = 0;
        for(int j = 0; j < input2.length(); j++){
            if(input1.charAt(0)==input2.charAt(j)) initial = 1;
            board[j][0] = initial;
        }
        for(int i = 1; i < board.length; i++){
            for(int j = 1; j < board[i].length; j++){
                if(input1.charAt(i)==input2.charAt(j)){
                    board[i][j] = board[i-1][j-1] + 1; //서로 같은 문자가 나오면 왼쪽 대각선 값에서 +1
                }
                else{
                    board[i][j] = Math.max(board[i][j-1], board[i-1][j]);
                }
            }
        }
        int answer = board[input2.length()-1][input1.length()-1];
        bw.write(Integer.toString(answer));
        bw.flush();
        br.close();
        bw.close();
    }
}
