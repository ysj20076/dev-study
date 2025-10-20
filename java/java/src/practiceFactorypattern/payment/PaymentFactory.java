package practiceFactorypattern.payment;

public class PaymentFactory {
    Payment createPayment(String type) {
        if(type.equalsIgnoreCase("card")) {
            return new CardPayment();
        }
        else if(type.equalsIgnoreCase("kakao")) {
            return new KakaoPayment();
        }

        else if(type.equalsIgnoreCase("bank")) {
            return new BankTransferPayment();
        }
        else {
            throw new IllegalArgumentException("결제방식이 잘못되었습니다.");
        }
    }
}
