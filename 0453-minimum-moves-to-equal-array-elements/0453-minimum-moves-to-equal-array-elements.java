class Solution {
    public int minMoves(int[] nums) {
        int minElement = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length; i ++){
            if(nums[i] < minElement){
                minElement = nums[i];
            }
        }
        int move = 0;
        for(int i = 0;i < nums.length; i ++){
            move = move + (nums[i] - minElement);
        }

        return move ;
    }
}