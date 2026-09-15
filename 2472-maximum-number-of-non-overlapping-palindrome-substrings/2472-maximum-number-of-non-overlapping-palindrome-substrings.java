class Solution {
    public int maxPalindromes(String s, int k) {

        int n = s.length();

        // dp[i] = maximum number of non-overlapping palindromes
        // using characters from 0 to i-1
        int[] dp = new int[n + 1];

        // prev[j] tells whether s[j ... i-1] was palindrome
        // for the previous value of i
        boolean[] prev = new boolean[n];

        for (int i = 0; i < n; i++) {

            boolean[] curr = new boolean[n];

            // By default, don't take a palindrome ending at i
            dp[i + 1] = dp[i];

            for (int j = i; j >= 0; j--) {

                int len = i - j + 1;

                if (s.charAt(j) == s.charAt(i) &&
                    (len <= 2 || prev[j + 1])) {

                    curr[j] = true;

                    // Valid palindrome
                    if (len >= k) {
                        dp[i + 1] = Math.max(
                            dp[i + 1],
                            dp[j] + 1
                        );
                    }
                }
            }

            prev = curr;
        }

        return dp[n];
    }
}