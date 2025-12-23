class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for ( String word : strs){
            

            int[] count = new int[26];
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            count[c - 'a']++;
        }

        String key = "";
        for (int j = 0; j < count.length ; j++){
            key += count[j] + "#";
        }

        if (!map.containsKey(key)){
            map.put(key, new ArrayList<String>());
        }
            map.get(key).add(word);
        

        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> groups : map.values()){
            result.add(groups);
        }
        return result;

    }
}