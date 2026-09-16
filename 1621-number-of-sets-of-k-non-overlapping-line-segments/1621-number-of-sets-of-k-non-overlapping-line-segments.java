class Solution {
    static final long MOD = 1_000_000_007L;

    public int numberOfSets(int n, int k) {
        long[][] dp = new long[n + k][2 * k + 1];

        // dp[i][j] = ways to choose j elements from first i elements
        dp[0][0] = 1;

        for (int i = 1; i < n + k; i++) {
            dp[i][0] = 1;

            for (int j = 1; j <= 2 * k; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j <= i) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
                }
            }
        }

        return (int) dp[n + k - 1][2 * k];
    }
}