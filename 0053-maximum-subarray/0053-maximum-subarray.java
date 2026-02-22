class Solution {
    public int maxSubArray(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int left = 0, right = 0;
        int sum = 0;

        while(right != nums.length) {
            
            sum += nums[right];
            answer = Math.max(answer, sum);
            
            if(sum <= 0) {
                left = right;
                sum = 0;
            }

            right++;
        }

        return answer;
    }
}