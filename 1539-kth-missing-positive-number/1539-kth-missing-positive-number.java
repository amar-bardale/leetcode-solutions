class Solution {
    public int findKthPositive(int[] arr, int k) {

        int p = 0;
        int[] nums = new int[k];
        int n = 0;
        int num = 1;

        while (n < k && p < arr.length) {

            if (arr[p] != num) {
                nums[n] = num;
                n++;
            } 
            else {
                p++;
            }

            num++;
        }

        if (n < k) {
            num = arr[arr.length - 1] + 1;

            while (n < k) {
                nums[n] = num;
                num++;
                n++;
            }
        }

        return nums[k - 1];
    }
}