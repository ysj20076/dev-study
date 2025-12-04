package BJ10828;

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class BJ10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. N 입력받기
        int N = Integer.parseInt(br.readLine());

        //N 크기의 stack 배열 생성
        int stack[] = new int[N];
        int size = 0;

        //N만큼 반복하며 수행
        for(int i = 0; i < N; i++) {
            //공백을 기준으로 토큰 끊기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            //첫번째 토큰 command에 저장
            String command = st.nextToken();

            switch (command) {

                case "push":
                    //두번째 토큰 X에 저장
                    int X = Integer.parseInt(st.nextToken());
                    stack[size++] = X;
                    break;
                case "pop":
                    if(size == 0) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(stack[--size]);
                    }
                    break;
                case "size":
                    System.out.println(size);
                    break;
                case "empty":
                    if(size == 0) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "top":
                    if(size != 0) System.out.println(stack[size-1]);
                    else System.out.println(-1);
                    break;
            }

        }

    }
}