class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int temp = n;
        while(temp>0){
            int digit = temp%10;
            prod = prod*digit;
            sum += digit;
            temp /=10;
        }
        return n%(sum+prod) == 0;
    }
}