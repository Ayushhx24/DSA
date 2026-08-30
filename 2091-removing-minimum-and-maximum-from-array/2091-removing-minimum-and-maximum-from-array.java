class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max_idx = 0;
        int min_idx = 0;
        int n = nums.length;
        for(int i = 0; i< nums.length; i++){
            if(nums[i]< min){
                min = nums[i];
                min_idx = i;
            }

            if(nums[i]>max){
                max = nums[i];
                max_idx = i;
            }
        }
        int left = Math.min(min_idx, max_idx);
        int right = Math.max(min_idx, max_idx);
        int option1 = right + 1;
        int option2 = n - left;
        int option3 = (left + 1) + (n - right);
        return Math.min(option1, Math.min(option2, option3));
    }
}