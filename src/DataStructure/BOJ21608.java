package DataStructure;

import java.io.*;
import java.util.*;

public class BOJ21608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int student = n * n; //학생 수
        //좋아하는 학생에 포함되는지 쉽게 파악하기 위해서 Set 사용
        ArrayList<Set<Integer>> like = new ArrayList<>();
        for(int i = 0; i < student+1; i++){
            like.add(new HashSet<>());
        }
        int[] orders = new int[student];
        StringTokenizer st;
        for(int i = 0; i < student; i++){
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            orders[i] = cur;
            for(int j = 0; j < 4; j++){
                like.get(cur).add(Integer.parseInt(st.nextToken()));
            }
        }
        ////인접한 칸
        int[] moveX = {-1, 0, 1, 0};
        int[] moveY = {0, -1, 0, 1};
        int[][] seat = new int[n][n];
        int sx=0, sy=0, maxW, weight=0;
        for(int s = 0; s < orders.length; s++){
            maxW = -1;
            //[0][0]부터 각 자리마다 탐색하면서 해당 자리에 대한 가중치를 매기고, 위치를 저장한다
            for(int i = 0; i < seat.length; i++){
                for(int j = 0; j < seat[i].length; j++){
                    //해당 자리에 이미 학생이 앉아있다면 패스
                    if(seat[i][j] != 0) continue;
                    //인접한 곳을 탐색하면서 가중치를 매긴다
                    weight = 0;
                    for(int k = 0; k < 4; k++){
                        int curX = j + moveX[k];
                        int curY = i + moveY[k];
                        if(isSeat(curX, curY, n)){
                            //인접한 곳에 좋아하는 학생이 있으면 +10 (1순위)
                            if(like.get(orders[s]).contains(seat[curY][curX])) weight+=10;
                            //비어있는 곳이라면 +1 (2순위)
                            else if(seat[curY][curX] == 0) weight+=1;
                        }
                    }
                    //해당 자리에 대한 가중치
                    if(weight > maxW){
                        sx = j;
                        sy = i;
                        maxW = weight;
                    }
                }
            }
            //학생의 자리 결정
            seat[sy][sx] = orders[s];
        }
        int answer = 0;
        for(int i = 0; i < seat.length; i++){
            for(int j = 0; j < seat[i].length; j++){
                int cnt = 0;
                for(int k = 0; k < 4; k++){
                    int curX = j + moveX[k];
                    int curY = i + moveY[k];
                    if(isSeat(curX, curY, n) && like.get(seat[i][j]).contains(seat[curY][curX])) cnt+=1;
                }
                if(cnt == 0) continue;
                answer += Math.pow(10, cnt-1);
            }
        }
        System.out.println(answer);
    }

    //자리 범위 안에 속하는지 확인
    public static boolean isSeat(int x, int y, int n){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
