import java.util.Collections;

class Solution {
    public int largestPerimeter(int[] nums) {
        int check2 = 0, check1 = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i+1] + nums[i+2] >nums[i] ) {
               
                return nums[i] + nums[i + 2] + nums[i+1] ;

            }
            check2 = check1;
        }
        return 0;
    }
}