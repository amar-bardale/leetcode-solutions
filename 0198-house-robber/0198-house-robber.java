class Solution {
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev = nums[0];
        int n = nums.length;

        for(int i = 1; i<n; i++){
            int pick = nums[i];
            if(i>1) pick+=prev2;

            int not = 0+prev;

            int curr = Math.max(pick, not);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}