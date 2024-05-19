class Solution {
    public int countPrimes(int num) {
          if (num < 2) {
            return 0;
        }
        boolean seive[] = new boolean[num + 1]; // Correct size for the sieve array
        for (int i = 2; i <= num; i++) {
            seive[i] = true; // Initialize all entries as true as not sure primes
        }

        for (int i = 2; i * i <= num; i++) {
            // i*i<= as number can exceed the total seive boolean array so no need to check
            // the squares of number greater than the array
            if (seive[i] == true) { // if my seive is marked as true theni will go it mark its multiples
                for (int j = i * i; j <= num; j += i) {
                    // why i*i coz we will start checjk the square of the number as number before
                    // the sqaure had already appeared in the previous multiples of number
                    //j += i coz the number is always increasing by the number itself  2*2=2+2
                    seive[j] = false; // Mark multiples of i as non-prime
                }
            }

        }
         int count = 0;
        for (int i = 2; i < num; i++) {
            if (seive[i]) {
                count++; // Count primes
            }
        }

        return count; // Return the total number of primes found
    }

}