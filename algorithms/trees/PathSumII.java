
import java.util.*;
/**
 * 
 * 113. Path Sum II
 * 
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 * 
 */
class PAthSumII {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; this.left=this.right=null; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // Array to hold result
        List<List<Integer>> result = new ArrayList<>();
        // Array to track current path
        List<Integer> soFar = new ArrayList<>();
        int currentSum = 0;
        TreeNode currentNode = root;
        dfs(result, soFar, currentNode, currentSum, targetSum);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> soFar, PAthSumII.TreeNode currentNode, int currentSum,
            int targetSum) {

        // Condition to break the recursion
        if(currentNode == null){
            return;
        }

        soFar.add(currentNode.val);
        currentSum += currentNode.val;

        // If leaf node, check if the target sum matches
        if(currentNode.left == null && currentNode.right == null && currentSum == targetSum){
            result.add(new ArrayList<Integer>(soFar));

            // This part is to speed up the result. Will reduce to recursive calls
            soFar.remove(soFar.size()-1);
            currentSum -= currentNode.val;
            return;
        }

        dfs(result, soFar, currentNode.left, currentSum, targetSum);
        dfs(result, soFar, currentNode.right, currentSum, targetSum);

        // Remove last element for backtracking
        soFar.remove(soFar.size()-1);
        currentSum -= currentNode.val;
    }

    public static void main(String[] args) {

        TreeNode leftSubTree = new PAthSumII.TreeNode(4, new PAthSumII.TreeNode(11, new PAthSumII.TreeNode(7), new PAthSumII.TreeNode(2)), null);
        TreeNode rightSubTree = new PAthSumII.TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)));
        TreeNode root = new TreeNode(5, leftSubTree, rightSubTree);
        System.out.println(new PAthSumII().pathSum(root, 22));

        TreeNode root2 = new TreeNode(-2, null, new TreeNode(-3));
        System.out.println(new PAthSumII().pathSum(root2, -5));
        
        
    }
}