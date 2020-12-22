
package Bootcamp;

public class moveZero {
    public static void main(String[] args) {
        int input[] = {0,1,0,4,3,12};
        for(int i = 0; i < input.length-1;i++){
            if(input[i] == 0){
                for(int j = i+1; j < input.length;j++){
                    input[j-1] = input[j];
                }
                input[input.length-1] = 0;
            }
        }
        for(int i : input){
            System.out.print(i + " ");
        }
    }
}
