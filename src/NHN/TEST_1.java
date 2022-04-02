package NHN;

class TEST_1 {
    public int solution(String[] logs) {
        int answer = 0;
        String[] taem = {"team_name", "application_name", "error_level", "message"};
        for(int i = 0; i < logs.length; i++){
            String curLog = logs[i];
            if(curLog.length() > 100){
                answer++;
                continue;
            }
            String[] spl = curLog.split(" : ");
            if(spl.length != 5){
                answer++;
                continue;
            }
            if(spl[0] != taem[0]){
                answer++;
                continue;
            }
            for(int j = 0; j < spl[4].length(); j++){
                char cur = spl[4].charAt(j);
                if(cur - 'A' < 0 || 'z' - cur < 0){
                    answer++;
                    continue;
                }
            }
            for(int j = 1; j < spl.length-1; j++){
                String[] next = spl[j].split(" ");
                // 공백이 있을 때
                if(next.length != 2){
                    answer++;
                    break;
                }
                if(!next[1].equals(taem[j])){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        char ch = ' ';
        System.out.println((int) 'A' + " " + (int) 'a' + " " + (int) ' ');
    }
}
