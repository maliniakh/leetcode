package tasks;

public class TriangleTraversal {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12},
                {13,14,15,16}
        };

        traverseInTriangle(array);
        traverse(array);
    }

    public static void traverseInTriangle(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        // Starting point: bottom-right corner
        int startRow = rows - 1;
        int startCol = cols - 1;

        // Maximum distance to cover the entire array
        int maxDistance = Math.max(rows, cols);

        // Iterate through distances from the starting point
        for (int dist = 0; dist < maxDistance; dist++) {
            for (int i = -dist; i <= dist; i++) {
                for (int j = -dist; j <= dist; j++) {
                    if (Math.abs(i) + Math.abs(j) == dist) {
                        int newRow = startRow + i;
                        int newCol = startCol + j;

                        // Check if the new position is within bounds
                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                            System.out.println("Value at (" + newRow + ", " + newCol + "): " + array[newRow][newCol]);
                        }
                    }
                }
            }
        }
    }

    public static void traverse(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        for(int dist = 0; dist < Math.max(rows, cols); dist++) {
            for(int i = 0; i <= dist; i++) {
                System.out.println(array[rows - 1 - i][cols - 1 - dist + i]);
            }
        }
    }
}