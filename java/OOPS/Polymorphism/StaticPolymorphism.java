public class StaticPolymorphism {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {

        StaticPolymorphism obj = new StaticPolymorphism();

        System.out.println(obj.add(5, 10));
        System.out.println(obj.add(5.5, 6.4));

    }
}