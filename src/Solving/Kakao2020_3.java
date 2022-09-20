package Solving;

public class Kakao2020_3 {

    int[] direction = {0, 1, 2, 3}; // up, down, left, right

    int[][] rotateClock(int[][] input) {
        int len = input.length;
        int[][] output = new int[len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                output[i][j] = input[len-1-j][i];
            }
        }
        return output;
    }

    int[][] move(int[][] input, int cnt, int dir) {
        if (cnt == 0) return input;
        int[][] output
        if (dir == 0) {

        } else if(dir == 1) {

        } else if(dir == 2) {

        } else {

        }
    }

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int m = key.length;
        int n = lock.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

            }
        }

        return answer;
    }

}
