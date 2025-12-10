import java.util.*;
import java.io.*;

public class BJ9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] first = new String[T];
        char[][] charArr = new char[T][]; //동적으로 행만 먼저 생성성

        //1. T번 반복하며 입력받기기
        for (int i = 0; i < T; i++) {
            first[i] = br.readLine();
            //char배열로 변환, 한행에!
            //개별문자에 접근하려면 charArr[][]로
            charArr[i] = first[i].toCharArray();
        }

        //2. 개별문자 접근하며 플래그 세우기
        //마지막 결과가 0이면 yes, 1이면 no
        //  ( = +1,    ) = -1
        //맨처음 )이 나오면 false


        for(int i = 0; i < T; i++) {
            int count = 0;
            boolean flag = true;
            for(int j = 0; j < charArr[i].length; j++) {
                if(charArr[i][j] == '(') count++;
                else if(charArr[i][j] == ')') count--;
                if(count < 0) {
                    flag = false;
                    break;
                }

            }
            if(count == 0 && flag == true) System.out.println("Yes");
            else System.out.println("No");
        }

    }
}
