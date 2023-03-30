//Push moves element at right place in order

//Time Complexity
//Worst - O(n square)
//Average - O(n square)
//Best - O(n) -

//Space Complexity - O(1)

package sort;

import java.util.Arrays;

public class InsertionSort {

    private static int[] sort(int[] numbers) {
        int temp;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {

                if (numbers[j] < numbers[j - 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }

//            System.out.println("iteration: " + i + " " + Arrays.toString(numbers));
        }


        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 7, 17, 6, 22, 2, 8, 3, 9, 4};
        System.out.println("array: " + Arrays.toString(numbers));

        int[] sortedNumbers = InsertionSort.sort(numbers);
        System.out.println("sorted array: " + Arrays.toString(sortedNumbers));
    }
}
