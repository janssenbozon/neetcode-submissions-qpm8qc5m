class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // HashMap of node to prereqs
        HashMap<Integer, HashSet<Integer>> prereqs = new HashMap<Integer, HashSet<Integer>>(); 

        // Build map
        for(int[] pair : prerequisites) {
            prereqs.putIfAbsent(pair[0], new HashSet<Integer>());
            prereqs.get(pair[0]).add(pair[1]);
        } 

        HashSet<Integer> visited = new HashSet<Integer>();

        // Iterate through + dfs, incase it's a disconnected graph
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, visited, prereqs)) { return false; }
        }

        return true;
    }

    private boolean dfs(
        int i, 
        HashSet<Integer> visited, 
        HashMap<Integer, HashSet<Integer>> prereqs
    ) {
        // cycle!
        if(visited.contains(i)) { return false; }

        // no cycle!
        if(!prereqs.containsKey(i) || prereqs.get(i).isEmpty()) { return true ;}
        
        visited.add(i);
        // check neighbors
        for(int neighbor : prereqs.get(i)) {
            // neighbor is cycle? immediately no
            if (!dfs(neighbor, visited, prereqs)) { return false; };
        }
        visited.remove(i);
        prereqs.get(i).clear();

        // none of neighbors are in cycle? i am not in cycle!
        return true;
    }
}
