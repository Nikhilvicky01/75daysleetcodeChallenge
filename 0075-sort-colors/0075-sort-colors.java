class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;

        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                two++;
            }
        }
        int index = 0;
        while (zero > 0) {
            nums[index] = 0;
            index++;
            zero--;
        }

        while (one > 0) {
            nums[index] = 1;
            index++;
            one--;
        }
        while (two > 0) {
            nums[index] = 2;
            index++;
            two--;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna