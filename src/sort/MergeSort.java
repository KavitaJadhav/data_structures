//Push largest element in the end

//Time Complexity
//Average - O(n log n)
//Best -  O(n log n)
//Best -  O(n log n)

//Space Complexity - O(n) - for new result array created in merge function

package sort;

import java.util.Arrays;

public class MergeSort {
    private static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int mergeIndex = 0;
        int[] mergeArray = new int[left.length + right.length];

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                mergeArray[mergeIndex] = left[i];
                mergeIndex++;
                i++;
            } else {
                mergeArray[mergeIndex] = right[j];
                mergeIndex++;
                j++;
            }
        }

        while (i < left.length) {
            mergeArray[mergeIndex] = left[i];
            mergeIndex++;
            i++;
        }

        while (j < right.length) {
            mergeArray[mergeIndex] = right[j];
            mergeIndex++;
            j++;
        }

        return mergeArray;
    }

    private static int[] sort(int[] numbers) {

        if (numbers.length == 0 || numbers.length == 1)
            return numbers;

        int mid = (numbers.length / 2);

        int[] left = Arrays.copyOfRange(numbers, 0, mid);
        int[] right = Arrays.copyOfRange(numbers, mid, numbers.length);

        left = MergeSort.sort(left);
        right = MergeSort.sort(right);

        return merge(left, right);
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 7, 17, 6, 22, 2, 8, 3, 9, 4};
        System.out.println("array: " + Arrays.toString(numbers));

        int[] sortedNumbers = MergeSort.sort(numbers);
        System.out.println("sorted array: " + Arrays.toString(sortedNumbers));
    }
}
