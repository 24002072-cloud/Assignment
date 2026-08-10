package hus.oop.basicstatistics;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class TestBasicStatistics {
    
    private static StringBuilder outputLog = new StringBuilder();

    public static void main(String[] args) {
        testMyArrayList();
        testMyLinkedList();

        System.out.println(outputLog.toString());

        String fileName = "TranCongThinh_24002088_BasicStatistics.txt";
        
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.print(outputLog.toString());
        } 
        catch (FileNotFoundException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static void testMyArrayList() {

        Random rand = new Random();
        int length = 30 + rand.nextInt(21); 
        MyArrayList list = new MyArrayList();

        for (int i = 0; i < length; i++) {
            double val = 1 + rand.nextDouble() * 19;
            list.append(Math.round(val * 10.0) / 10.0);
        }

        BasicStatistic statistic = new BasicStatistic(list);
        outputLog.append("Data (").append(length).append(" phần tử): ").append(list.toString()).append("\n");
        outputLog.append("Max: ").append(statistic.max()).append("\n");
        outputLog.append("Min: ").append(statistic.min()).append("\n");
        outputLog.append("Mean (Kỳ vọng): ").append(statistic.mean()).append("\n");
        outputLog.append("Variance (Phương sai): ").append(statistic.variance()).append("\n\n");
    }

    public static void testMyLinkedList() {
        /*
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo ra một danh sách kiểu MyLinkedList có các phần tử dữ liệu kiểu Double, các giá trị của phần
             tử được sinh ngẫu nhiên nằm trong đoạn [1, 20].
           - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
             In ra terminal tập dữ liệu và các đại lượng thống kê.
         */
    }
}
