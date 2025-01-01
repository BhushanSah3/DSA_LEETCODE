class Solution {
    public int pivotInteger(int n) {
        for (int i = 1; i <= n; i++) {
            int sumLeft = calculateSum(1, i);
            int sumRight = calculateSum(i, n);
            
            if (sumLeft == sumRight) {
                return i; 
            }
        }
        return -1; 
    }

  
    private static int calculateSum(int start, int end) {
        return (end - start + 1) * (start + end) / 2;
    //  int sum = 0;
    // for (int i = start; i <= end; i++) {
    //     sum += i; // Add each number to the sum
    // }
    // return sum;
    } 

}