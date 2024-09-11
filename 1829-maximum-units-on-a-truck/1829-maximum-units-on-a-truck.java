class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int maxunit = 0;
        int tsize = truckSize;
        for (int i = 0; i < boxTypes.length; i++) {
            int noofbox = boxTypes[i][0];
            int perunitbox = boxTypes[i][1];
            if (noofbox < tsize) {
                maxunit += noofbox * perunitbox;
                tsize = tsize - noofbox;
            } else {
                maxunit = maxunit + tsize * perunitbox;
                break;

            }
        }
        return maxunit;
    }
}