class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;

        while(l <= h ){
            int mid = (l + h)/2;

            if(nums[mid] == target){
                return true;
            }

            //nhi pata ki konsa side sorted hai 
            if(nums[l] == nums[mid] && nums[h] == nums[mid]){
                l ++ ;
                h -- ;
            }else if( nums[l] <= nums[mid]){// left sorted array
                if(nums[l] <= target && nums[mid] > target){
                    h = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(nums[mid] < target && nums[h] >= target){
                    l = mid + 1;
                }else{
                    h = mid - 1;
                }
            }
        }    
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna