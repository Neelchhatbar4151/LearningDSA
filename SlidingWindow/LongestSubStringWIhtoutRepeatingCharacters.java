//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.HashMap;
public class LongestSubStringWIhtoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 1){
            return 1;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = 0,j = 0;
        for(int i=0;i<s.length();i++){
            while(!(j == s.length()-1) && !hm.containsKey(s.charAt(j))){
                hm.put(s.charAt(j),j);
                j++;
            }
            // System.out.println(hm);
            if(j == s.length()-1){
                if(hm.containsKey(s.charAt(j))){
                    return Math.max(max, j-i);
                }
                else{
                    return Math.max(max,j-i+1);
                }
            }
            max = Math.max(max, j-i);
            // System.out.println(j);
            int temp = hm.get(s.charAt(j));
            for(int k=i;k<=temp;k++){
                if(hm.containsKey(s.charAt(k)) && hm.get(s.charAt(k)) == k){
                    hm.remove(s.charAt(k));
                }
            }
            i = temp;
        }
        return max;
    }
}
