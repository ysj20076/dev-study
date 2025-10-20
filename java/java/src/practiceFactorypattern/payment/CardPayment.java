package practiceFactorypattern.payment;

public class CardPayment implements Payment {
    public void pay(int amount) {
        System.out.println("카드로 결제합니다. 금액 : " + amount + "원");
    }
}

class KakaoPayment implements Payment {
    public void pay(int amount) {
        System.out.println("카카오페이로 결제합니다. 금액 : " + amount + "원");
    }
}

class BankTransferPayment implements Payment {
    public void pay(int amount) {
        System.out.println("계좌이체로 결제합니다. 금액 : " + amount + "원");

    }
}