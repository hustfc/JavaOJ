package Solution;

public class Solution75 {
    /**
     * 颜色分类
     * @param nums
     */
    public void sortColors(int[] nums) {
        if(nums.length == 0) return;
        int p0 = 0, p2 = nums.length - 1, current = 0;
        while (current <= p2) {
            if(nums[current] == 0) {
                int temp = nums[p0];
                nums[p0++] = nums[current];
                nums[current++] = temp;
            }
            else if(nums[current] == 2) {
                int temp = nums[p2];
                nums[p2--] = nums[current];
                nums[current] = temp;
            }
            else current ++;
        }
    }
}
