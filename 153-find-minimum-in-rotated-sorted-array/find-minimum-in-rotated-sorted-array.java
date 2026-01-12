class Solution {
    public int findMin(int[] nums) {

        int right = nums.length - 1;
        int left = 0;

        while (right > left){
            int mid = left + (right - left) /2;
            if (nums[right] < nums[mid]){
               left = mid+1 ;
            } else {
                right = mid;
            }

        }

        return nums[left];
        
    }
}