class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        Arrays.sort(nums);
        int k = 0;

        for(int i = 0;i < nums.length;i ++){
            k ++ ;
            if(i == n - 1 || nums[i] != nums[i + 1]){
                if(( n/3) < k ){
                    result.add(nums[i]);
                }
                k = 0 ;
            }
            
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna