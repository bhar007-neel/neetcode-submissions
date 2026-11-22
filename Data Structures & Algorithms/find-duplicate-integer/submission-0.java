class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // step1 find where the slow and fast meets

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];

        }while(slow != fast);
// Step 2: Find the start of the cycle
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
