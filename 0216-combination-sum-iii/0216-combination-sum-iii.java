class Solution {
    private void solve(int ind, int k, int n, List<List<Integer>> ans, List<Integer> ds){
        if(k==0 && n==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = ind; i<=9; i++){
            ds.add(i);
            solve(i+1, k-1, n-i, ans, ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, k, n, ans, new ArrayList<>());
        return ans;
    }
}