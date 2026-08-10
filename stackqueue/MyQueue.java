package hus.oop.datastructure;

public class MyQueue {
    private MyList queueData;

    public MyQueue() {
        this.queueData = new LinkedListMyList();
    }

    public void add(int value) {

        queueData.insertAtEnd(value);

    }

    public int remove() {

        if (isEmpty()) {
            throw new RuntimeException("Queue rỗng");
        }

        int value = queueData.get(0);
        queueData.remove(0);
        return value;
    }

    public boolean isEmpty() {
        return queueData.size() == 0;
    }

    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("Queue rỗng");
        }

        return queueData.get(0);
    }

    public int size() {
        return queueData.size();
    }
    
    @Override
    public String toString() {

        return queueData.toString();

    }
}