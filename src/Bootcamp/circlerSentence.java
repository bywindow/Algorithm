//회문은 앞으로, 뒤로 읽어도 같은 글자를 의미합니다.
//문자열을 입력하여 최대 한 문자를 삭제 할 수 있을 때 회문으로 만들 수 있는지 판단 하시오.
package Bootcamp;

public class circlerSentence {
    public static boolean solution(String str){

        boolean answer = true;
        int l = str.length()-1;
        int cnt = 0;
        for(int i = 0; i < str.length()/2; i++,l--){
            if(str.charAt(i)!=str.charAt(l)) {
                System.out.println(str.charAt(i)+str.charAt(l));
                cnt++;
                if(str.charAt(i+1)==str.charAt(l)){
                   i+=1;
                }
                else if(str.charAt(i)==str.charAt(l-1)){
                   l-=1;
                }
                else{
                    answer = false;
                    break;
                }
            }
            if(cnt==2){
                answer = false;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String str = "abcdefsggferdcba";
        System.out.println(solution(str));
    }
}
