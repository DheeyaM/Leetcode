class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num,1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int key : map.keySet()){
            int freq = map.get(key);
            if (bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int count = 0;
        int[] res = new int[k];

        for (int i = bucket.length - 1; i >= 0 && count < k; i--){
            if (bucket[i] != null){
            for (int num : bucket[i]){
                res[count++] = num;
            }
            }
        }

return res;

    }
}