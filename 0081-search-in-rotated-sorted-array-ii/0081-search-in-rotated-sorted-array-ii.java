class Solution {
    public boolean search(int[] nums, int target) {
        for(int i = 0;i < nums.length;i ++){
            if(nums[i] == target){
                return true;
            }
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna