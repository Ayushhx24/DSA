class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int oddCount = 0;
        int midChar = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = i;
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int m = n / 2;
        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        // Try matching prefix of length i from target
        for (int i = m; i >= 0; i--) {
            int[] currentHalf = halfCount.clone();
            boolean possible = true;
            for (int j = 0; j < i; j++) {
                int c = target.charAt(j) - 'a';
                if (currentHalf[c] > 0) {
                    currentHalf[c]--;
                } else {
                    possible = false;
                    break;
                }
            }
            if (!possible) continue;

            // Case 1: Match first half completely (i == m)
            if (i == m) {
                if (n % 2 != 0) {
                    // Try middle characters >= target[m]
                    int targetMid = target.charAt(m) - 'a';
                    for (int c = targetMid; c < 26; c++) {
                        if (c == midChar) {
                            String res = buildPalindrome(target.substring(0, m), (char) ('a' + midChar), n % 2 != 0);
                            if (res.compareTo(target) > 0) return res;
                        }
                    }
                } else {
                    String res = buildPalindrome(target.substring(0, m), ' ', false);
                    if (res.compareTo(target) > 0) return res;
                }
                continue;
            }

            // Case 2: Diverge at position i with a larger character
            int startChar = target.charAt(i) - 'a' + 1;
            for (int c = startChar; c < 26; c++) {
                if (currentHalf[c] > 0) {
                    currentHalf[c]--;

                    StringBuilder prefix = new StringBuilder(target.substring(0, i));
                    prefix.append((char) ('a' + c));

                    for (int ch = 0; ch < 26; ch++) {
                        while (currentHalf[ch] > 0) {
                            prefix.append((char) ('a' + ch));
                            currentHalf[ch]--;
                        }
                    }

                    char mid = (n % 2 != 0) ? (char) ('a' + midChar) : ' ';
                    String res = buildPalindrome(prefix.toString(), mid, n % 2 != 0);
                    if (res.compareTo(target) > 0) return res;
                }
            }
        }

        return "";
    }

    private String buildPalindrome(String firstHalf, char mid, boolean isOdd) {
        StringBuilder sb = new StringBuilder(firstHalf);
        if (isOdd) {
            sb.append(mid);
        }
        for (int i = firstHalf.length() - 1; i >= 0; i--) {
            sb.append(firstHalf.charAt(i));
        }
        return sb.toString();
    }
}