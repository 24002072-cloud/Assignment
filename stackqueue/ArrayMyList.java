package hus.oop.datastructure;

public class ArrayMyList extends AbstractMyList {
    private static final int DEFAULT_CAPACITY = 16;
    private int[] data;
    private int size;

    public ArrayMyList() {
        this.data = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int get(int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return data[index];
    }

    @Override
    public void set(int data, int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        this.data[index] = data;
    }

    @Override
    public void insertAtStart(int value) {
        insertAtPos(value, 0);
    }

    @Override
    public void insertAtEnd(int value) {
        insertAtPos(value, size);
    }

    @Override
    public void insertAtPos(int value, int index) {
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (size == data.length) {
            allocateMore();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    private void allocateMore() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }
}