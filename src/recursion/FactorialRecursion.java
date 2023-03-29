package recursion;

public class FactorialRecursion {
    private static int factorial = 1;

    public static int factorial(int number) {
        if (number == 1)
            return 1;
        return number * FactorialRecursion.factorial(number - 1);
    }

    public static void main(String[] args) {
        System.out.println("Factorial: " + FactorialRecursion.factorial(5));
    }
}
