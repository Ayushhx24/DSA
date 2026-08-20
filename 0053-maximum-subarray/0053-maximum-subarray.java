class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        long maxi = Long.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            sum = sum+nums[i];
             if (sum > maxi) {
                maxi = sum; 
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return (int) maxi;
    }
}