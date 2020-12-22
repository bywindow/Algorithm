
/*
n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.
다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.
 */
package Bootcamp;
import java.util.ArrayList;

public class connectIsland {

    static boolean[] visited;

    public static int soulution(int n, int[][] costs){

        int answer = 0;
        //최대 섬의 개수가 100개이고, 최대 경로의 길이는 (n-1)*n/2이므로 최소경로합이 500000보다 클 수 없다.
        int curCost = 500000;
        visited = new boolean[n];
        //row와 col을 각 섬으로 하고 각 인덱스는 두 섬의 경로값을 가지는 매트릭스를 생성한다.
        int[][] cost_mat = new int[n][n];
        for(int i = 0; i < costs.length; i++){
            cost_mat[costs[i][0]][costs[i][1]] = costs[i][2];
            cost_mat[costs[i][1]][costs[i][0]] = costs[i][2];
        }
        //연결된 섬을 리스트로 나타낸다
        ArrayList<Integer> path = new ArrayList<>();
        //섬은 2개 이상이므로 '0'은 반드시 섬의 인자 중 하나이다
        path.add(0);
        visited[0] = true;
        while(path.size() < n) {
            int min = 5000;//경로 하나의 최대 길이
            int idx = 0;
            for (int i = 0; i < path.size(); i++) {
                int cur = path.get(i);
                //섬 cur 과 연결된 것 중 경로값이 가장 작은 것을 뽑는다
                for (int j = 0; j < n; j++) {
                    if(!visited[j] && cost_mat[cur][j] > 0 && cost_mat[cur][j] < min && cur != j){
                        idx = j;
                        min = cost_mat[cur][j];
                    }
                }
            }
            visited[idx] = true;
            path.add(min);
            answer += min;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] input = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
        System.out.println(soulution(n, input));
    }
}
