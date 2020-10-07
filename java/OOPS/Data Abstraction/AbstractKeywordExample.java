public class AbstractKeywordExample {
    public static void main(String[] args) {

        Animal animal = new Dog(); // upcasting

        animal.bark();
        animal.eat();
        animal.run();

    }
}

abstract class Animal {

    abstract public void run();

    abstract public void eat();

    public void bark() {
        System.out.println("dog is barking");
    };
}

class Dog extends Animal {

    @Override
    public void run() {
        System.out.println("dog is eating.");
    }

    @Override
    public void eat() {
        System.out.println("dog is running.");
    }
}

// Abstract class and Abstract methods

// 1. A class should be declared as abstract
// 2. You cannot create object of Abstract class
// 3. Abstract class can contain normal methods as well as asbtract methods
// 4. Abstract methods in abstract class only has method definitions and not
// method body
// 5. Once declare it is mendatory to override abstact methods in child class