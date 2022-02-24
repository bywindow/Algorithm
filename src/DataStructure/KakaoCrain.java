package DataStructure;

import java.util.ArrayList;
import java.util.List;

public class KakaoCrain {
    public static  int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer>store = new ArrayList<>();//크레인으로 건져올린 인형들이 저장되는 배열
        //moves[i]의 값에 해당하는 board[*][i]를 찾아서 그 값을 store에 저장한다.
        for(int i = 0 ; i < moves.length;i++){
            int col = moves[i]-1;
            for(int j = 0; j < board[col].length; j++){
                if(board[j][col]!=0){
                    store.add(board[j][col]);
                    board[j][col] = 0;
                    break;
                }
            }
            //store[]에 같은 것이 두번연속해서 쌓이면 PANG
            if(store.size() >= 2) {
                if (store.get(store.size()-2) == store.get(store.size()-1)) {
                    store.remove(store.size()-1);
                    store.remove(store.size()-1);
                    answer+=2;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] b = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] m = {1,5,3,5,1,2,1,4};


        System.out.println(solution(b, m));
    }
}

//다른 사람 풀이
//import java.util.Stack;
//
//class Solution {
//    public int solution(int[][] board, int[] moves) {
//        int answer = 0;
//        Stack<Integer> stack = new Stack<>();
//        for (int move : moves) {
//            for (int j = 0; j < board.length; j++) {
//                if (board[j][move - 1] != 0) {
//                    if (stack.isEmpty()) {
//                        stack.push(board[j][move - 1]);
//                        board[j][move - 1] = 0;
//                        break;
//                    }
//                    if (board[j][move - 1] == stack.peek()) {
//                        stack.pop();
//                        answer += 2;
//                    } else
//                        stack.push(board[j][move - 1]);
//                    board[j][move - 1] = 0;
//                    break;
//                }
//            }
//        }
//        return answer;
//    }
//}
