import java.util.HashMap;
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> pattern = new HashMap<>();
        int k = s1.length(), n = s2.length();
        for(int i=0;i<k;i++){
            if(pattern.containsKey(s1.charAt(i))){
                pattern.put(s1.charAt(i), pattern.get(s1.charAt(i))+1);
            }
            else{
                pattern.put(s1.charAt(i), 1);
            }
        }
        int i=0,j=0;
        HashMap<Character, Integer> hm = new HashMap<>();
        while(i <= n-k){
            while(j < i+k){
                if(hm.containsKey(s2.charAt(j))){
                    hm.put(s2.charAt(j), hm.get(s2.charAt(j))+1);
                }
                else{
                    hm.put(s2.charAt(j), 1);
                }
                j++;
            }
            if(hm.equals(pattern)){
                return true;
            }
            int value = hm.get(s2.charAt(i));
            if(value == 1){
                hm.remove(s2.charAt(i));
            }
            else{
                hm.put(s2.charAt(i), hm.get(s2.charAt(i))-1);
            }
            i++;
        }
        return false;
    }
}
