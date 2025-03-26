import java.util.*;

public class Searching {
    public static void main(String[] args) {
        int[] arr = {5, 8, 9, 5, 18, -3, -4};
        int target = 8;

        System.out.print("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nTarget: " + target);

        // Measure time for Linear Search
        long startLinear = System.nanoTime();
        int linear = linearSearch(arr, target);
        long endLinear = System.nanoTime();
        long timeLinear = endLinear - startLinear;
        System.out.println("Linear Search Index: " + linear + " | Time: " + timeLinear + " ns");

        // Sorting the array before Binary Search
        Arrays.sort(arr);
        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Measure time for Binary Search
        long startBinary = System.nanoTime();
        int binary = binarySearch(arr, target);
        long endBinary = System.nanoTime();
        long timeBinary = endBinary - startBinary;
        System.out.println("\nBinary Search Index: " + binary + " | Time: " + timeBinary + " ns");
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
/*Original array: 5 8 9 5 18 -3 -4
Target: 8
Linear Search Index: 1 | Time: 5500 ns
Sorted array: -4 -3 5 5 8 9 18
Binary Search Index: 4 | Time: 3000 ns
 */