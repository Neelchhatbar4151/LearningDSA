//https://leetcode.com/problems/longest-repeating-character-replacement/description/

import java.util.HashMap;
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
		System.out.println(Helper("ABAB", 2));
		System.out.println(Helper("AABABBA", 1));
		System.out.println(Helper("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
	}
	public static int Helper(String s, int k){
	    HashMap<Character, Integer> occurances = new HashMap<>();
	    int i = 0,j = 0, maxLength = 0;
        while(j < s.length()){
            if(occurances.containsKey(s.charAt(j))) occurances.put(s.charAt(j), occurances.get(s.charAt(j))+1);
            else    occurances.put(s.charAt(j), 1);
            j++;
            int maxOccurance = 0;
            for(int value:occurances.values()){
                maxOccurance = Math.max(maxOccurance, value);
            }
            if(((j-i)-maxOccurance) <= k)   maxLength = Math.max(maxLength, (j-i));
            else{
                int temp = occurances.get(s.charAt(i));
                if(temp == 1)  occurances.remove(s.charAt(i++));
                else    occurances.put(s.charAt(i++), temp-1);
            }
        }
        return maxLength;
	}
}
