import java.util.ArrayDeque;

public class initializer {
    public static void initialize(ArrayDeque<Integer> directList, int quantity) {
        for (int i = 0; i < quantity; i++) {
            directList.add(i);
        }
    }
}