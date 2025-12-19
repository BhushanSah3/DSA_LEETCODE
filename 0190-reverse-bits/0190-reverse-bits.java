class Solution {
    public int reverseBits(int n) {
        // Example: n = 5 → "101"
        String binary = Integer.toBinaryString(n);

        // STEP 2: Pad the binary string to make it exactly 32 bits
        // %32s ensures length = 32
        // replace(' ', '0') converts leading spaces to 0 

        //yeh sirf 3 digits ka haii magar humko 32 chaiyeh so yiske aage space banjate haii so  un spaces ko humm zeros meh convert karte haii 
        // Example: "101" → "00000000000000000000000000000101"

        String paddedBinary = String.format("%32s", binary).replace(' ', '0');

        // STEP 3: Reverse the 32-bit binary string
        // Example:
        // "00000000000000000000000000000101"
        // → "10100000000000000000000000000000"
        String reversedBinary = new StringBuilder(paddedBinary).reverse().toString();
        //here paddedbinary is reversed then converted into string and stored as string 

        // STEP 4: Convert reversed binary back to decimal number
        // parse as long to avoid overflow, then cast to int
        return (int) Long.parseLong(reversedBinary, 2);

    }
}