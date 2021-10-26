package NHN;

import java.io.IOException;

public class TEST_1 {

    public static void solution(int op, String[][] input){
        int[] tree = new int[100001];
        tree[1] = 1;
        for(int i = 0; i < op; i++){
            if(input[i][0].equals("branch")){
                for(int j = 1; j < tree.length; j++){
                    if(tree[j] == 0) {
                        tree[j] = 1;
                        break;
                    }
                }
            }
            else{
                tree[Integer.parseInt(input[i][1])] = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < tree.length; i++){
            if(tree[i] != 0) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {

    }
}
