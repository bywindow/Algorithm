package Bootcamp;

import java.util.ArrayList;
import java.util.Arrays;


public class minCostPath {

    static int[][] paths;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void combination(int[] path, boolean[] v, int start, int size, int n){

        if(n==0){
            for(int i = 0; i < size; i++){
                if(visited[i]) {
                    list.add(path[i]);
                }
            }
            return;
        }

        for(int i = start; i < size; i++){
            visited[i] = true;
            combination(path, v,i+1,size,n-1);
            visited[i] = false;
        }

    }
    public static int soulution(int[][] input){
        int row = input.length-1;
        int col = input[0].length-1;
        visited = new boolean[row*col];
        int p = 1;
        for(int i = 1; i < row * col + 1; i++){
            p = p * i;
        }
        paths = new int[p/(row*col)][row];
        //0 == move to Right, 1 == move to Down
        int[] moveRow = {0,1};
        int[] moveCol = {1,0};
        //오른쪽 또는 아래 방향으로 각각 몇 번씩 이동할 수 있는지 기록

        int[] arr_path = new int[row+col];//{0,1,2,3}
        for(int i = 0; i < arr_path.length; i++){
            arr_path[i] = i;
        }

        //아래로 이동하는 경우만 골라낸다
        combination(arr_path, visited, 0, arr_path.length, row);

        for(int i = 0,j = 0; i < list.size(); ) {
            for(int y = 0; y < row; y++){
                paths[j][y] = list.get(list.size()-1);
                list.remove(list.size()-1);
            }
            j++;
        }

        int output = input[0][0];
        int curRow = 0;
        int curCol = 0;
        int minOutput = 0;
        for(int i : input[0]){
            minOutput += i;
        }
        for(int i = 0; i < input.length; i++){
            minOutput += input[i][input.length-1];
        }

        for(int i =0; i < paths.length; i++){
            Arrays.sort(paths[i]);
            int k = 0;
            for(int j = 0; j < row + col; j++){
                if(j == paths[i][k]){
                    curRow++;
                    k++;
                    output += input[curRow][curCol];
                    if(k==row) k = row-1;
                }
                else{
                    curCol++;
                    output += input[curRow][curCol];
                }
            }
            minOutput = Math.min(minOutput, output);
            curCol = 0;
            curRow = 0;
        }
        return minOutput;
    }

    public static void main(String[] args) {

        int[][] input = {{1,3,1},{1,5,1}, {4,2,1}};
        System.out.println(soulution(input));
    }
}