package tasks;

import java.util.*;

class NQueensDfs {

    public List<List<String>> solveNQueens(int n) {
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(new ArrayList<>());

        List<List<String>> solutions = new ArrayList<>();
        while(!stack.isEmpty()) {
            List<Integer> current = stack.pop();

            if(current.size() == n) {
                solutions.add(generateBoard(current));
                continue;
            }

            for(int c = n - 1; c >= 0; c--) {
                if(isValidBoard(current, c)) {
                    ArrayList<Integer> newState = new ArrayList<>(current);
                    newState.add(c);
                    stack.push(newState);
                }
            }
        }

        return solutions;
    }

    List<String> generateBoard(List<Integer> queens) {
        List<String> board = new ArrayList<>();
        for(int r = 0; r < queens.size(); r++) {
            char[] row = new char[queens.size()];
            Arrays.fill(row, '.');
            row[queens.get(r)] = 'Q';
            board.add(new String(row));
        }

        return board;
    }


    boolean isValidBoard(List<Integer> queens, int column) {
        int row = queens.size();
        for(int r = 0; r < queens.size(); r++) {
            Integer c = queens.get(r);
            if (column == c || (column + row) == c + r || column - row == c - r) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        List<List<String>> solution = new NQueensDfs().solveNQueens(10);
        for(List<String> s : solution) {
            for(String r : s) {
                System.out.println(r);
            }
            System.out.println();
        }
    }
}
