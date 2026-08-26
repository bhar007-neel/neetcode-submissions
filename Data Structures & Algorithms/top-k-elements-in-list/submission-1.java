
class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        // Bucket index represents frequency.
        // Example: bucket[3] will contain numbers that appear 3 times.
        List<Integer>[] bucket = new List[nums.length + 1];

        // HashMap stores:
        // number -> how many times it appears
        Map<Integer, Integer> frequencyMap = new HashMap<>();


        // STEP 1: Count frequency of every number
        for (int n : nums) {

            // If n exists, get its frequency and add 1.
            // If n does not exist, start from 0 and add 1.
            frequencyMap.put(
                n,
                frequencyMap.getOrDefault(n, 0) + 1
            );
        }


        // STEP 2: Put each number into its frequency bucket
        for (int key : frequencyMap.keySet()) {

            // Get how many times this number appeared
            int frequency = frequencyMap.get(key);

            // If this bucket does not exist yet,
            // create a new ArrayList for it
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            // Add the number to its frequency bucket
            bucket[frequency].add(key);
        }


        // Array that will store our final k answers
        int[] res = new int[k];

        // Keeps track of how many answers we added
        int counter = 0;


        // STEP 3: Start from the highest possible frequency
        // and move backwards
        for (
            int pos = bucket.length - 1;
            pos >= 0 && counter < k;
            pos--
        ) {

            // Only check buckets that actually contain numbers
            if (bucket[pos] != null) {

                // There may be multiple numbers
                // with the same frequency
                for (Integer integer : bucket[pos]) {

                    // Add number to result
                    // Then increase counter
                    res[counter++] = integer;
                }
            }
        }


        // Return the k most frequent elements
        return res;
    }
}