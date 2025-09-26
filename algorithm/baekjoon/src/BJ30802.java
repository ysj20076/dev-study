//백준 30802번 문제
import java.util.Scanner;
import java.util.Arrays;
public class BJ30802
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //참가자 N명
        int[] sizeApply = new int[6]; //사이즈별 신청자수 입력
        for(int i = 0; i < sizeApply.length; i++) {
            sizeApply[i] = sc.nextInt(); //공백으로 구분
        }
        int T = sc.nextInt(); //티셔츠 T장씩 묶음
        int P = sc.nextInt(); //펜 P자루씩 묶음

        //티셔츠 몇묶음?
        int tCount = 0;
        for(int n : sizeApply) {
            tCount += (n + T - 1) / T;
        }


        //펜 몇묶음, 몇자루씩?
        int quot = N / P;
        int remain = N % P;

        System.out.println(tCount);
        System.out.print(quot + " " + remain);


    }
}
