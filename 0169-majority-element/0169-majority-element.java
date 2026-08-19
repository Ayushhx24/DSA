class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for(int i = 0; i<nums.length;i++){
            if(count == 0){
                candidate = nums[i];
                count = 1;
            }

            else if(nums[i] == candidate){
                count++;
            }

            else{
                count --;
            }
        }

        int check = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] == candidate){
                check++;
            }
        }
        if(check>(nums.length)/2){
            return candidate;
        }
        return 0;
    }

}