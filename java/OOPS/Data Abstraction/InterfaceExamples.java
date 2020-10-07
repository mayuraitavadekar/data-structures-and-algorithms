public class InterfaceExamples {
    public static void main(String[] args) {

        // Animal animal = new Animal(); // not allowed
        Animal animal = new Dog(); // upcasting - ref variable of parent pointing to child
        animal.eat();
        animal.run();
    }
}

interface Animal {

    public static final int var = 40;

    abstract public void eat();

    abstract public void run();
}

class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void run() {
        System.out.println("Dog is running.");
    }

}

// interface:

// 1. Data abstration is achieved through interface.
// 2. you cannot create object of interface.
// 3. it uses implements keyword.
// 4. No method body. only abstract method definitions.
// 5. avoid using variables in interface. But if you want use variables, declare
// them as public static final.
