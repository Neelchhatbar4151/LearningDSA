public class IncreasingOrDecreasingSubArray {
    public static void main(String[] args) {
        System.out.println(Helper(new int[]{1,4,3,3,2}));
    }
    public static int Helper(int[] nums){
        int maxCounter = 0, counter = 0,i = 0, j = 1;
        while(i < nums.length){
            // System.out.println("I: " + i);
            while(j < nums.length && nums[j] > nums[j-1]){
                // System.out.println("J: " + j);
                j++;
            }
            maxCounter = Math.max(maxCounter, j-i);
            if(i == j){
                i++;
                j++;
            }
            else{
                i = j;
            }
        }
        i=0;
        j=1;
        while(i < nums.length){
            // System.out.println("I: " + i);
            while(j < nums.length && nums[j] < nums[j-1]){
                // System.out.println("J: " + j);
                j++;
            }
            maxCounter = Math.max(maxCounter, j-i);
            if(i == j){
                i++;
                j++;
            }
            else{
                i = j;
            }
        }
        return maxCounter;
    }
}
