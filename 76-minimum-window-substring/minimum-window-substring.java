class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        if (t.length() == 0 || s.length() < t.length()){
            return "";
        }

        for (int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if (!tMap.containsKey(c)){
                tMap.put(c, 1);
            }
            else {
                tMap.put(c, tMap.get(c) +1 );
            }
        }

        int l = 0;
        int startIndex = 0;
        int minLen = Integer.MAX_VALUE;
        int required = tMap.size();
        int satisfied = 0;

        for (int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            if (tMap.containsKey(c)){
                if (!window.containsKey(c)){
                    window.put(c,1);
                } else {
                    window.put(c, window.get(c) + 1);
                }
            }

            if (tMap.containsKey(c) && tMap.get(c).equals(window.get(c))){
                satisfied++;
            }

            while (satisfied == required){
                int windowSize = r - l +1;
                if (windowSize < minLen){
                    minLen = windowSize;
                    startIndex = l;
                }

                char remove = s.charAt(l);
                if (tMap.containsKey(remove)){
                    window.put(remove, window.get(remove) -1);

                    if (window.get(remove) < tMap.get(remove)){
    satisfied--;
}

                    
                }
                l++;
            }

        }
        if (minLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(startIndex, startIndex + minLen);
    }
}