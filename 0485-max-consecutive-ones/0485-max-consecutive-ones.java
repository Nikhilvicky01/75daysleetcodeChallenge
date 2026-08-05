class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int Max = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                count ++;
            }
            if(nums[i] == 0){
                count = 0;
            }
            Max = Math.max(count,Max);
        }
        return Max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna