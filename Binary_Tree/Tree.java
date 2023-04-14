import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

class Tree {
    private Node rootNode; // корневой узел
    private Node temp;
    private Node nullNode = new Node();;

    private boolean isLeftChild = true;

    public Tree() { // Пустое дерево
        rootNode = null;
        nullNode.setValue(Integer.MAX_VALUE);
    }

    public Node findNodeByValue(int value) { // поиск узла по значению
        Node currentNode = rootNode; // начинаем поиск с корневого узла
        while (currentNode.getValue() != value) { // поиск покуда не будет найден элемент или не будут перебраны все
            if (value < currentNode.getValue()) { // движение влево?
                currentNode = currentNode.getLeftChild();
            } else { // движение вправо
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null) { // если потомка нет,
                return null; // возвращаем null
            }
        }
        return currentNode; // возвращаем найденный элемент
    }

    public Node findNodeByChild(int value) { // поиск узла по значению
        Node currentNode = rootNode; // начинаем поиск с корневого узла
        while (currentNode.getValue() != value) { // поиск покуда не будет найден элемент или не будут перебраны все
            if (value < currentNode.getValue()) { // движение влево?
                if (currentNode.getLeftChild().getValue() == value) {
                    isLeftChild = true;
                    return currentNode;
                }
                currentNode = currentNode.getLeftChild();
            } else { // движение вправ
                if (currentNode.getRightChild().getValue() == value) {
                    isLeftChild = false;
                    return currentNode;
                }
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null) { // если потомка нет,
                return null; // возвращаем null
            }
        }
        return currentNode; // возвращаем найденный элемент
    }

