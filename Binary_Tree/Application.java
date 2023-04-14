import java.util.ArrayList;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Tree tree = new Tree();

        boolean colorPrint = false;// Флаг для визуализации цветов в карсно чёрном дереве
        int sizeList = 21;
        ArrayList<Integer> nodeList = new ArrayList<Integer>(sizeList);
        nodeList.add(33);
        nodeList.add(7);

        Random random = new Random();
        for (int i = 0; i < sizeList; i++) {
            boolean repeat = true;
            while (repeat) {
                int newRandom = random.nextInt(100 - 0 + 1);
                if (nodeList.indexOf(newRandom) == -1) {
                    nodeList.add(newRandom);
                    repeat = false;
                }
            }
        }
        // System.out.println(nodeList);

        tree.recursionInsert(nodeList, tree, 0);// вставляем узлы в дерево:
        // отображение дерева:
        tree.printTree(colorPrint);
        // System.out.println(tree); // вызов tree через перегрузку метода toString

        // удаляем один узел и выводим оставшееся дерево в консоли
        tree.deleteNode(33);
        tree.printTree(colorPrint);
        // System.out.println(tree);

        tree.insertNode(33);
        tree.printTree(colorPrint);
        // System.out.println(tree);

        // находим узел по значению и выводим его в консоли
        Node foundNode = tree.findNodeByValue(7);
        foundNode.printNode();

    }
}