class Solution {
    public int singleNumber(int[] nums) {
        int ans  = 0;

        for(int i = 0;i <= 31; i++){
            int count = 0;

            for(int num:nums){
                if((num & (1 << i)) != 0){
                    count ++ ;
                }
            }
            int div = count % 3;
            if(div != 0){
                ans = ans | (div << i);
            }

        }
        return ans;
    }
    
}