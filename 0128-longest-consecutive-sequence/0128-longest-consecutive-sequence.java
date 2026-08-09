class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();

        for(int num:nums){
            set.add(num);
        }

        int longest = 0;

        for(int num:set){
            if(!set.contains(num - 1)){
                int currNum = num;
                int count = 1;

                while(set.contains(currNum + 1)){
                    currNum ++ ;
                    count ++ ;
                }
                longest = Math.max(longest,count);
            }
            
        }
        return longest;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna