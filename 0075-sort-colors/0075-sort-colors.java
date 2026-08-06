class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)
             zero ++;
            else if(nums[i] == 1)
             one ++;
            else
            two ++;
        }
        int j = 0;
        while(zero!=0){
            nums[j] = 0;
            j++ ;
            zero--;
        }
        while(one!=0){
            nums[j] = 1;
            j++ ;
            one -- ;
        }
        while(two!=0){
            nums[j] = 2;
            j++ ;
            two -- ;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna