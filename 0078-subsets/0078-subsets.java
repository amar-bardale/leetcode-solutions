class Solution {
    private void subset(int[] nums, int n, List<List<Integer>> ans, List<Integer> arr, int ind){
        if(ind==n){
            ans.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[ind]);
        subset(nums, n, ans, arr, ind+1);
        arr.remove(arr.size()-1);
        subset(nums, n, ans, arr, ind+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        subset(nums, n, ans, arr, 0);
        return ans;
    }
}