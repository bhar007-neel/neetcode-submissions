class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] newArray = new int[2*nums.length];
        // Copy nums into first half
        for (int i = 0; i < nums.length; i++) {
            newArray[i] = nums[i];
        }

        // Copy nums into second half
        for (int i = 0; i < nums.length; i++) {
            newArray[i + nums.length] = nums[i];
        }

        return newArray;
    }
}