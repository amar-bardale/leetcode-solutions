class Solution {
    public boolean threeFibonacciSum(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        int sum = a+b+c;
        while(sum<=n){
            int m = b;
            sum = a+b+c;
            if(sum==n) return true;
            a = b;
            b = c;
            c = c+m;
        }
        return false;
    }
}