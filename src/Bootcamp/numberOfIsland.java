package Bootcamp;

import java.util.ArrayList;

/*
[“1”, “1”, “0”, “0”, “0”],
[“1”, “1”, “0”, “0”, “0”],
[“0”, “0”, “1”, “0”, “0”],
[“0”, “0”, “0”, “1”, “1”]
이 경우에는 섬이 3개입니다.
이러한 배열이 있을때 1을 제외 하고는 모두 바다입니다.
이때 섬의 개수를 찾으십시오.(단 괄호는 모두 바다로 생각해도 좋습니다.)

1. Union-Find Algorithm
-섬인 것 끼리 하나의 집합으로 묶는다
-깊이가 2인 트리를 구현-->하나의 트리고 하나의 섬이다
-트리의 개수를 세면 섬의 갯수가 된다
 */
public class numberOfIsland {

    //private static boolean[] visited;

    public static int findIsland(int[][] input){
        ArrayList<Integer> input_list = new ArrayList<>();
        boolean[] visited = new boolean[input_list.size()];
        int cnt_island = 0;
        //입력된 수의 개수만큼 일차원배열을 다시 만든다
       for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input[i].length;j++){

            }
       }
//        for(int i = 0; i < input_list.size(); ){
//            if()
//        }

        return cnt_island;
    }

//    public static void dfs(int node) {
//        if(visited[node]) return;
//        else{
//            visited[node] = true;
//        }
//    }

    public static void main(String[] args) {

    }
}
