class KthLargest {

    PriorityQueue<Integer> largest;
    int maxSize;

    public KthLargest(int k, int[] nums) {
        largest = new PriorityQueue<Integer>();
        maxSize = k;
        for(int i : nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        largest.add(val);
        if(largest.size() > maxSize) {
            largest.poll();
        }
        return largest.peek();
    }
}

