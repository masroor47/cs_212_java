/**
 * This Softed Linked List extends WordList and implements the 'add' method which keeps the list sorted.
 */

public class SortedWordList extends WordList {

    public SortedWordList() {
        super();
    }
    /**
     * This method inserts the given String into the list into an appropriate position to keep the list sorted.
     * <p>
     * To achieve this the funciton iterates through the linked list until it sees a node greater than the input.
     * <p>
     * If the current node is greater than input, then the input should be inserted right before.
     * @param toAdd A String to be inserted into the list. Not a Node type, but a regular String.
     */

    public void add(String toAdd) {
        WordNode newNode = new WordNode(toAdd);
        WordNode prev = this.head;
        WordNode curr = prev.next;

        if (curr == null) {
            this.head.next = newNode;
            this.tail = newNode;
            this.count++;        
            return;
        }
        // Iterates through the list.
        while (prev != null) {
            // If empty, just add to the end.
            if (curr == null) {
                prev.next = newNode;
                this.tail = newNode;
                break;
            }
            // If current node is greater than input, then input should be before this one.
            if (curr.val.compareTo(toAdd) >= 0) {
                newNode.next = curr;
                prev.next = newNode;
                break;
            }
            prev = curr;
            curr = curr.next;
            
        }

        this.count++;
    }


}
