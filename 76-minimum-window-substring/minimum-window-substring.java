class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        if (t.length() == 0 || s.length() < t.length()){
            return "";
        }

        for (int i = 0; i < t.length() ; i++){
            char c = t.charAt(i);
            if (!tmap.containsKey(c)){
                tmap.put(c,1);
            } else {
                tmap.put(c, tmap.get(c) +1);
            }
        }

        int start = 0;
        int l =0;
        int minLen = Integer.MAX_VALUE;
        int required = tmap.size();
        int satisfied = 0;

        for (int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            if (!window.containsKey(c)){
                window.put(c,1);
            } else {
                window.put(c, window.get(c)+1);
            }

            if (tmap.containsKey(c) && tmap.get(c).equals(window.get(c))){
                satisfied++;
            }

            while (satisfied == required){
                int windowSize = r - l +1;
                if (minLen > windowSize){
                    minLen = windowSize;
                    start = l;
                }

                char removed = s.charAt(l);
                if (tmap.containsKey(removed)){
                    window.put(removed, window.get(removed) -1);
                

                if (tmap.get(removed) > window.get(removed)){
                    satisfied--;
                }
            }
            l++;
            }
        }
        if (minLen == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(start, start + minLen);

    }
}