public class LinkedList<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String WHITE = "\u001B[37m";
    private static final String RED = "\u001B[31m";

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void add(T element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        visualize();
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
        visualize();
    }

    public int search(T element) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public void visualize() {
        System.out.print(GREEN + "[Head]" + RESET);
        Node current = head;
        while (current != null) {
            System.out.print(WHITE + " -> " + RESET);
            System.out.print(BLUE + "[" + current.data + "]" + RESET);
            current = current.next;
        }
        System.out.println(WHITE + " -> " + RED + "null" + RESET);
    }
}
