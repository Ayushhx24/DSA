class Solution {
    public long minimumPerimeter(long neededApples) {
        long low = 0;
        long high = 100000;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long apples = 2 * mid * (mid + 1) * (2 * mid + 1);

            if (apples >= neededApples) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 8 * low;
    }
}