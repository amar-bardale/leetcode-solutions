class Solution {
    private void solve(int ind, int n, int target, int[] nums, List<List<Integer>> ans, List<Integer> temp, Set<List<Integer>> set){
        if(target==0){
            if(!set.contains(temp)){
                ans.add(new ArrayList<>(temp));
                set.add(new ArrayList<>(temp));
            }
            return;
        }
        
        for(int i = ind; i<n; i++){
            if(i>ind && nums[i]==nums[i-1]) continue;

            if(nums[i]>target) break;

            temp.add(nums[i]);
            solve(i+1, n, target-nums[i], nums, ans, temp, set);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = candidates.length;
        Set<List<Integer>> set = new HashSet<>();
        solve(0, n, target, candidates, ans, temp, set);
        return ans;
    }
}