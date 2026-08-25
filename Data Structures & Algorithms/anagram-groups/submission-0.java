class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String newS = new String(c);


            if(!map.containsKey(newS)){
                map.put(newS, new ArrayList<>());
            }
            map.get(newS).add(s);

        }
        return new ArrayList(map.values());
    }
}
