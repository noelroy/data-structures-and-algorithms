import java.util.*;

class SlidingWindow {

    /**
     * Fixed Window
     * 
     * Find the max sum subarray of a fixed size K
     * 
     * @param arr the array
     * @param windowSize window size
     * @return
     */
    public static int findMaxSumGivenWindowSize(int[] arr, int windowSize) {
        int maxSum = Integer.MIN_VALUE;
        int currentValue = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentValue += arr[windowEnd];
            if(windowEnd >= (windowSize - 1)){
                maxSum = Math.max(currentValue, maxSum);
                currentValue -= arr[windowEnd - (windowSize - 1)];
            }
        }
        return maxSum;
    }

    /**
     * Dynamically resizable window
     * 
     * Find the smallest subarray with given target sum
     *
     * @param arr the array
     * @param targetSum target sum
     * @return
     */
    public static int findSmallestSubArrayGivenSum(int[] arr, int targetSum) {
        int currentSum = 0;
        int minSize = Integer.MAX_VALUE;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentSum += arr[windowEnd];
            while(currentSum >= targetSum) {
                minSize = Math.min(minSize, (windowEnd - windowStart + 1));
                currentSum -= arr[windowStart++];
            }
        }
        return minSize;
    }

    /**
     * Dynamically resizable window with auxillary data structure
     * 
     * Find longest substring length with K distinct characters
     * @param chars
     * @param k
     * @return
     */
    public static int longestSubstringKDistinct(String chars, int k) {
        int maxCount = 0;
        Map<Character, Integer> distinctChars = new HashMap<>();
        int windowStart = 0, windowEnd = 0;
        for(windowEnd=0 ; windowEnd<chars.length() ; windowEnd++){
            addCharacter(distinctChars, chars.charAt(windowEnd));
            while (distinctChars.size()>k && windowStart < windowEnd) {
                deleteCharacter(distinctChars, chars.charAt(windowStart++));
            }
            if(distinctChars.size()==k){
                maxCount = Math.max(maxCount, windowEnd-windowStart+1);
            }
        }
        return maxCount;
    }

    private static void deleteCharacter(Map<Character, Integer> distinctChars, char ch) {
        distinctChars.put(ch, distinctChars.get(ch)-1);
        if(distinctChars.get(ch) == 0)
            distinctChars.remove(ch);
    }

    private static void addCharacter(Map<Character, Integer> distinctChars, char ch){
        distinctChars.put(ch, distinctChars.getOrDefault(ch, 0)+1);
    }

    public static void main(String[] args){
        int max = findMaxSumGivenWindowSize(new int[]{6,7,9,4,5,6,7,8},3);
        System.out.println(max);

        int small = findSmallestSubArrayGivenSum(new int[]{5,1,1,1,1,1,1,1},8);
        System.out.println(small);

        System.out.println(longestSubstringKDistinct("AAAHHIBC", 3));
    }
}