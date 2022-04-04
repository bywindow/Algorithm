package DFS;
/*
2차원배열 글자판이 주어졌을 때 특정 문자열을 만들 수 있는지 확인한다.
좌우상하로만 이동할 수 있고 왔던 곳으로 되돌아가지 못한다.
 */

public class searchingWord {

    public static int index = 0;//input string에서 몇 번째 인덱스가 타겟인지 표시
    public static boolean output = false;
    public static int[][] visited;
    public static int count = 0;

    public static void dfs(int row, int col, String[][] board, String[] input, int idx){



        //움직이는 방향을 배열로 표시 {우,하,좌,상}
        int[] moveRow = {0,1,0,-1};
        int[] moveCol = {1,0,-1,0};
        //다 찾았으면 함수 종료
        if(idx >= input.length){
            count++;
            index = 0;
            return;
        }
        //move
        for(int i = 0; i < 4; i++){
            row += moveRow[i];
            col += moveCol[i];
            //이동 영역 제한 - 다음번 반복으로 이동
            if(col<0 || col >= board[0].length || row<0 || row>=board.length) {
                row -= moveRow[i];
                col -= moveCol[i];
                continue;
            }
            //이미 방문한 곳에 방문했다면
            if(visited[row][col] == 1) {
                row -= moveRow[i];
                col -= moveCol[i];
                continue;
            }
            //같은 글자가 나왔다면
            if(board[row][col].equals(input[index])){
                visited[row][col] = 1;
                index++;
                dfs(row, col, board, input, index);
                visited[row][col] = 0;//백트레킹
            }
            //같은 것을 못 찾았을 때(위 if문에 하나도 해당이 안될 때) 이동한만큼을 다시 빼주어야한다(이것때문에 계속 오류가 났었다)
            else{
                row -= moveRow[i];
                col -= moveCol[i];
            }
        }
    }

    public static boolean solution(String[][] board, String[] input){

        visited = new int[board.length][board[0].length];//방문여부를 기록

        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[i].length;j++){
                //input의 첫 글자와 같은 글자를 찾아서
                if(index >= input.length) break;
                if(board[i][j].equals(input[index])){
                    visited[i][j] = 1;//방문했다고 기록하고
                    index++;
                    dfs(i, j, board, input, index);//dfs 함수 호출
                }
                index = 0;
            }
        }
        if(count>0) output = true;

        return output;
    }

    public static void main(String[] args) {

       String[][] board = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
       String input = "ABCB";
       String[] arr_input = input.split("");

       System.out.println(solution(board, arr_input));
    }
}
