//package Baekjoon;
//
///**
// * @Date : 2021-04-11
// * @Title : 다리 놓기
// * @Desc : 강의 서쪽에는 n개의 사이트, 동쪽에는 m개의 사이트가 있다(n <= m)
// *         n개의 다리를 짓는다고 할 때, 다리끼리 서로 겹칠 수 없게 다리를 짓는 방법
// */
//import java.util.*;
//import java.io.*;
//
//public class BOJ1010 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int t = Integer.parseInt(st.nextToken()); //테스트케이스의 개수
//        int[] n = new int[t]; //서쪽의 사이트 개수
//        int[] m = new int[t]; //동쪽의 사이트 개수
//        long answer = 1;
//
//        for(int i = 0; i < t; i++){
//            st = new StringTokenizer(br.readLine());
//            n[i] = Integer.parseInt(st.nextToken());
//            m[i] = Integer.parseInt(st.nextToken());
//        }
//        /**
//         * Combination
//         * mCn = m! / (n! * (m-n)!)
//         * 분자에서 곱해지는 수의 개수 == 분모에서 곱해지는 수의 개수 == n[i]
//         */
//        for(int i = 0; i < t; i++){
//            if(m[i] == n[i]){
//                System.out.println(1);
//                continue;
//            }
//            int cnt = 1;
//            while(cnt < n[i] + 1) {
//                answer = answer * m[i] / cnt;
//                cnt++;
//                m[i]--;
//            }
//            System.out.println(answer);
//            answer = 1;
//        }
//    }
//}

package Baekjoon;

/**
 * @Date : 2021-04-11
 * @Title : 다리 놓기
 * @Desc : 강의 서쪽에는 n개의 사이트, 동쪽에는 m개의 사이트가 있다(n <= m)
 *         n개의 다리를 짓는다고 할 때, 다리끼리 서로 겹칠 수 없게 다리를 짓는 방법
 */
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class BOJ1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken()); //테스트케이스의 개수
        int[] n = new int[t]; //서쪽의 사이트 개수
        int[] m = new int[t]; //동쪽의 사이트 개수
        BigInteger answer;

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            n[i] = Integer.parseInt(st.nextToken());
            m[i] = Integer.parseInt(st.nextToken());
        }
        /**
         * Combination
         */
        int cnt = 0;
        BigInteger one = new BigInteger("1");

        while(cnt < t) {
            if(m[cnt] == n[cnt]) {
                System.out.println(1);
                cnt++;
                continue;
            }
            BigInteger a = new BigInteger(String.valueOf(m[cnt]));
            BigInteger b = new BigInteger(String.valueOf(n[cnt]));

            BigInteger result_a = new BigInteger("1"); // 분자
            int cnt_a = 0;
            while(cnt_a < n[cnt]) {
                result_a = result_a.multiply(a);
                a = a.subtract(one);
                cnt_a++;
            }
            BigInteger result_b = new BigInteger("1"); // 분모

            while(n[cnt] > 0) {
                result_b = result_b.multiply(b);
                b = b.subtract(one);
                n[cnt]--;
            }
            //System.out.println(result_a + " , " + result_b);
            answer = result_a.divide(result_b);
            System.out.println(answer);
            cnt++;
        }
    }
}
