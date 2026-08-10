package hus.oop.datastructure;

public class MyStack {
    private MyList stackData;

    public MyStack() {
        this.stackData = new ArrayMyList();
    }

    public void push(int value) {

        stackData.insertAtEnd(value);

    }

    public int pop() {

        if (isEmpty()) {
            throw new RuntimeException("Stack rỗng");
        }

        int topIndex = stackData.size() - 1;
        int value = stackData.get(topIndex);
        stackData.remove(topIndex);
        return value;
    }

    public boolean isEmpty() {
        return stackData.size() == 0;
    }

    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("Stack rỗng");
        }

        return stackData.get(stackData.size() - 1);
    }

    public int size() {
        return stackData.size();
    }
    
    @Override
    public String toString() {

        return stackData.toString();

    }
}