class Solution {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {

                int sum;

                if(i == 0)
                    sum = prefix[j];
                else
                    sum = prefix[j] - prefix[i - 1];

                if(sum == k)
                    count++;
            }
        }

        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna