class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num, 1);
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

        int[] res = new int[k];
        int count = 0;

        for (int j = bucket.length - 1; j > 0 && count < k; j-- ){
            if (bucket[j] != null){
                for (int num: bucket[j]){
                    res[count++] = num;
                }
            }

        }
        return res;
    }
}