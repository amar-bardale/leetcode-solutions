class Solution {
    public int pivotInteger(int n) {
        int total = n*(n+1)/2;
        int sum = 0;
        for(int x = 1; x<=n; x++){
            sum+=x;
            total-=x-1;
            if(sum==total) return x;
        }
        return -1;
    }
}