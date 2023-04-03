package Lesson001;

import java.io.IOException;
import java.util.ArrayList;

public class Ex001 {
    static Integer counter = 0;

    public static void main(String[] args) {
        // clrConsole();
        // ArrayList<Integer> result = makeList(25);
        // printList(result);
        // System.out.println("\n");
        // result = findNumber(27);
        // printList(result);
        // System.out.println(printString(100));
        System.out.println(fibonachi(12));
        System.out.println(counter);

        System.out.println();

        System.out.println(fibonachi(40));
        System.out.println(counter);
    }

    public static ArrayList<Integer> findNumber(int max) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    simple = false;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        return result;
    }

    public static String printString(int max) {
        String result = "";
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    simple = false;
                }
            }
            if (simple) {
                result += i;
            }
        }
        return result;
    }

    public static ArrayList<Integer> makeList(int number) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static void printList(ArrayList<Integer> result) {
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static void clrConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static int fibonachi(int n) {
        counter++;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            return fibonachi(n - 1) + fibonachi(n - 2);
        }
    }

}