import java.util.Scanner;
public class BJ10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String reverse = new StringBuilder(str).reverse().toString();

        if(str.equals(reverse)) System.out.println(1);
        else System.out.println(0);
    }
}
