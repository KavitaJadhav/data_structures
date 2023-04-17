//Push largest element in the end

//Time Complexity
//Average - O(n2)
//Best - O(n) - if array is sorted

//Space Complexity - O(1)

package sort;

import java.util.Arrays;

public class BubbleSortOptimised {
    private static int[] sort(int[] numbers) {
        int temp;
        boolean swapped = false;

        for (int i = 0; i < numbers.length; i++) {
            swapped = false;
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }
//            System.out.println("iteration: " + i + " " + Arrays.toString(numbers));

            if (swapped == false) {
                break;
            }
        }

        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 7, 17, 6, 22, 2, 8, 3, 9, 4};
        System.out.println("array: " + Arrays.toString(numbers));

        int[] sortedNumbers = BubbleSortOptimised.sort(numbers);
        System.out.println("sorted array: " + Arrays.toString(sortedNumbers));
    }
}
