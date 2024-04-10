//https://leetcode.com/problems/substring-with-concatenation-of-all-words/

import java.util.*;

public class Hard1 {
    public static void main(String[] args) {
        // System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
        // System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
        // System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}));
        System.out.println(findSubstring("dddddddddddd", new String[]{"dddd","dddd"}));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        HashSet<Integer> lst = new HashSet<>();
        HashMap<String, Integer> pattern = new HashMap<>();
        int n = words[0].length(),m = words.length;
        for(int i=0;i<m;i++){
            if(pattern.containsKey(words[i]))
                pattern.put(words[i], pattern.get(words[i])+1);
            else
                pattern.put(words[i], 1);
        }
        for(int k=0;k<n;k++){
            int i=k, j = k;
            HashMap<String, Integer> hm = new HashMap<>();
            while(i <= s.length()-(n*m)){
                while(j < i+(n*m)){
                    String temp = s.substring(j, j+n);
                    if(hm.containsKey(temp))
                        hm.put(temp, hm.get(temp)+1);
                    else
                        hm.put(temp, 1);
                    j+=n;
                }
                if(hm.equals(pattern)){
                    lst.add(i);
                }
                String temp = s.substring(i, i+n);
                int value = hm.get(temp);
                if(value == 1)
                    hm.remove(temp);
                else
                    hm.put(temp, hm.get(temp)-1);
                i += n;
            }
        }
        return new ArrayList<>(lst);
    }
}
