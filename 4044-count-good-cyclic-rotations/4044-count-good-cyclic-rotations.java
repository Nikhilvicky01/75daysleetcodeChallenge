class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long leftsum = 0;
        long rightsum = 0;
        int count  = 0;
        for(int i = 0; i < n ;i ++){
            sum += nums[i];
        }

        for(int i = 0; i < n/2; i ++){
            leftsum = leftsum + nums[i];
        }
        rightsum = sum -leftsum;

        for(int i = 0;i < n; i ++){
            if( leftsum > rightsum){
                count ++ ;
            }
            leftsum =  leftsum - nums[i] +nums[(n/2 + i) % n];
            rightsum = rightsum - nums[(n/2 + i) % n] + nums[i];
        }
        return count;
    }
}