package Solving;

import java.util.Arrays;

public class Line_3 {

    public static int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        int[] offices = new int[num_teams+1];
        for(int i = 0; i < employees.length; i++){
            String cur = employees[i];
            boolean isRemote = true;
            for(int j = 0; j < office_tasks.length; j++){
                if(cur.indexOf(office_tasks[j]) > 0){
                    isRemote = false;
                    break;
                }
            }
            int curTeam = cur.charAt(0) - '0';
            if(offices[curTeam] == 0 || !isRemote) offices[curTeam] = i+1;
        }
        Arrays.sort(offices);
        int[] answer = new int[employees.length - num_teams];
        int cnt = 0;
        int cntOffice = 1;
        for(int i = 1; i <= employees.length; i++){
            if(cntOffice < offices.length){
                if(offices[cntOffice] == i){
                    cntOffice++;
                    continue;
                }
            }
            answer[cnt] = i;
            cnt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] s = {"design"};
        String[] s1 = {"building","supervise"};
        String[] s3 = {"2 design","1 supervise building design","1 design","2 design"};
        int[] answer = solution(n, s, s1, s3);
    }
}

