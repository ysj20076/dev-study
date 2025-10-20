package practiceFactorypattern.animal;

public class AnimalTest {
    public static void main(String[] args) {
        Animal animal1 = AnimalFactory.createAnimal("dog");
        Animal animal2 = AnimalFactory.createAnimal("cat");

        animal1.sound();
        animal2.sound();
    }
}

