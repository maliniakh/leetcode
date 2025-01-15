package tasks;

import java.util.*;

public class BFSExample {
    static void bfs(int startNode, Map<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[7];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        System.out.println(graph);

        while (!queue.isEmpty()) {
            System.out.println("queue " + queue);
            int node = queue.poll();
            System.out.println("node " + node + " neighbours " + graph.get(node));

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }

            System.out.println("visited[] " + Arrays.toString(visited));
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

        System.out.print("BFS Traversal: ");
        bfs(0, graph);
    }
}