    public void startInsertNode(int value) { // метод вставки нового элемента в начале
        Node newNode = new Node(); // создание нового узла
        newNode.setValue(value); // вставка данных
        if (rootNode == null) { // если корневой узел не существует
            newNode.setColor(true);
            rootNode = newNode;// то новый элемент и есть корневой узел
        } else { // корневой узел занят
            Node currentNode = rootNode; // начинаем с корневого узла
            Node parentNode;
            while (true) // мы имеем внутренний выход из цикла
            {
                parentNode = currentNode;
                if (value == currentNode.getValue()) { // если такой элемент в дереве уже есть, не сохраняем его
                    return; // просто выходим из метода
                } else if (value < currentNode.getValue()) { // движение влево?
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) { // если был достигнут конец цепочки,
                        newNode.setColor(!parentNode.isColor());
                        parentNode.setLeftChild(newNode); // то вставить слева и выйти из методы
                        return;
                    }
                } else { // Или направо?
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) { // если был достигнут конец цепочки,
                        newNode.setColor(!parentNode.isColor());
                        parentNode.setRightChild(newNode); // то вставить справа
                        return; // и выйти
                    }
                }
            }
        }
    }

    public void insertNode(int value) { // метод вставки нового элемента
        ArrayList<Node> oldNodeList = pullAll(rootNode, new ArrayList<Node>());
        oldNodeList.add(rootNode);
        ArrayList<Integer> newIntList = new ArrayList<Integer>();
        newIntList.add(value);
        for (int i = 0; i < oldNodeList.size(); i++) {
            newIntList.add(oldNodeList.get(i).getValue());
        }
        rootNode = null;
        Collections.sort(newIntList);
        recursionInsert(newIntList, this, 0);

    }

    public boolean deleteNode(int value) // Удаление узла с заданным ключом
    {
        Node currentNode = findNodeByValue(value);// находим удаляемый элемент
        Node parentNode = findNodeByChild(value);// находим его родителя
        isLeftChild = true;

        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            if (isLeftChild) {
                parentNode.setLeftChild(null);
            } else {
                parentNode.setRightChild(null);
            }

        } else if (currentNode.getLeftChild() == null) {
            if (isLeftChild) {
                parentNode.setLeftChild(currentNode.getLeftChild());
            } else {
                parentNode.setRightChild(currentNode.getRightChild());
            }
        } else if (currentNode.getRightChild() == null) {
            if (isLeftChild) {
                parentNode.setLeftChild(currentNode.getLeftChild());
            } else {
                parentNode.setRightChild(currentNode.getLeftChild());
            }
        } else {
            ArrayList<Node> allNode = pullAll(rootNode, new ArrayList<Node>());
            int removed = 0;
            for (int i = 0; i < allNode.size(); i++) {
                if ((int) (allNode.get(i).getValue()) == (int) (value)) {
                    removed = i;
                }
            }
            allNode.remove(removed);
            allNode.add(rootNode);
            rootNode = null;
            ArrayList<Integer> allNodeInt = new ArrayList<Integer>();
            for (int i = 0; i < allNode.size(); i++) {
                allNodeInt.add(allNode.get(i).getValue());
            }
            this.recursionInsert(allNodeInt, this, 0);
        }

        return true;
    }

    public void printTree(boolean colorSeach) { // метод для вывода дерева в консоль
        ArrayDeque<Node> globalStack = new ArrayDeque<Node>();
        globalStack.push(rootNode);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            ArrayDeque<Node> localStack = new ArrayDeque<Node>();
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                temp = (Node) globalStack.pop();
                if (temp.getValue() != Integer.MAX_VALUE) {
                    if (!colorSeach) {
                        System.out.print(temp.getValue()); // выводим его значение в консоли
                    } else {
                        if (temp.isColor()) {
                            System.out.print("b");
                        } else {
                            System.out.print("r");
                        }
                    }
                    if (temp.getLeftChild() != null) {
                        localStack.push(temp.getLeftChild());// соохраняем в локальный стек, наследники текущего
                                                             // элемента
                    } else {
                        localStack.push(nullNode);
                    }
                    if (temp.getRightChild() != null) {
                        localStack.push(temp.getRightChild());
                    } else {
                        localStack.push(nullNode);
                    }
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(nullNode);
                    localStack.push(nullNode);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');

            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз
                      // уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }

    public int recursionInsert(ArrayList<Integer> childrens, Tree tree, int midValueLast) {
        Collections.sort(childrens);
        if (childrens.isEmpty()) {
            return 0;
        } else if (childrens.size() == 1) {
            tree.startInsertNode(childrens.get(0));
        } else if (childrens.size() == 2) {
            tree.startInsertNode(childrens.get(0));
            tree.startInsertNode(childrens.get(1));
        } else {
            int sizeList = childrens.size();
            int midValue = childrens.size() / 2;
            if ((int) (midValue) == (int) (midValueLast) || childrens.size() < 2) {
                return 0;
            }
            tree.startInsertNode(childrens.get(midValue));
            tree.startInsertNode(childrens.get(midValue));
            ArrayList<Integer> juniorChildren = null;
            ArrayList<Integer> elderChildren = null;
            elderChildren = subArrayList(childrens, midValue + 1, sizeList);
            juniorChildren = subArrayList(childrens, 0, midValue);
            recursionInsert(elderChildren, tree, midValue);
            recursionInsert(juniorChildren, tree, midValue);
        }
        return 1;

    }

    public static ArrayList<Node> pullAll(Node node, ArrayList<Node> childrens) {
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return childrens;
        } else if (node.getLeftChild() == null) {
            childrens.add(node.getRightChild());
            pullAll(node.getRightChild(), childrens);
        } else if (node.getRightChild() == null) {
            childrens.add(node.getLeftChild());
            pullAll(node.getLeftChild(), childrens);
        } else {
            childrens.add(node.getRightChild());
            childrens.add(node.getLeftChild());
            pullAll(node.getLeftChild(), childrens);
            pullAll(node.getRightChild(), childrens);
        }
        return childrens;
    }

    public static ArrayList<Integer> subArrayList(ArrayList<Integer> fullList, int min, int max) {
        ArrayList<Integer> subArrayList = new ArrayList<Integer>();
        for (int i = min; i < max; i++) {
            subArrayList.add(fullList.get(i));
        }
        return subArrayList;
    }

    @Override
    public String toString() {
        ArrayList<Node> nodeList = pullAll(rootNode, new ArrayList<Node>());
        ArrayList<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i < nodeList.size(); i++) {
            intList.add(nodeList.get(i).getValue());
        }
        Collections.sort(intList);
        return intList.toString();
    }

}
