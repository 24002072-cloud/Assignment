package hus.oop.basicstatistics;

public class BasicStatistic {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public BasicStatistic(MyList data) {
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     */
    public double max() {

        if (data.size() == 0) throw new IllegalStateException("");
        
        double maxVal = data.get(0).doubleValue();
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).doubleValue() > maxVal) {
                maxVal = data.get(i).doubleValue();
            }
        }
        return maxVal;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     */
    public double min() {

        if (data.size() == 0) throw new IllegalStateException("");

        double minVal = data.get(0).doubleValue();
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).doubleValue() < minVal) {
                minVal = data.get(i).doubleValue();
            }
        }
        return minVal;
    }

    /**
     * Tính kỳ vọng (Mean) của mẫu lưu trong list.
     */
    public double mean() {

        if (data.size() == 0) throw new IllegalStateException("");

        double sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum += data.get(i).doubleValue();
        }
        return sum / data.size();
    }

    /**
     * Tính phương sai (Variance) của mẫu lưu trong list.
     */
    public double variance() {

        if (data.size() == 0) throw new IllegalStateException("");

        double meanVal = mean();
        double sumSq = 0;
        for (int i = 0; i < data.size(); i++) {
            double val = data.get(i).doubleValue();
            sumSq += (val - meanVal) * (val - meanVal);
        }
        return sumSq / data.size();
    }
}