public class LargestSubArrayOfSumK {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 1, 1, 1, 1, 2, 3, 5};
        int k = 5, j = 0, sum = 0, max = 0;
        for(int i=0;i<nums.length;i++){
            while(j<nums.length && sum < k){
                sum += nums[j];
                j++;
            }
            if(sum == k){
                if(max < j-i){
                    max = j-i;
                }
            }
            sum -= nums[i];
            
        }
        System.out.println(max);
    }
}
