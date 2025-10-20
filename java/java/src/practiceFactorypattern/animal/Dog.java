package practiceFactorypattern.animal;

interface Animal {
    void sound();
}

public class Dog implements Animal {
    public void sound() {
        System.out.println("bowwow");
    };
}


class Cat implements Animal {
    public void sound() {
        System.out.println("meow");
    };
}