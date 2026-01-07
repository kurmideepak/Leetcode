public class _347_Top_K_Frequent_Element {
    // Copy and Paste it in Solution Class in Leetcode

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map <Integer, Integer> count = new HashMap<>();
        for(int i : nums){
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        Map <Integer, Integer> orderedCount = new LinkedHashMap<>();
        count.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> orderedCount.put(x.getKey(), x.getValue()));
        for(int i : orderedCount.keySet()){
            res[res.length - (k--)] = i;
            if (k==0){
                break;
            }
        }
        return res;
    }
}
