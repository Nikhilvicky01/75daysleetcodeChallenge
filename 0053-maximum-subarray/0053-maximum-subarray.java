class Solution {
    public int maxSubArray(int[] nums) {
        int Maxsum = Integer.MIN_VALUE;
        int currsum = 0;

    for(int i = 0;i<nums.length;i++){
        currsum = currsum + nums[i];

        Maxsum = Math.max(Maxsum,currsum);

        if(currsum < 0){
            currsum = 0;
        }
        
    }
    return Maxsum ;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna