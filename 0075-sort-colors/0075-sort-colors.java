class Solution {
    public void sortColors(int[] nums) {
        int count_zero = 0;
        int count_one = 0;
        int count_two = 0;

        for(int i = 0; i<nums.length;i++){
            if(nums[i]==0)
            {
                count_zero++;
            }
            else if(nums[i]==1){
                count_one++;
            }        
            else{
                count_two++;
            }
}
        for (int i = 0; i < count_zero; i++) {
            nums[i] = 0;
        }
        for (int i = count_zero; i < count_zero + count_one; i++) {
            nums[i] = 1;
        }
        for (int i = count_zero + count_one; i < nums.length; i++) {
            nums[i] = 2;
}
for(int i = 0; i<nums.length;i++){
    System.out.println(nums[i]);
}}}