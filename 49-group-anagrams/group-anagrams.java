class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++){
            String word = strs[i];

            int[] count = new int[26];

            for (int k = 0; k < word.length() ; k++){
                char c = word.charAt(k);
                count[c - 'a']++;
            }

            String key = "";
            for (int l = 0; l < count.length; l++){
                key += count[l] + "#";
            }

            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
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