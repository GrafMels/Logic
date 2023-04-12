import java.util.ArrayDeque;

public class Reverse {
    public static ArrayDeque<Integer> reverseList(ArrayDeque<Integer> directList) {
        ArrayDeque<Integer> reverseList = new ArrayDeque<Integer>();
        for (int i = directList.size(); i > 0; i--) {
            reverseList.add(directList.pollLast());
        }
        return reverseList;
    }

    public static ArrayDeque<Integer> reverseListRecursion(ArrayDeque<Integer> cur, ArrayDeque<Integer> prev) {
        if (cur.peekFirst() == null) {
            return prev;
        }
        prev.add(cur.pollLast());
        return reverseListRecursion(cur, prev);
    }
}
