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
            int number = sc.nextInt();

            if(number == 0) break;

            int reverse = 0;
            int origin = number;
            while(number > 0) { //if 1234
                int digit = number % 10; //digit = 4
                reverse = reverse * 10 + digit; //reverse = 4
                number /= 10; //num = 123
            }
            if(origin == reverse) System.out.println("yes");
            else System.out.println("no");
        }

    }
}
