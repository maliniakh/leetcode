package tasks;

import java.util.*;

public class NonRecursiveDFSMine {
    static void dfs(int startNode, Map<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[graph.values().stream().flatMap(List::stream).max(Comparator.naturalOrder()).get() + 1];
        Stack<Integer> stack = new Stack<>();
        stack.add(startNode);
        visited[startNode] = true;

        while(!stack.isEmpty()) {
            Integer node = stack.pop();
            System.out.println("node " + node);

            List<Integer> neighbours = graph.get(node);
            for(int i = neighbours.size() - 1; i >= 0;i--) {
                Integer neighbour = neighbours.get(i);
                if(!visited[neighbour]) {
                    stack.push(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 5, 6));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1));
        graph.put(5, Arrays.asList(2));
        graph.put(6, Arrays.asList(2));

        System.out.print("DFS Traversal (Non-Recursive): ");
        dfs(0, graph);
    }
}