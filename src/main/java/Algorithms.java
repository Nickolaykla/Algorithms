import java.util.Arrays;

public class Algorithms {
    public static void main(String[] args) {
        int[] array = {2, 1, 10, 5, 15, 4, 6};
//        bubbleSort(array);
//        sortBySelect(array);
          insertSort(array);

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
}
