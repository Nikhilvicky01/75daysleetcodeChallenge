class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        // right[i] = nums[i] se last tak ka minimum
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }

        // left = 0 se i tak ka maximum
        int left = 0;

        for (int i = 0; i < n; i++) {
            left = Math.max(left, nums[i]);

            // Instability score <= k
            if (left - right[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}