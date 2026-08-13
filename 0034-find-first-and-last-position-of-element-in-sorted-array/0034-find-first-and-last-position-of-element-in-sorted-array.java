class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPos = findFirst(nums,target);
        int secondPos = findLast(nums,target);

        return new int[]{firstPos,secondPos};
    }

    public int findFirst(int nums[],int target){
        int l = 0;
        int h = nums.length - 1;
        int ans = -1;

        while( l <= h){
            int mid = (l + h)/2;

            if(nums[mid] == target){
                ans = mid;
                h = mid - 1;
            }
            else if(nums[mid] > target){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
    public int findLast(int nums[],int target){
        int l = 0;
        int h = nums.length - 1;
        int ans = -1;

        while( l <= h){
            int mid = (l + h)/2;

            if(nums[mid] == target){
                ans = mid;
                l = mid + 1;
            }
            if(nums[mid] > target){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna