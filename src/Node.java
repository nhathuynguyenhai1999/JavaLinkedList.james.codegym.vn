public class Node {
    public String key;
    Node next;
    Object data;

    public Node(Object data){
        this.data = data;
        this.next = null;
    }
}
