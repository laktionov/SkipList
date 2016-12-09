import java.lang.reflect.Array;

public class Node<T> {
    public Integer key;
    public T value;
    private int level;
    private Node[] next;

    Node(Integer key, T value, int level) {
        this.key = key;
        this.value = value;
        this.level = level;
        next = (Node[]) Array.newInstance(Node.class, level);
    }

    void setNext(Node next, Integer level) {
        this.next[level] = next;
    }

    Node getNext(Integer level) {
        return this.next[level];
    }

    void print(Integer level) {
        System.out.print("level " + level + ": ");
        Node current = this.getNext(level);
        while (current != null) {
            System.out.print("(" + Integer.toString(current.key) + "," + current.value.toString() + ") ");
            current = current.getNext(level);
        }
        System.out.println();
    }
}
