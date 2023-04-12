import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> directList = new ArrayDeque<Integer>();
        initializer.initialize(directList, 99);
        System.out.println(directList.toString());

        directList = Reverse.reverseList(directList);
        System.out.println("\n" + directList.toString());

        directList = Reverse.reverseListRecursion(directList, new ArrayDeque<Integer>());
        System.out.println("\n" + directList.toString());
    }

}