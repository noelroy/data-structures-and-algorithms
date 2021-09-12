
/**
 * 
 * 283. Move Zeroes
 * 
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * 
 * Example:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        // Use two pointer algorithm
        int start=0;
        for(int end=0 ; end<nums.length; end++){
            if(nums[end]!=0){
                nums[start++]=nums[end];
            }
        }
        for(int i=start ; i<nums.length ; i++){
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{0,1,0,3,12};
        moveZeroes(input);
        System.out.println(input);
    }
}
