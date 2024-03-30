import java.util.*;
public class MaximumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,5,36,7,3,4,85,1};
        int k = 3,j = 0, sum = 0;
        int[] ans = new int[nums.length-(k-1)];
        for(int i=0;i<nums.length-(k-1);i++){
            if(sum < i){
                sum = i;
            }
            while(j<i+k){
                if(nums[j] > nums[sum]){
                    sum = j;
                }
                j++;
            }
            ans[i] = nums[sum];
        }
        System.out.println(Arrays.toString(ans));
    }
}
