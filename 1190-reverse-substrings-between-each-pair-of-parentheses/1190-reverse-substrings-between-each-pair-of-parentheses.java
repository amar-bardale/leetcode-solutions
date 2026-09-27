class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)==')'){
                int end = ans.length();
                int ptr = ans.length()-1;
                while(ans.charAt(ptr)!='('){
                    sb.append(ans.charAt(ptr));
                    ptr--;
                }
                ans.delete(ptr, end);
                ans.append(sb);
                sb.delete(0, sb.length());
            }
            else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}