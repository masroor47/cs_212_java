/**
 *  A WordNode class creates a Node for the linked lists.
 *  
 */

public class WordNode {
    public String val;
    public WordNode next;



    public WordNode() {
        val = null;
        next = null;
    }
    /**
     * @param data String to be stored in the node.
     */
    public WordNode(String data) {
        val = data;
        next = null;
    }
    /**
     * @param data String to be stored in the node.
     * @param next Next WordNode to be joined after this node.
     */
    public WordNode(String data, WordNode next) {
        val = data;
        this.next = next;
    }
}