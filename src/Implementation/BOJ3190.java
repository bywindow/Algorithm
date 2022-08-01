package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3190 {

    static int n, k, l;
    static int[][] map;
    static HashMap<Integer, Character> rotation = new HashMap<>();
    static Queue<int[]> dummy = new LinkedList<>();
    static int[] moveX = {1, 0, -1, 0};//동남서북
    static int[] moveY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2; // 사과 있는 곳은 2
        }
        l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++){
            st = new StringTokenizer(br.readLine());
            rotation.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }
        int answer = 0;
        int[] tail = {0,0};
        int[] head = {0,0};
        dummy.add(new int[] {tail[0], tail[1]}); //그냥 배열 전체를 추가하면 안된다. 이렇게 각 원소값을 add 해야 됨.
        map[head[0]][head[1]] = 1;
        int curRotation = 0;

        while(true) {
            answer++;
            head[0] += moveY[curRotation];
            head[1] += moveX[curRotation];
            //end point
            if(head[0] < 0 || head[0] >= n || head[1] < 0 || head[1] >= n || map[head[0]][head[1]] == 1) break;
            dummy.add(new int[]{head[0], head[1]});
            if(map[head[0]][head[1]] == 0){
                //is no apple? -> pop tail
                int[] t = dummy.poll();
                map[t[0]][t[1]] = 0;
            }
            map[head[0]][head[1]] = 1;
            if(rotation.containsKey(answer)){
                char value = rotation.get(answer);
                if(value == 'D'){
                    curRotation = (curRotation+1) % 4;
                } else {
                    curRotation = curRotation-1 < 0 ? 3 : curRotation-1;
                }
            }
        }
        System.out.println(answer);
    }
}
