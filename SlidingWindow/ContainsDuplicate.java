import java.util.HashMap;

public class ContainsDuplicate {
    public static boolean containsNearbyDuplicateSPACE(int[] nums, int k) {
        //Space Oriented solution O(1)
        int j = 1;
        // int counter = 0;
        if(nums.length == 1){
            return false;
        }
        for(int i=0;i<(nums.length<=k?1:nums.length-k);i++){
            while(j<=(i+k>=nums.length?nums.length-1:i+k)){
                for(int l=i;l<j;l++){
                    // counter++;
                    if(nums[l] == nums[j]){
                        return true;
                    }
                }
                // counter++;
                j++;
            }
            // counter++;
        }
        // System.out.println(counter);
        return false;
    }   
    public static boolean containsNearbyDuplicateTIME(int[] nums, int k){
        //Time Oriented Solution O(N)
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
            else if(i-map.get(nums[i])<=k){
                 return true;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
    public static void main(String args[]){
        System.out.println(containsNearbyDuplicateSPACE(new int[]{1,2,3,1}, 3));
    }
}