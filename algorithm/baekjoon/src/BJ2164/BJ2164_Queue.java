package BJ2164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2164_Queue {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //queue는 인터페이스, queue기능으로만 사용할 것이고, linkedlist기반으로 동작하겠다!
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            //큐의 맨 뒤에 데이터 넣기, 꽉 차서 못넣으면 throw 발생
            q.add(i);
        }

        while(q.size() > 1) {
            //맨 앞 데이터를 꺼내서 제거
            q.poll();
            //맨 앞 데이터를 꺼내서(poll()) 뒤로 넣기(add())
            //poll()은 반환과 제거를 동시에 함
            //그렇기 때문에 변수처럼 리턴되는것.
            q.add(q.poll());
        }
        //맨 앞 데이터 꺼내기
        System.out.println(q.poll());
    }
}
