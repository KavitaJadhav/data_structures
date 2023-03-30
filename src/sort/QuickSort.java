//Push largest element in the end

//Time Complexity
//Average - O(n log n)
//Best -  O(n log n)
//worst -  O(n square)

//Space Complexity -O(n log n) - for new result array created in merge function

package sort;

import java.util.Arrays;

public class QuickSort {
    private static int[] sort(int[] numbers) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;

        return sortArray(numbers, startIndex, endIndex);
    }

    private static int[] sortArray(int[] numbers, int startIndex, int endIndex) {
        System.out.println("sorted array: " + Arrays.toString(numbers));

        if (numbers.length == 1 || startIndex >= endIndex) {
            return numbers;
        }
        int pivotIndex = pivot(numbers, startIndex, endIndex);

        sortArray(numbers, startIndex, pivotIndex);
        sortArray(numbers, pivotIndex + 1, endIndex);

        return numbers;
    }

    private static int[] swap(int[] numbers, int source, int destination) {
        int temp = numbers[source];
        numbers[source] = numbers[destination];
        numbers[destination] = temp;

        return numbers;
    }

    private static int pivot(int[] numbers, int startIndex, int endIndex) {
        int pivot = startIndex;
        int pivotValue = numbers[startIndex];

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (pivotValue > numbers[i]) {
                pivot = pivot + 1;
                swap(numbers, pivot, i);
            }

        }

        swap(numbers, startIndex, pivot);

        return pivot;
    }


    public static void main(String[] args) {
        int[] numbers = new int[]{1, 7, 17, 6, 22, 2, 8, 3, 9, 4};
        System.out.println("array: " + Arrays.toString(numbers));

        int[] sortedNumbers = QuickSort.sort(numbers);
        System.out.println("sorted array: " + Arrays.toString(sortedNumbers));


//        System.out.println("array: " + Arrays.toString(numbers));
//        System.out.println("pivot: " + QuickSort.pivot(numbers, 0, numbers.length-1));

    }

}
