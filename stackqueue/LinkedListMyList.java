package hus.oop.datastructure;

public class LinkedListMyList extends AbstractMyList {
    private Node start;
    private Node end;
    private int size;

    // hàm dựng
    public LinkedListMyList() {

        this.start = null;
        this.end = null;
        this.size = 0;

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int get(int index) {
        Node node = getNodeByIndex(index);
        if (node == null) throw new IndexOutOfBoundsException("Index out of bounds");
        return node.data;
    }

    @Override
    public void set(int data, int index) {
        Node node = getNodeByIndex(index);
        if (node == null) throw new IndexOutOfBoundsException("Index out of bounds");
        node.data = data;
    }

    @Override
    public void insertAtStart(int value) {
        Node newNode = new Node(value);
        if (size == 0) {
            start = newNode;
            end = newNode;
        } 
        else {
            newNode.next = start;
            start = newNode;
        }
        size++;
    }

    @Override
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (size == 0) {
            start = newNode;
            end = newNode;
        } 
        else {
            end.next = newNode;
            end = newNode;
        }
        size++;
    }

    @Override
    public void insertAtPos(int value, int index) {
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            insertAtStart(value);
            return;
        }
        if (index == size) {
            insertAtEnd(value);
            return;
        }
        
        Node prev = getNodeByIndex(index - 1);
        Node newNode = new Node(value);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            start = start.next;
            if (size == 1) {
                end = null;
            }
        } 
        else {
            Node prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
            if (index == size - 1) {
                end = prev;
            }
        }
        size--;
    }

    private Node getNodeByIndex(int index) {
        if (!checkBoundaries(index, size - 1)) {
            return null;
        }
        Node current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Node current = start;
        for (int i = 0; i < size; i++) {
            result[i] = current.data;
            current = current.next;
        }
        return result;
    }
}