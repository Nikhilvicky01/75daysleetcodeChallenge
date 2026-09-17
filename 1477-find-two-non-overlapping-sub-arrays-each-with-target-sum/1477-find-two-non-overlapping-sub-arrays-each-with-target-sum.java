class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];          // dp[i] = min length of target-sum subarray ending <= i
        Arrays.fill(dp, Integer.MAX_VALUE);

        int left = 0, sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            // shrink window while sum exceeds target
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // carry forward best dp so far (default: same as previous index)
            dp[right] = (right > 0) ? dp[right - 1] : Integer.MAX_VALUE;

            if (sum == target) {
                int currLen = right - left + 1;

                // try combining with best subarray ending before 'left'
                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, dp[left - 1] + currLen);
                }

                // update dp[right] with this window's length
                dp[right] = Math.min(dp[right], currLen);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}