class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int k = k1 + k2;

        int[] diff = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long low = 0, high = max;

        while (low < high) {
            long mid = low + (high - low) / 2;
            long operations = 0;

            for (int d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int target = (int) low;
        long remaining = k;

        for (int i = 0; i < n; i++) {
            if (diff[i] > target) {
                remaining -= diff[i] - target;
                diff[i] = target;
            }
        }

        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == target && target > 0) {
                diff[i]--;
                remaining--;
            }
        }

        long ans = 0;

        for (int d : diff) {
            ans += (long) d * d;
        }

        return ans;
    }
}