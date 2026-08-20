class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int a1 = 0, a2 = 0;
        for(int i = 2; i<n; i++){
            if(arr1[a1]>arr2[a2]){
                arr1[++a1] = nums[i];
            }
            else arr2[++a2] = nums[i];
        }

        for(int i = 0; i<=a1; i++){
            res[i] = arr1[i];
        }

        for(int i = 0; i<=a2; i++){
            res[i+a1+1] = arr2[i];
        }

        return res;
    }
}