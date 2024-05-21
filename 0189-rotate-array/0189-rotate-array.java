class Solution {
    public void swap(int nums[], int low, int high) {
        int temp;
        temp = nums[high];
       nums[ high] = nums[low];
        nums[low] = temp;

    }

    public void reverse(int nums[], int low, int high) {
        while (low < high) {
            swap(nums,low, high);
            low++;
            high--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
}