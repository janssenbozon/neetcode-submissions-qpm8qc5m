class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pile = new PriorityQueue<Integer>((a, b) -> b - a);
        for(int stone : stones) {
            pile.add(stone);
        }

        while(pile.size() != 1) {
            pile.add(pile.poll() - pile.poll());
        }

        return pile.poll();
    }
}
