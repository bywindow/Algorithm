package TopologicalSort;

import java.io.*;
import java.util.*;

/**
 * 위상정렬로 푼다
 */
class Main2252{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 노드끼리의 순서를 정의하기 위해 2차원 리스트 활용
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n+1; i++){
            graph.add(new ArrayList<>());
        }

        // 각 노드별로 몇 개의 노드가 선행되어야 하는지 나타내는 배열
        int[] inDegree = new int[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end); // 시작 노드에 연결된 노드 삽입
            inDegree[end]++; // 끝 지점 노드의 인접 노드 개수 1 추가
        }

        Queue<Integer> q = new LinkedList<>(); // 위상정렬에 활용할 큐
        for(int i = 1; i < inDegree.length; i++){
            if (inDegree[i] == 0) q.add(i); // 인접한 노드가 없는 경우 먼저 큐에 삽입
        }
        ArrayList<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            int cur = q.poll();
            result.add(cur);
            // 인접한 노드의 indegree 1 감소
            for(int i = 0; i < graph.get(cur).size(); i++){
                inDegree[graph.get(cur).get(i)]--;
                if (inDegree[graph.get(cur).get(i)] < 1){
                    q.add(graph.get(cur).get(i));
                }
            }
        }

        for(int i : result){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}