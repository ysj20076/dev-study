package BJ2164;

import java.io.*;
import java.lang.*;

public class BJ2164
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //1. card[N]에 1~N만큼 채우기기
        int card[] = new int[2 * N];
        //처음 인덱스 가르킬 변수
        int front = 0;
        //마지막 인덱스 가르킬 변수
        int back = N - 1;

        for(int i = 0; i < N; i++) {
            card[i] = i + 1;
        }

        while(front < back) {
            //2. 맨 위 버림
            front++;
            //3. 그 다음 카드 맨 뒤로 복사사
            card[++back] = card[front];
            front++;
        }

        System.out.println(card[front]);

    }
}
