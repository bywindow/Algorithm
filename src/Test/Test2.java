package Test;

public class Test2 {
    static void changeArr(int[] arr, int i) {
        arr[1] = 0;
        i = 5;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int i = 10;
        changeArr(arr, i);
        System.out.println(arr[1]);
        System.out.println(i);
    }
}
