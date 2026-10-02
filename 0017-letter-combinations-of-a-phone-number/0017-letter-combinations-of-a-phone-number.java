class Solution {
    private void solve(int ind, String digits, String[] map, List<String> ans, StringBuilder temp){
        if(ind == digits.length()){
            ans.add(temp.toString());
            return;
        }
        int digit = digits.charAt(ind)-'0';
        String letters = map[digit];
        for(int i = 0; i<letters.length(); i++){
            temp.append(letters.charAt(i));
            solve(ind+1, digits, map, ans, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] map = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        if(digits.length()==0) return ans;

        solve(0, digits, map, ans, new StringBuilder());
        return ans;
    }
}