class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        int n = nums.length;
        int score = 0;

        // Initially all elements are on the right
        for (int num : nums) {
            if (num == 1) {
                score++;
            }
        }

        int maxScore = score;

        // Division 0
        ans.add(0);

        for (int i = 0; i < n; i++) {

            // Move nums[i] from right to left
            if (nums[i] == 0) {
                score++;
            } else {
                score--;
            }

            int divide = i + 1;

            if (score > maxScore) {
                maxScore = score;
                ans.clear();
                ans.add(divide);
            } 
            else if (score == maxScore) {
                ans.add(divide);
            }
        }

        return ans;
    }
}