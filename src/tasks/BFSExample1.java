package tasks;

import java.util.*;

public class BFSExample1 {
    static void bfs(int startNode, Map<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[7];
        queue.add(startNode);
        visited[startNode] = true;

        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            System.out.println("visited " + node);

            for (Integer neighbour : graph.get(node)) {
                if(!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
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

        System.out.println("BFS Traversal: ");
        bfs(0, graph);
    }
}
