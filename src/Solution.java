class Solution {
    public int maxSubArray(int[] nums) {
        int mx_sum = -1 * (10*10*10*10 + 1);
        int mx_end = 0;

        for (int i = 0; i < nums.length; i++){
            mx_end += nums[i];
            if (mx_sum < mx_end){
                mx_sum = mx_end;
            }
            if (mx_end < 0){
                mx_end = 0;
            }
        }

        return mx_sum;
    }
}
