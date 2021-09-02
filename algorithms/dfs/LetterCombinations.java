import java.util.*;

/**
 * 
 * 17. Letter Combinations of a Phone Number
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * 
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombinations {

    /**
     * 
     * @param digits 0 <= digits.length <= 4.  digits[i] is a digit in the range ['2', '9'].
     * @return
     */
    private static List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
        Map<Character,String> digitLetterMap = new HashMap<>();
        digitLetterMap.put('2',"abc");
        digitLetterMap.put('3',"def");
        digitLetterMap.put('4',"ghi");
        digitLetterMap.put('5',"jkl");
        digitLetterMap.put('6',"mno");
        digitLetterMap.put('7',"pqrs");
        digitLetterMap.put('8',"tuv");
        digitLetterMap.put('9',"wxyz");

        dfs(digitLetterMap, result, digits, 0, new StringBuilder());

        return result;
    }

    private static void dfs(Map<Character,String> digitLetterMap, List<String>result, String digit, int currentIndex, StringBuilder soFar) {

        // Exit criteria - If the the current Index is the last index of the given number
        if(currentIndex==digit.length()){
            // Add the combination to result
            result.add(soFar.toString());
            return;
        }

        for(char ch : digitLetterMap.get(digit.charAt(currentIndex)).toCharArray()){
            soFar.append(ch);
            dfs(digitLetterMap, result, digit, currentIndex+1, soFar);
            // Remove the current node from the result array to check other combinations
            // Backtracking
            soFar.deleteCharAt(currentIndex);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }
}
