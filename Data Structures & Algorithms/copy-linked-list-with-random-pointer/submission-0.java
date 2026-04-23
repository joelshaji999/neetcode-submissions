/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        hm.put(null, null);
        
        Node curr = head;
        while(curr != null) {
            if(!hm.containsKey(curr)) {
                hm.put(curr, new Node(0));
            }

            hm.get(curr).val =  curr.val;

            if(!hm.containsKey(curr.next)) {
                hm.put(curr.next, new Node(0));
            }

            hm.get(curr).next = hm.get(curr.next);

            if(!hm.containsKey(curr.random)) {
                hm.put(curr.random, new Node(0));
            }

            hm.get(curr).random = hm.get(curr.random);

            curr = curr.next;
        }

        return hm.get(head);
    }
}
