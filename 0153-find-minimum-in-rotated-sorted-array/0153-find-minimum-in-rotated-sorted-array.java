class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;

        while (l < h) {
            int mid = l + (h - l) / 2;

            if (nums[mid] > nums[h]) {
                // Minimum is in the right half
                l = mid + 1;
            } else {
                // Minimum is at mid or in the left half
                h = mid;
            }
        }

        return nums[l];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna