package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {

    static int n;
    static int cnt = 0;
    static int[] pos;

    static void nQueen(int row){
        // 끝 행까지 갔다면 n-queen 배열을 찾았다는 것
        if(row == n){
            cnt++;
            return;
        }
        // dfs를 이용한 backtracking
        // 0 ~ n 중 현재 행에 어떤 값을 넣을 때 다음 단계로 넘어갈 수 있는지 확인
        for(int i = 0; i < n; i++){
            pos[row] = i;
            if(isPossible(row)){
                nQueen(row+1);
            }
        }
    }

    static boolean isPossible(int row){
        for(int i = 0; i < row; i++){
            // 같은 열에 있는 경우 : pos 배열에 같은 숫자가 하나라도 있으면 안된다
            if(pos[i] == pos[row]) return false;
            // 우상향 대각선 : (x-1,y+1) (x,y) (x+1,y-1)
            // 해당 row와 col의 합이 같은 경우
            if(row + pos[row] == pos[i] + i) return false;
            // 우하향 대각선 : (x-1,y-1) (x,y) (x+1,y+1)
            // 해당 row와 col의 차가 같은 경우
            if(row - pos[row] == i - pos[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pos = new int[n]; // 각 인덱스는 행, value는 해당 행의 열
        nQueen(0);
        System.out.println(cnt);
    }
}
