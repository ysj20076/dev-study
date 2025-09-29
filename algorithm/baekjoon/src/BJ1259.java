import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
//StringBuilder클래스의 reverse() 사용
public class BJ1259 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
                String number = br.readLine();
                //Stringbuilder : 가변 문자열 클래스
                //number를 넣어서 객체하나 생성, 그 객체의 버퍼 뒤집기(reverse())
                if(number.equals("0")) break;

                String reverse = new StringBuilder(number).reverse().toString();
                if(number.equals(reverse)) System.out.println("yes");
                else System.out.println("no");

            }

    }
}

//자리바꾸는 공식 사용
class Main {
    public static void main(String[] args) throws IOException {
        while(true) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();//1234

            if(n == 0) break;

            int origin = n; //1234
            int reverse = 0;

            while(n > 0) {
                reverse = reverse * 10 + (n%10); //4
                n = n / 10; //123
            }

            if(origin == reverse) System.out.println("yes");
            else System.out.println("no");

        }

    }
}
