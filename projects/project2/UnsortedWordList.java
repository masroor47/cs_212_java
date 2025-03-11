/**
 * Very simple class. Extends WordList and adds the append method.
 */

public class UnsortedWordList extends WordList {

    public UnsortedWordList() {
        super();
    }

    /**
     * Simply appends the new String to the end of the linked lists.
     * <p>
     * Creates a new Node with the given string as data.
     * @param toAdd A String, not a Node to be added to the end of the list.
     */

    public void append(String toAdd) {
        WordNode newTail = new WordNode(toAdd);
        this.tail.next = newTail;
        this.tail = newTail;
        this.count++;
    }


}
