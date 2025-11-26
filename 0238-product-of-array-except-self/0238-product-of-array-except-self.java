class Solution {
    public int[] productExceptSelf(int[] nums) {
        //res[i] = product of all elements to the left of i  × product of all elements to the right of i
        int n = nums.length;
        int[] arr = new int[n];

        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = arr[i] * right;
            right = right * nums[i];
        }

        return arr;
    }
}
