class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i]*nums[i];
        }
        for(int i=0;i<nums.length;i++){
            int minPos = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[minPos]>nums[j]){
                    minPos = j;
                }
            }
            int temp=nums[i];
            nums[i] = nums[minPos];
            nums[minPos] = temp;
        }
        return nums;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna