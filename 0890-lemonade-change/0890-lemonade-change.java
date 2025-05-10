class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, cost = 5;

        for (int i = 0; i < bills.length; i++) {
            int trans = bills[i] - cost;

            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else { 
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
