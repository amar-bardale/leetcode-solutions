class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = {-1, -1};

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        int firstCritical = -1;
        int prevCritical = -1;

        int minDist = Integer.MAX_VALUE;

        while (curr.next != null) {

            // Check if current node is a critical point
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                // First critical point
                if (firstCritical == -1) {
                    firstCritical = index;
                }

                // Calculate distance from previous critical point
                if (prevCritical != -1) {
                    minDist = Math.min(minDist, index - prevCritical);
                }

                prevCritical = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Fewer than 2 critical points
        if (firstCritical == -1 || firstCritical == prevCritical) {
            return ans;
        }

        // Maximum distance = last critical - first critical
        int maxDist = prevCritical - firstCritical;

        ans[0] = minDist;
        ans[1] = maxDist;

        return ans;
    }
}