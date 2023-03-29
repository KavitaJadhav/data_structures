//Time complexity -
// best - O(1)
// Average - O(n)
// worst - O(n)
package search;

public class LinearSearch {
    private static boolean present(int[] values, int number) {
        for (int j = 0; j < values.length; j++) {
            if (values[j] == number)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println("Value present : " + LinearSearch.present(values, 5));
        System.out.println("Value present : " + LinearSearch.present(values, 50));
    }
}
