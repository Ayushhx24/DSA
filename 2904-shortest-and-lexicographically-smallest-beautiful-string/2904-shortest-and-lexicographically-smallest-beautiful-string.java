class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int onesCount = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                onesCount++;
            }

            while (onesCount == k) {
                while (s.charAt(left) == '0') {
                    left++;
                }

                int currentLen = right - left + 1;
                String currentSub = s.substring(left, right + 1);

                if (currentLen < minLen) {
                    minLen = currentLen;
                    ans = currentSub;
                } else if (currentLen == minLen) {
                    if (currentSub.compareTo(ans) < 0) {
                        ans = currentSub;
                    }
                }

                if (s.charAt(left) == '1') {
                    onesCount--;
                }
                left++;
            }
        }
        return ans;
    }
}