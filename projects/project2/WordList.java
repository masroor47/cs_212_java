
/**
 * A linked list class for Strings. 
 * <p>
 * Must be extended to add functionality like append, add, pop etc.
 */

public class WordList {

    protected WordNode head;
    protected WordNode tail;
    protected int count;

    /**
     * This constructor creates a dummy node without any data to avoid a null node.
     */

    public WordList() {
        WordNode dummy = new WordNode();
        this.head = dummy;
        this.tail = dummy;
        this.count = 0;
    }

    /**
     * Overriding default toString method.
     * @return One long concatenated string joining all nodes first to last with -> in between
     */

    public String toString() {
        WordNode curr = this.head.next;
        String result = "";
        while (curr != null) {
            result += curr.val + " -> ";
            curr = curr.next;
        }
        return result;
    }
   
}
