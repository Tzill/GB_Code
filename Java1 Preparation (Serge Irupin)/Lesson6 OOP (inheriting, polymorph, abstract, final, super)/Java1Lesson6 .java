class Java1Lesson6 {
    public static void main(String[] args) {
        IAnimal[] animals = {new Cat("Barsik", "white", 3),
                new Dog("Zuchka", "black", 5)};
        for (IAnimal animal : animals)
            System.out.println(animal + " say " + animal.voice());
    }
}

class Cat extends Animal {
    Cat(String name, String color, int age) {
        super(name, color, age);
    }
    @Override
    public String voice() {
        return "meow!";
    }
}

class Dog extends Animal {
    Dog(String name, String color, int age) {
        super(name, color, age);
    }
    @Override
    public String voice() {
        return "gav-gav!";
    }
}

interface IAnimal {
    String voice();
}

abstract class Animal implements IAnimal {
    protected String name;
    protected String color;
    protected int age;

    Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.getClass().getName() +
            " {name=" +  name + ", color=" + color + ", age=" + age + "}";
    }
}