package Bootcamp;

import java.util.Scanner;

public class Test {

      public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            seasonCheck(a);
            int auth = 0;

            
      }

      static void seasonCheck(int month){

            switch(month){
                  case 3:
                  case 4:
                  case 5:
                        System.out.println("Spring!");
                        break;
                  case 6: case 7: case 8:
                        System.out.println("Summer!");
                        break;
                  case 9: case 10: case 11:
                        System.out.println("Fall!");
                        break;
                  default:
                        System.out.println("Winter!");
            }
      }


}
