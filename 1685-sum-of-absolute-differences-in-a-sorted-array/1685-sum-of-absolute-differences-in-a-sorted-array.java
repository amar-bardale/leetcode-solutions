class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = nums[0];
        for(int i = 1; i<n; i++){
            pre[i] = pre[i-1]+nums[i];
        }
        suf[n-1] = nums[n-1];
        for(int i = n-2; i>=0; i--){
            suf[i] = suf[i+1]+nums[i];
        }
        for(int i = 0; i<n; i++){
            result[i] = ((nums[i]*i)-pre[i]) + (suf[i]-(nums[i]*(n-i-1)));
        }
        return result;
    }
}