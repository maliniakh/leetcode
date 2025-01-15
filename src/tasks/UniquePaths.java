package tasks;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[n][m];

        // return (int) Math.pow(2, (m - 1) * (n - 1));
        for (int i = 0; i < Math.min(m, n); i++) {
            for (int x = i; x < m; x++) {
                for (int y = i; y < n; y++) {
                    if (x == 0 || y == 0) {
                        paths[y][x] = 1;
                    } else {
                        paths[y][x] = paths[y - 1][x] + paths[y][x - 1];
                    }
                }
            }
        }

        return paths[n - 1][m - 1];
    }
}
