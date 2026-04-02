/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> oldToNew = new HashMap<Node, Node>();

        return cloneGraphHelper(node, oldToNew);
    }

    public Node cloneGraphHelper(Node node, HashMap<Node, Node> oldToNew) {
        if(node == null) {
            return null;
        } else if (oldToNew.get(node) != null) {
            return oldToNew.get(node);
        } else {
            Node newNode = new Node();
            newNode.val = node.val;
            oldToNew.put(node, newNode);
            for(Node neighbor : node.neighbors) {
                newNode.neighbors.add(cloneGraphHelper(neighbor, oldToNew));
            }
            return newNode;
        }
    }
}