class Solution {
    public String toLowerCase(String s) {
        char chArray[] = s.toCharArray();
        for(int i = 0; i < chArray.length; i++){
            char ch = chArray[i];
            if(ch >= 'A' && ch <= 'Z') chArray[i] = (char)(ch + 32); 
        }
        return new String(chArray);
    }
}