import java.util.Scanner;
import java.util.Arrays;

public class Ex001 {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        boolean condition = true;
        Scanner scan = new Scanner(System.in);
        while (condition) {
            int number = 0;
            while (condition) {
                System.out.println("Введите число больше нуля:");
                number = scan.nextInt();
                if (number > -1) {
                    condition = false;
                }
            }
            condition = true;
            int insert_index = binarySearch(numbers, number, 0, numbers.length);
            numbers = appendx(numbers, number);
            for (int i = numbers.length - 1; i > insert_index + 1; i--) {
                numbers[i] = numbers[i] - numbers[i - 1];
                numbers[i - 1] = numbers[i - 1] + numbers[i];
                numbers[i] = numbers[i - 1] - numbers[i];
            }
            for (int i = 0; i < numbers.length; i++) {

                System.out.print(numbers[i] + " ");
            }
        }
        scan.close();
    }

    public static int binarySearch(Integer[] array, int number, int min, int max) {
        int midPoint;
        if (max < min) {
            return -1;
        } else {
            midPoint = (max - min) / 2 + min;
        }
        if (array[midPoint] < number) {
            try {
                return binarySearch(array, number, midPoint + 1, max);
            } catch (Exception e) {
                return midPoint + 1;
            }

        } else if (array[midPoint] > number) {
            try {
                return binarySearch(array, number, min, midPoint - 1);
            } catch (Exception e) {
                return midPoint + 1;
            }

        } else {
            return midPoint;
        }
    }

    private static <T> T[] appendx(T[] arr, T element) {
        T[] array = Arrays.copyOf(arr, arr.length + 1);
        array[array.length - 1] = element;
        return array;
    }
}
