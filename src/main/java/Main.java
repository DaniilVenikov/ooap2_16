import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new ZooBird();

        List<Animal> list = new ArrayList<>();
        list.add(new Bird());
        list.add(new Dog());

        zoo.covariantMethod(list);
        zoo.polymorphicMethod(new Bird());
    }
}

class Animal {
    public void method() {
        System.out.println("Animal");
    }
}


class Bird extends Animal {
    @Override
    public void method() {
        System.out.println("Bird");
    }
}

class Dog extends Animal {
    @Override
    public void method() {
        System.out.println("Dog");
    }
}

class Zoo {
    public <T extends Animal> void covariantMethod(List<T> animals) {
        for(T animal : animals) {
            System.out.println(animal.toString());
        }
    }

    public void polymorphicMethod(Animal animal) {
        animal.method();
    }

    Animal getAnimal() {
        System.out.println("Get animal");
        return new Animal();
    }
}

class ZooBird extends Zoo {
    @Override
    public <T extends Animal> void covariantMethod(List<T> animals) {
            super.covariantMethod(animals);
            System.out.println(animals.size());
    }

    @Override
    public void polymorphicMethod(Animal animal) {
        animal.method();
    }

    @Override
    Bird getAnimal() {
        System.out.println("Get animal");
        return new Bird();
    }
}

