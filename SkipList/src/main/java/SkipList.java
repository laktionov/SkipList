import java.util.Random;

public class SkipList<T> implements SkippableList<T> {
    private final Node head = new Node(null, null, LEVELS);
    private static final Random rand = new Random();


    public void put(int key, T value) {
        Node<T>[] update = (Node<T>[]) new Node[LEVELS];
        Node x = head;
        for (int i = LEVELS - 1; i >= 0; i--) {
            while (x.getNext(i) != null && x.getNext(i).key < key) {
                x = x.getNext(i);
            }
            update[i] = x;
        }

        x = x.getNext(0);
        if (x != null && x.key == key) {
            x.value = value;
        } else {
            int lvl = randomLevel();
            Node newNode = new Node(key, value, lvl);
            for (int i = 0; i < lvl; i++) {
                newNode.setNext(update[i].getNext(i), i);
                update[i].setNext(newNode, i);
            }
        }
    }

    public T get(int searchKey) {
        Node x = head;
        for (int i = LEVELS - 1; i >= 0; i--) {
            while (x.getNext(i) != null && x.getNext(i).key < searchKey) {
                x = x.getNext(i);
            }
        }

        x = x.getNext(0);
        if (x.key == searchKey) {
            return (T)x.value;
        }

        return null;
    }

    private int randomLevel() {
        int lvl = 1;
        while (rand.nextInt(100) % 2 == 0 && lvl < LEVELS){
            lvl++;
        }
        return lvl;
    }

    public boolean delete(int searchKey) {
        Node<T>[] update = (Node<T>[]) new Node[LEVELS];;
        Node x = head;
        for (int i = LEVELS - 1; i >= 0; i--) {
            while (x.getNext(i) != null && x.getNext(i).key < searchKey) {
                x = x.getNext(i);
            }
            update[i] = x;
        }

        x = x.getNext(0);
        if (x != null && x.key == searchKey) {
            for (int i = 0; i < LEVELS; i++) {
                if (update[i].getNext(i) != x) {
                    break;
                }
                update[i].setNext(x.getNext(i), i);
            }
        } else {
            return false;
        }

        return true;
    }

    public void print() {
        for (int i = 0; i < LEVELS; i++) {
            head.print(i);
        }

        System.out.println();
    }
}

