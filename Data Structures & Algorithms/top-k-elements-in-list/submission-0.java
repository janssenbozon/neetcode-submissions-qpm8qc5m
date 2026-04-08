class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for(Map.Entry<Integer, Integer> i : count.entrySet()) {
            pq.add(new int[]{i.getValue(), i.getKey()});
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] solution = new int[k];
        int index = 0;
        while(!pq.isEmpty()) {
            solution[index] = pq.poll()[1];
            index++;
        }
        return solution;
    }
}
