class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[1], a[1]));

        for(int[] boxType:boxTypes){
            pq.add(boxType);
        }
        int ans = 0;
        while (!pq.isEmpty() && truckSize > 0) {

            int[] temp = pq.poll();

            int boxes = temp[0];
            int units = temp[1];

            int take = Math.min(boxes, truckSize);

            ans += take * units;

            truckSize -= take;
        }
        return ans;
    }
}