class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                count++;
            }
        }
        if(count == 1 && nums[0] >= nums[nums.length-1]){
            return true;
        }
        if(count == 0)
        return true;
        else
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna