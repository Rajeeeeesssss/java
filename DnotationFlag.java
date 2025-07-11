import java.util.Arrays;

public class DnotationFlag {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 3, 0, 1, 3};
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 3:
                    int temp3 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp3;
                    high--;
                    break;

                default:
                    System.out.println("Invalid input found: " + arr[mid]);
                    return;
            }
        }

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
