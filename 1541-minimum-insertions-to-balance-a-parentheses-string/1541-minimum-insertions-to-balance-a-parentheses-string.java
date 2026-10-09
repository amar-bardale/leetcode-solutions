class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        int n = s.length();
        for(int i = 0; i<n; i++){
            if(s.charAt(i)=='(') st.push('(');
            else if(i+1<=n-1 && s.charAt(i+1)==')'){
                if(st.isEmpty()) ans++;
                else st.pop();
                i++;
            }
            else{
                ans++;
                if(!st.isEmpty()) st.pop();
                else ans++;
            }
        }
        if(!st.isEmpty()){
            ans+=st.size()*2;
        }
        return ans;
    }
}