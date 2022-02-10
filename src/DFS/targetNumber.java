package DFS;
/*
가장 처음의 합은 0에서 출발 -> 배열의 0번째 인덱스부터 접근하면서 그 값을 더하는 경우와 빼는 경우를 dfs로 구현
 */
public class targetNumber {


    public static int dfs(int[] input, int m, int target, int index){
        if(index >= input.length){
            //return m == target ? 1 : 0;
            if(m == target){
                return 1;
            }
            else return 0;
        }
        else{
            //트리처럼 나눠지고 최종 Leaf에서 조건을 만족하는 경우 1을 리턴하므로 그 1을 모두 더하면 된다
            return dfs(input, m+input[index], target, index+1) + dfs(input, m-input[index], target, index+1);
        }
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        answer = dfs(numbers, 0, target, 0);

        return answer;
    }

    public static void main(String[] args) {

        int[] input = {1,1,1,1,1};
        int target = 3;

        System.out.println(solution(input, target));

    }
}
