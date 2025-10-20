package practiceFactorypattern.payment;

import java.util.Scanner;

public class PaymentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("결제 수단 입력 : ");
        String str = sc.next();

        System.out.print("결제 금액 입력 : ");
        int amount = sc.nextInt();

        PaymentFactory factory = new PaymentFactory();

        try {
            Payment payment = factory.createPayment(str);
            payment.pay(amount);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
