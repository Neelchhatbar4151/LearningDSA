//https://leetcode.com/problems/find-all-anagrams-in-a-string/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        int k = p.length(),j = 0;

        for(int i=0;i<p.length();i++){
            if(hm.containsKey(p.charAt(i))){
                hm.put(p.charAt(i), hm.get(p.charAt(i))+1);
            }
            else{
                hm.put(p.charAt(i), 1);
            }
        }
        int count = hm.size();
        for(int i = 0;i<s.length()-(k-1);i++){
            while(j<i+k){
                if(hm.containsKey(s.charAt(j))){
                    int temp = hm.get(s.charAt(j));
                    hm.put(s.charAt(j), temp-1);
                    if(temp != 0){
                        if(temp == 1){
                            count--;
                        }
                    }
                }
                j++;
            }
            if(count == 0){
                ans.add(i);
            }
            if(hm.containsKey(s.charAt(i))){
                int temp = hm.get(s.charAt(i));
                hm.put(s.charAt(i), temp+1);
                if(temp == 0){
                    count++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
