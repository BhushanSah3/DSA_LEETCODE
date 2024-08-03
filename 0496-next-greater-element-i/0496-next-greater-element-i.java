public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = -1;
            boolean found = false;
            for (int j = 0; j < nums2.length; j++) {
                int num2 = nums2[j]; // Declare num2 within the inner loop
                if (found && nums1[i] < num2) {
                    result[i] = num2;
                    break;
                }
                if (nums1[i] == num2) {
                    found = true;
                }
            }
        }
        return result;
    }
}
