import java.util.Arrays;

public class Algorithms {
    public static void main(String[] args) {
        int[] array = {2, 1, 10, 5, 15, 4, 6};
        System.out.println("До сортировки: " + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("После сортировки: " + Arrays.toString(array));
    }
    //bubbleSort
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
}
