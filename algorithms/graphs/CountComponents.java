/**
 * 
 * 323. Number of Connected Components in an Undirected Graph
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to find the number of connected components in an undirected graph.
 * 
 *      0          3
 *      |          |
*       1 --- 2    4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * 
 */

import java.util.*;

public class CountComponents {

    private static int countComponents(int n, int[][] edges){
        // Construct the graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());   
        }

        for(int[] pairs : edges){
            adjList.get(pairs[0]).add(pairs[1]);
            adjList.get(pairs[1]).add(pairs[0]);
        }

        // Can be done with boolean array also
        int[] visited = new int[n];

        // Total connected components counter
        int count = 0;

        // Iterate all nodes
        // If nodes are not previously visited, its a new connected component
        for (int i = 0; i < n; i++) {
            if(visited[i]==0){
                count++;
                visit(i, adjList, visited);
            }
        }

        return count;
    }

    private static void visit(int i, Map<Integer, List<Integer>> adjList, int[] visited) {
        
        // Mark the node as visited
        visited[i] = 1;
        for(int node : adjList.get(i)){
            // Visit connected nodes also
            if(visited[node]==0){
                visit(node, adjList, visited);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countComponents(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}));
        System.out.println(countComponents(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}}));
    }
}
