class BusBooking {
    private boolean[][] booked;
    private int[][] cost;
    private int totalTime;
    private int bookedCount;

    public BusBooking(int n) {
        booked = new boolean[n + 1][4];
        cost = new int[n + 1][4];
        totalTime = 0;
        bookedCount = 0;
    }

    public void toggle(String seat) {
        int row = Integer.parseInt(seat.substring(1));

        char ch = seat.charAt(0);
        int col = ch - 'A';

        if (booked[row][col]) {
            totalTime -= cost[row][col];
            booked[row][col] = false;
            bookedCount--;
            return;
        }

        int bookingCost = 1;

        if (ch == 'A' && booked[row][1]) {
            bookingCost = 3;
        } else if (ch == 'D' && booked[row][2]) {
            bookingCost = 3;
        }

        booked[row][col] = true;
        cost[row][col] = bookingCost;

        totalTime += bookingCost;
        bookedCount++;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public int getMinTime() {
        return bookedCount;
    }
}