package recursion;

public class FactorialLoop {
    private static int factorial = 1;

    public static int factorial(int number) {
        for (int i = number; i > 0; i--) {
            factorial = factorial * i;
        }

        return factorial;
    }

    public static void main(String[] args) {
        System.out.println("Factorial: " + FactorialLoop.factorial(5));
    }
}
