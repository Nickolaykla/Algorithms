import java.util.Arrays;

public class Algorithms {
    public static void main(String[] args) {
        int[] array = {2, 1, 10, 5, 15, 4, 6};
//        bubbleSort(array);
//        sortBySelect(array);
//        insertSort(array);
//        fastSort(array);
        array = mergeSort(array);
    }
    //сортировка пузырьком O(N^2)
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    // сортировка выбором O(N^2)
    public static void sortBySelect(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    // сортировка вставкой О(N^2)
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length ; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] >= temp) {
                arr[j] = arr[j-1];
                --j;
            }
            arr[j] = temp;
        }
}
    // быстрая сортировка О(N*logN)
    public static void fastSort(int[] arr) {
        recFastSort(arr, 0, arr.length - 1);
    }
    public static void recFastSort(int[] arr, int min, int max) {
        if (arr.length == 0) return;
        if (min >= max) return;

        int middleElement = arr[min + (max - min) / 2];

        int i = min, j = max;
        while (i <= j) {
            while (arr[i] < middleElement) {
                i++;
            }
            while (arr[j] > middleElement) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        // use recursion
        if (min < j)
            recFastSort(arr, min, j);

        if (max > i)
            recFastSort(arr, i, max);

    }
    // сортировка слиянием О(N*logN)
    public static int[] mergeSort(int[] arr) {
        int[] sortArr = Arrays.copyOf(arr, arr.length); // array for sort
        int[] bufferArr = new int[arr.length]; // buffer array
        return  recMergeSort(sortArr, bufferArr, 0, arr.length);
    }
    public static int[] recMergeSort(int[] sortArr, int[] bufferArr, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) return sortArr;

        int middle = startIndex + (endIndex - startIndex) / 2;
        //get two sorted arrays
        int[] firstSortArr = recMergeSort(sortArr, bufferArr, startIndex, middle);
        int[] secondSortArr = recMergeSort(sortArr, bufferArr, middle, endIndex);

        int firstIndex = startIndex;
        int secondIndex = middle;
        int destIndex = startIndex;

        int[] result = firstSortArr == sortArr ? bufferArr : sortArr;
        while (firstIndex < middle && secondIndex < endIndex) {
            result[destIndex++] = firstSortArr[firstIndex] < secondSortArr[secondIndex] ?
                                  firstSortArr[firstIndex++] : secondSortArr[secondIndex++];
        }
        while (firstIndex < middle) {
            result[destIndex++] = firstSortArr[firstIndex++];
        }
        while (secondIndex < endIndex) {
            result[destIndex++] = secondSortArr[secondIndex++];
        }
        return result;
    }

}
