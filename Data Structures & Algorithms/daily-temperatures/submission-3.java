

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            // Current temperature is warmer than
            // the temperature at the index on top of stack
            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int previousDay = stack.pop();

                result[previousDay] = i - previousDay;
            }

            stack.push(i);
        }

        return result;
    }
}