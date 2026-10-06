class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i<n; i++){
            if(s.charAt(i)=='(') st.push('(');
            else if(st.isEmpty()) ans++;
            else st.pop();
        }
        if(!st.isEmpty()) ans+=st.size();
        return ans;
    }
}