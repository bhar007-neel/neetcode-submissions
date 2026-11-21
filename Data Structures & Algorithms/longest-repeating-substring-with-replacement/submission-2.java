class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Find the most frequent character
            int maxFreq = 0;
            for (int count : map.values()) {
                maxFreq = Math.max(maxFreq, count);
            }

            // Too many replacements? Shrink window
            while ((right - left + 1) - maxFreq > k) {

                char remove = s.charAt(left);
                map.put(remove, map.get(remove) - 1);
                left++;

                maxFreq = 0;
                for (int count : map.values()) {
                    maxFreq = Math.max(maxFreq, count);
                }
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
