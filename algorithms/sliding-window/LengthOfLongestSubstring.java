import java.util.HashSet;

/**
 * 
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */

public class LengthOfLongestSubstring {

    /**
     * 
     * @param s consists of English letters, digits, symbols and spaces.  0 <= s.length <= 5 * 10^4
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> distinctLetter = new HashSet<>();
        int maxCount = 0;
        int windowStart = 0;
        for (int windowEnd=0 ; windowEnd<s.length(); windowEnd++){
            char ch = s.charAt(windowEnd);
            
            while(distinctLetter.contains(ch)){
                distinctLetter.remove(s.charAt(windowStart++));
            }
            
            distinctLetter.add(ch);
            maxCount = Math.max(maxCount, windowEnd-windowStart+1);
        }
        return maxCount;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
