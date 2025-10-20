package practiceFactorypattern.animal;

public class AnimalFactory {
    public static Animal createAnimal(String type) {
        if(type.equalsIgnoreCase("dog")) {
            return new Dog();
        }
        else if(type.equalsIgnoreCase("cat")) {
            return new Cat();
        }
        else {
            throw new IllegalArgumentException("동물 타입이 다릅니다.");
        }
    }
}
