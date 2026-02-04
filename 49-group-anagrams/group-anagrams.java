class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++){
            String word = strs[i];

            int[] count = new int[26];
            for (int j = 0; j< word.length(); j++){
                char c = word.charAt(j);
                count[c - 'a']++;
            }

            String key = "";
            for (int k = 0; k < count.length; k++){
                key += count[k] + "#";
            }

            if (!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(word);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> group : map.values()){
            res.add(group);
        }

        return res;
        
    }
}