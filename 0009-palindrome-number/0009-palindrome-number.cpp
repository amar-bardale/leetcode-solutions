class Solution {
public:
    bool isPalindrome(int x) {
        int n=x;
        long long rev_num=0;
        int i;
        if(x<0) return false;
        while(x!=0){
            i=x%10;
            rev_num=rev_num*10+i;
            x=x/10;
        }
        
        if (rev_num==n && rev_num<=INT_MAX) 
        {
            return true;
        }
        else{
            return false;
        }
    }
};