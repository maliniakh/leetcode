package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;

public class MinRectangle {
    static public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> colMap = new HashMap<>();

        for(int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            colMap.computeIfAbsent(x, o -> new ArrayList<>()).add(y);
        }

        Map<Integer, Integer> lastx = new HashMap<>();

        Integer minArea = Integer.MAX_VALUE;

        for(Integer x : colMap.keySet()) {
            List<Integer> yList = colMap.get(x);
            for(int i = 0; i < yList.size(); i++) {
                for (int j = i + 1; j < yList.size(); j++) {
                    int y1 = yList.get(i);
                    int y2 = yList.get(j);

                    int code = 40001*y1 +y2;
                    if(lastx.containsKey(code)) {
                        minArea = Integer.min(minArea, abs(y2 - y1) * abs(x - lastx.get(code)));
                    }
                    lastx.put(code, x);
                }
            }
        }

        return minArea != Integer.MAX_VALUE ? minArea : 0;
    }
}
