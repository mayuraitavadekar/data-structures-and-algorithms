public class DynamicPolymorphism {

    public static void main(String[] args) {
        Animal animal1 = new Animal();
        animal1.eat();

        Animal animal2 = new Dog();
        animal2.eat();

        // Dog dog = new Animal(); NOT ALLOWED
    }
}

class Animal {

    public void eat() {
        System.out.println("Animal is eating.");
    }

}

class Dog extends Animal {
    public void eat() {
        System.out.println("Dog is eating.");
    }
}

// Dyanamic Polymorphism - Compile time polymorphism - Method overriding

// reference varibale of base class can point to object child class (upcasting)
// reference varibale of base class can point to object of parent class
// reference variable of child class cannot point to object of base class