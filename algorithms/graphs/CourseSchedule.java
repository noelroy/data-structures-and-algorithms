/**
 * 207. CourseSchedule
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 */

import java.util.*;

public class CourseSchedule {

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
 
        // Construct graph as adjacency List
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            adjList.get(edge[1]).add(edge[0]);
        }

        // 0  = not visited
        // -1 = visited in current search
        // 1  = visited in past search
        int[] visited = new int[numCourses];

        // Iterate through all nodes
        for (int i = 0; i < numCourses; i++) {
            if(!visit(adjList, visited, i)){
                return false;
            }
        }

        return true;
    }

    private static boolean visit(HashMap<Integer, List<Integer>> adjList, int[] visited, int i) {
        // If visited in current iteration. Loop found
        if(visited[i] == -1){
            return false;
        }

        // Return if found in previous iterations
        if(visited[i] == 1) {
            return true;
        }

        // Set the node as visiting 
        visited[i] = -1;

        // Check for other edges from current nodes
        for(int node : adjList.get(i)) {
            if(!visit(adjList, visited, node)){
                return false;
            }
        }

        // Set as previously visited, so that this node will be skipped in next iteration
        visited[i] = 1;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][] {{1,0}} ));

        System.out.println(canFinish(2, new int[][] {{1,0}, {0,1}} ));
    }
}