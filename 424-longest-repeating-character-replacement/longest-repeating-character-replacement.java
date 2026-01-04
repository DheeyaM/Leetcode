class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0;
        int maxFreq = 0;

        for (int r = 0; r < s.length(); r++){
            char c = s.charAt(r);

            if (!map.containsKey(c)){
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
            maxFreq = Math.max(maxFreq, map.get(c));

            while ((r-l+1) - maxFreq > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) -1 );
                l++;
            }

            maxLen = Math.max((r-l+1), maxLen);

        }
        return maxLen;
    }
}