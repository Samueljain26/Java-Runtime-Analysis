import java.util.*;

public class Sorting {

    // Bubble Sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Merge Sort
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // Quick Sort
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] originalArray = {2, 7, -6, 9, 50, 997, 965};

        System.out.println("Original Array: " + Arrays.toString(originalArray));

        // Bubble Sort
        int[] arr1 = Arrays.copyOf(originalArray, originalArray.length);
        long startTime = System.nanoTime();
        bubbleSort(arr1);
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort: Time: " + (endTime - startTime) + " ns");

        // Merge Sort
        int[] arr2 = Arrays.copyOf(originalArray, originalArray.length);
        startTime = System.nanoTime();
        mergeSort(arr2, 0, arr2.length - 1);
        endTime = System.nanoTime();
        System.out.println("Merge Sort: Time: " + (endTime - startTime) + " ns");

        // Quick Sort
        int[] arr3 = Arrays.copyOf(originalArray, originalArray.length);
        startTime = System.nanoTime();
        quickSort(arr3, 0, arr3.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort: Time: " + (endTime - startTime) + " ns");
    }
}
/*Original Array: [2, 7, -6, 9, 50, 997, 965]
Bubble Sort: Time: 7400 ns
Merge Sort: Time: 25200 ns
Quick Sort: Time: 14300 ns
 */