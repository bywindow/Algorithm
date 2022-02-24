package DataStructure;

/**
 * comparator 사용하는 방법 : 시간초과 -> 출력 부분 이중for문 사용 안 하니까 해결됨
 */

import java.util.*;
import java.io.*;

public class BOJ11650 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] pos = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                pos[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(pos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
        for(int[] i : pos){
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
