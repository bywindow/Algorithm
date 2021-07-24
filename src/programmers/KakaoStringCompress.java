package programmers;

public class KakaoStringCompress {

    public static int solution(String s){
        int answer = s.length();
        for(int i = 1; i <= s.length(); i++) {
            int result = i;
            String temp = s.substring(0,i);
            int cnt = 1;
            for(int j = i; j < s.length(); j+=i){
                String curStr = "";
                if(j+i >= s.length()) curStr = s.substring(j);
                else curStr = s.substring(j, j+i);

                if(curStr.equals(temp)){
                    cnt++;
                    if(cnt==2) result += 1; //같은 문자열이 나오면 한번만 1 증가시키면 됨
                    else if(cnt==10) result += 1;
                    else if(cnt==100) result += 1;
                    else if(cnt==1000) result += 1;
                }
                else{
                    cnt = 1;
                    temp = curStr;
                    result += curStr.length();
                }
            }
            if(result < answer) answer = result;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

}
