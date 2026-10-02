class Solution {
    private void solve(int ind, int n, int target, List<List<Integer>> ans, int[] candidates, List<Integer> temp){
        if(ind>=n || target<0) return;
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(candidates[ind]);
        solve(ind, n, target-candidates[ind], ans, candidates, temp);
        temp.remove(temp.size() - 1);
        solve(ind+1, n, target, ans, candidates, temp);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        List<Integer> temp = new ArrayList<>();
        solve(0, n, target, ans, candidates, temp);
        return ans;
    }
}