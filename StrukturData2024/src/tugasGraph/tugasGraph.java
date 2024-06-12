package tugasGraph;

import java.util.*;

public class tugasGraph {
    
    // Implementasi BFS
    public List<String> bfs(Map<String, List<String>> graph, String start) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add(start);
        
        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                result.add(node);
                for (String neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return result;
    }


    // Implementasi DFS
    public List<String> dfs(Map<String, List<String>> graph, String start) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        
        stack.push(start);
        
        while (!stack.isEmpty()) {
            String node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                result.add(node);
                for (String neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return result;
    }

    // Metode utama untuk menguji implementasi
    public static void main(String[] args) {
        tugasGraph search = new tugasGraph();
        Map<String, List<String>> graph = new HashMap<>();
        
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D", "E"));
        graph.put("C", Arrays.asList("A", "F", "G"));
        graph.put("D", Arrays.asList("B"));
        graph.put("E", Arrays.asList("B", "H"));
        graph.put("F", Arrays.asList("C"));
        graph.put("G", Arrays.asList("C"));
        graph.put("H", Arrays.asList("E"));
        
        System.out.println("BFS: " + search.bfs(graph, "A"));
        System.out.println("DFS (Iterative): " + search.dfs(graph, "A"));
    }
}
