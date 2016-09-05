/**
 * @author Cristian Miranda
 * @since 10/16/15 - 11:11
 */
public class Node {
    private char value;
    private int index;
    private Node next;

    public Node() {
    }

    public Node(char value, int index, Node next) {
        this.value = value;
        this.index = index;
        this.next = next;
    }

    public char getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

    public Node next() {
        return next;
    }

    public void setNext(Node ahead) {
        this.next = ahead;
    }

    public boolean hasNext() {
        return next() != null;
    }

    public void use() {
        this.value = 'U';
    }

    public boolean isControl() {
        return value == 'C';
    }

    public boolean isNotUsed() {
        return value != 'U';
    }

    public boolean isLed() {
        return value == 'L';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node node = (Node) o;

        if (value != node.value) {
            return false;
        }
        if (index != node.index) {
            return false;
        }
        return !(next != null ? !next.equals(node.next) : node.next != null);
    }

    @Override
    public int hashCode() {
        int result = (int) value;
        result = 31 * result + index;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return value + "(" + index + ")";
    }
}
