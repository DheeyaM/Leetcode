class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
         if (t.length() == 0 || s.length() < t.length()) {
    return "";
    }
        for (int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if (!tMap.containsKey(c)){
                tMap.put(c, 1);
            } else {
                tMap.put(c, tMap.get(c) + 1);
            }
        }

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int satisfied = 0;
        int required = tMap.size();
        int startIndex = 0;

        for (int r = 0; r< s.length(); r++){
            char c = s.charAt(r);
            if (tMap.containsKey(c)) {
           if (!windowMap.containsKey(c)){
            windowMap.put(c, 1);
           }
            else {
                windowMap.put(c, windowMap.get(c) + 1);
            }

            if (tMap.containsKey(c) && (tMap.get(c).equals(windowMap.get(c)))){
                satisfied++;
            }
            }

            while (satisfied == required){
                int windowSize = r - l +1;
                if (windowSize < minLen){
                    minLen = windowSize;
                    startIndex = l;
                }
                
            char removed = s.charAt(l);
        if (tMap.containsKey(removed)) {
    windowMap.put(removed, windowMap.get(removed) - 1);


            if (tMap.containsKey(removed) && tMap.get(removed) > windowMap.get(removed)){
                satisfied--;
            }
        }
            l++;
            }


        }//end loop

        if (minLen == Integer.MAX_VALUE){
            return "";
        }
       

         return s.substring(startIndex, startIndex + minLen);
        
}
}