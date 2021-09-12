/**
 * LongestWord
 * 
 * Return the longest word in the string
 * Ignore punctuation. Words may also contain numbers
 * 
 * Example:
 * Input: "fun&!! time"
 * Output: time
 * 
 */
public class LongestWord {

    public static String longestWord(String sen) {
        // code goes here  
        String max = "";
        StringBuilder currentMax = new StringBuilder();
        for(int i=0 ; i< sen.length() ; i++){
            currentMax.append(sen.charAt(i));
            if(!(Character.isAlphabetic(sen.charAt(i)) || Character.isDigit(sen.charAt(i)))){
                if(currentMax.length() > max.length()){
                    currentMax.deleteCharAt(currentMax.length()-1);
                    max = currentMax.toString();
                }
                currentMax.setLength(0);
            }
        }
        if(currentMax.length() > max.length()){
            return currentMax.toString();
        }
        return max;
    }
    
    public static void main (String[] args) {  
        // keep this function call here     
        System.out.print(longestWord("fun&!! time")); 
    }      
}