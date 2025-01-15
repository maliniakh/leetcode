package tasks;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int n = 0; n < numRows; n++) {
            List<Integer> current = new ArrayList<>();
            result.add(current);
            List<Integer> prev = n > 0 ? result.get(n - 1) : null;
            for(int i = 0; i <= n; i++) {
                if (i == 0 || i == n) {
                    current.add(1);
                } else {
                    current.add(prev.get(i) + prev.get(i - 1));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.printf(new PascalTriangle().generate(5) + "");
    }
}
