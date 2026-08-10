package hus.oop.datastructure;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class TestDataStructures {

    static StringBuilder resultLog = new StringBuilder();
    static Random random = new Random();

    public static void main(String[] args) {
        testStack();
        testQueue();

        System.out.println(resultLog.toString());

        String fileName = "TranCongThinh_24002088_DataStructures.txt";
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.print(resultLog.toString());
        } 
        catch (FileNotFoundException e) {
            System.err.println("Lỗi khi tạo file: " + e.getMessage());
        }
    }

    public static void testStack() {

        int n = 15 + random.nextInt(16);
        MyStack stack = new MyStack();
        
        resultLog.append("Sinh ngẫu nhiên ").append(n).append(" phần tử cho Stack:\n");
        for (int i = 0; i < n; i++) {
            stack.push(random.nextInt(100));
        }
        
        resultLog.append("Các phần tử trong stack: ").append(stack.toString()).append("\n\n");
        
        while (!stack.isEmpty()) {
            int popped = stack.pop();
            resultLog.append("- Xóa: ").append(popped)
                     .append(" | Stack còn lại: ").append(stack.toString()).append("\n");
        }
        resultLog.append("\n");

    }

    public static void testQueue() {

        int n = 15 + random.nextInt(16);
        MyQueue queue = new MyQueue();
        
        resultLog.append("Sinh ngẫu nhiên ").append(n).append(" phần tử cho Queue:\n");
        for (int i = 0; i < n; i++) {
            queue.add(random.nextInt(100));
        }
        
        resultLog.append("Các phần tử trong queue: ").append(queue.toString()).append("\n\n");
        
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            resultLog.append("- Xóa: ").append(removed)
                     .append(" | Queue còn lại: ").append(queue.toString()).append("\n");
        }
        resultLog.append("\n");
    }
}