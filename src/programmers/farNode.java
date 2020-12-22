//BFS 탐색 : 특정위치를 기준으로 인접한 노드를 모두 방문하며 한 번 방문했던 노드는 방문 이력을 저장해가면서 다음 노드, 다음노드로 넘어가 전체를 검색하는 방법입니다.
//참고 : https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html 
package codingtr;
import java.util.LinkedList;
import java.util.Queue;

public class farNode {
    public static int solution(int n, int[][] edge) {
        //배열은 선언만 해줄 때 0으로 초기화되어있음
        int[] dist = new int[n+1];//크기 n+1의 배열을 선언하여 1번 노드부터 각 노드까지 갈 수 있는 최소거리를 입력
        boolean [][] graph = new boolean[n+1][n+1];//노드가 연결되어있는지 판단하는 배열
        for(int i = 0; i < edge.length; i++){
            graph[edge[i][0]][edge[i][1]] = graph[edge[i][1]][edge[i][0]] = true;//간선이 양방향이 되도록 배열에 입력
        }
        //인접한 노드를 먼저 모두 확인해야되기때문에 인접한 노드를 모두 큐에 넣고, 모두 큐에 넣었을 때 꺼내면서 방문여부를 기록
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(1);

        //BFS
        int maxDist = 0;
        while(!nodes.isEmpty()){ //큐가 소진될 때까지 반복
            int i = nodes.poll();//큐에 저장된 값을 꺼내올 때 쓰는 메서드(FIFO)
            for(int j = 2; j <= n ; j++){
                if(dist[j] == 0 && graph[i][j]){//j번째 노드에 방문하지 않았고 간선이 있는 경우
                    dist[j] = dist[i] + 1;//j노드의 거리는 이전 노드인 i노드의 거리에서 +1
                    nodes.add(j);
                    maxDist = Math.max(maxDist, dist[j]);     
                }
            }
        }

        int answer = 0; //가장 멀리 있는 노드의 갯수
        //향상된 for문 --> 배열의 각 요소에 접근하여 d에 저장함
        for(int d : dist){
            if(maxDist == d) answer++;
        }
        return answer;
    }
       // 아래는 테스트로 출력해 보기 위한 코드입니다.
       public static void main(String[] args) {
        
        int n = 6;
        
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, edge));
    }
}


 