package hus.oop.search;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class TestBinarySearch {
    public static void main(String[] args) {
        Random random = new Random();
        
        int n = 20 + random.nextInt(11); 
        
        double[] originalData = new double[n];

        for (int i = 0; i < n; i++) {
            originalData[i] = Math.round(random.nextDouble() * 100.0 * 10.0) / 10.0;
        }

        StringBuilder output = new StringBuilder();
        BinarySearch searcher = BinarySearch.getInstance();

        Sorter[] sorters = {new BubbleSort(), new InsertionSort(), new SelectionSort()};
        String[] sorterNames = {"Bubble Sort", "Insertion Sort", "Selection Sort"};

        for (int i = 0; i < sorters.length; i++) {

            double[] data = Arrays.copyOf(originalData, originalData.length);
            searcher.setSorter(sorters[i]);

            output.append("Using ").append(sorterNames[i]).append(" Algorithm:\n");
            output.append("Before sorting: ").append(formatArray(data)).append("\n");

            double valueToSearch = random.nextBoolean() ? data[random.nextInt(n)] : Math.round(random.nextDouble() * 100.0 * 10.0) / 10.0;

            int index = searcher.search(data, valueToSearch);

            output.append("After sorting: ").append(formatArray(data)).append("\n");
            output.append("Binary search giá trị ").append(valueToSearch).append(": ").append(index).append("\n\n");
        }

        System.out.println(output.toString());

        String fileName = "TranCongThinh_24002088_BinarySearch.txt"; 
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(output.toString());
        } 
        catch (FileNotFoundException e) {
            System.err.println("Lỗi khi tạo file: " + e.getMessage());
        }
    }

    private static String formatArray(double[] data) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            if (i < data.length - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}