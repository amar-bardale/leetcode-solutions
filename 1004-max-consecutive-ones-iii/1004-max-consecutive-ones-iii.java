class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        for(int i = 0; i<n; i++){
            int zCnt = 0;
            for(int j = i; j<n; j++){
                if(nums[j]==0) zCnt++;
                if(zCnt>k) break;
                ans = Math.max(ans, j-i+1);
            }
        }
        return ans;
    }
}