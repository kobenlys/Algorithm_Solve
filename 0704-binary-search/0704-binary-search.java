class Solution {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) >> 1;

            if(target > nums[mid]) {
                left = mid + 1;
            } else {
                if(target == nums[mid]) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return -1;
    }
}