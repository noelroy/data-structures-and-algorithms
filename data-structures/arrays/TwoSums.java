import java.util.*;

/**
 * 
 * 1. Two Sum
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * 
 * Assume one correct pair is present
 * 
 * Example :
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 */
public class TwoSums {

    public int[] twoSum(int[] nums, int target) {
        // HashMap method
        Map<Integer,Integer> targets = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(targets.containsKey(num)){
                return new int[]{i, targets.get(num)};
            } else {
                targets.put(target-num, i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSums twoSum = new TwoSums();
        twoSum.twoSum(new int[]{2,7,11,15}, 9);
    }
}
