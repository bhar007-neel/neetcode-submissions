class Solution {

    // Encode List<String> into one String
    public String encode(List<String> strs) {

        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {

            // Store:
            // length + "#" + actual string
            //
            // Example:
            // "Hello" -> "5#Hello"

            encoded.append(str.length());
            encoded.append("#");
            encoded.append(str);
        }

        return encoded.toString();
    }


    // Decode one String back into List<String>
    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int j = i;

            // Find the "#" after the length
            while (str.charAt(j) != '#') {
                j++;
            }

            // Get the number before #
            // Example: "5#Hello"
            // substring(i, j) = "5"
            int length = Integer.parseInt(str.substring(i, j));

            // Actual string starts after #
            int start = j + 1;

            // Extract exactly 'length' characters
            String word = str.substring(start, start + length);

            result.add(word);

            // Move i to the next encoded string
            i = start + length;
        }

        return result;
    }
}