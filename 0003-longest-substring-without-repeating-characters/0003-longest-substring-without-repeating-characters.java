class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int[] charMap = new int[128]; 
        
        for (int left = 0, right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            left = Math.max(charMap[currentChar], left); 

            maxLength = Math.max(maxLength, right - left + 1);
            charMap[currentChar] = right + 1; 
        }
        
        return maxLength;
    }
}