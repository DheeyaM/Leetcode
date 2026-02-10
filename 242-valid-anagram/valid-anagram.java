class Solution {
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()){
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            count[c -'a']++;
        }
        for (int k = 0; k < t.length(); k++){
            char c = t.charAt(k);
            count[c -'a']--;
        }

        for (int j = 0; j < count.length; j++){
            if (count[j] != 0){
                return false;
            }
        }

        return true;
    }
}