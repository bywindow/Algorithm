package Test;

import java.util.*;

class Vinu1{
    public static void main(String[] args) {
        String[] arr = {"sss", "sss", "ssa", "ssa", "ssa", "sss", "sss"};
        System.out.println(Vinu1.solution(arr));
    }

    public static String[] solution(String[] movie) {

        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < movie.length; i++){
            if(hm.containsKey(movie[i])){
                hm.replace(movie[i], hm.get(movie[i])+1);
            }
            else{
                hm.put(movie[i], 1);
            }
        }
        List<String> keys = new ArrayList<>(hm.keySet());
        keys.sort((o1, o2) -> {
            if(hm.get(o1) == hm.get(o2)){
              return o1.compareTo(o2);
            }
            else {
                return hm.get(o2) - hm.get(o1);
            }
        });
        String[] ans = new String[keys.size()];
        for(int i = 0; i < keys.size(); i++){
            ans[i] = keys.get(i);
        }
        return ans;
    }
}

class Vinu2{
    public static void main(String[] args) {
        System.out.println();
    }

    public int solution(String phone_number) {
        int answer = -1;
        if(phone_number.length() != 13 && phone_number.length() != 11 && phone_number.length() != 16) return -1;
        String[] arr = phone_number.split("-");
        if(arr.length == 1){
            if(arr[0].contains("+")) return -1;
            if(arr[0].length() == 11){
                answer = 2;
            } else {
                return -1;
            }
        } else if (arr.length == 3) {
            if(arr[0].contains("+") || arr[1].contains("+") || arr[2].contains("+")) return -1;
            if(arr[0].length() == 3 && arr[1].length() == 4 && arr[2].length() == 4){
                answer = 1;
            } else {
                return -1;
            }
        } else if (arr.length == 4) {
            if(!arr[0].equals("+82")) return -1;
            if(arr[1].contains("+") || arr[2].contains("+") || arr[3].contains("+")) return -1;
            if(arr[1].length() == 2 && arr[2].length() == 4 && arr[3].length() == 4) {
                answer = 3;
            }
            else {
                return -1;
            }
        }
        return answer;
    }
}

class Vinu3{
    public static void main(String[] args) {
        System.out.println();
    }

    public int solution(int[][] p) {
        int answer = 0;
        int[][] board = new int[1001][1001];
        for(int i = 0; i < p.length; i++){
            board[p[i][0]][p[i][1]]++;
            board[p[i][1]][p[i][0]]++;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j <= i; j++){
                if(board[i][j] == 2) answer++;
            }
        }
        return answer;
    }
}

class Vinu4{
    public static void main(String[] args) {
        System.out.println();
    }

    public int solution(int[] estimates, int k) {
        int answer = 0;
        for(int i = 0; i < k; i++){
            answer += estimates[i];
        }
        int prev = answer;
        for(int i = 1; i+k <= estimates.length; i++){
            int cur = prev - estimates[i-1] + estimates[i+k-1];
            answer = Math.max(answer, cur);
            prev = cur;
        }
        return answer;
    }
}