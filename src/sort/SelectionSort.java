//Push smallest element in the beginning

//Time Complexity
//Average - O(n2)
//Best - O(n square)
//worst - O(n square)

//Space Complexity - O(1)

package sort;

import java.util.Arrays;

public class SelectionSort {

    private static int[] sort(int[] numbers) {
        int temp;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }

            }
//            System.out.println("iteration: " + i + " " + Arrays.toString(numbers));
            
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 7, 2, 8, 3, 9, 4};
        System.out.println("array: " + Arrays.toString(numbers));

        int[] sortedNumbers = SelectionSort.sort(numbers);
        System.out.println("sorted array: " + Arrays.toString(sortedNumbers));
    }
}
