import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Bird();
        List<Bird> list = new ArrayList<>();
        list.add(new Bird());

        animal.someMethod(list);
    }
}

class Animal {
    public <T extends Animal> void someMethod(List<T> list) {
        System.out.printf("This animal list %s", list.toString());
    }
}


class Bird extends Animal {
    @Override
    public <T extends Animal> void someMethod(List<T> list) {
        System.out.printf("This bird list %s", list.toString());
    }
}

