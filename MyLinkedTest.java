public class MyLinkedTest {
    private Node head;
    private int numNodes;

    public MyLinkedTest(Object data) {
        this.head = new Node(data);
        this.numNodes = 1;
    }

    public void add(Object data) {
        addLast(data);
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        numNodes++;
    }

    public void remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        numNodes--;
    }

    public void remove(Object data) {
        Node temp = head;
        Node prev = null;

        while (temp != null && !temp.data.equals(data)) {
            prev = temp;
            temp = temp.next;
        }

        if (temp != null) {
            if (prev == null) {
                head = temp.next;
            } else {
                prev.next = temp.next;
            }
            numNodes--;
        }
    }

    public Object get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public int size() {
        return numNodes;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public MyLinkedTest clone() {
        MyLinkedTest newList = new MyLinkedTest(null);
        Node temp = head;

        while (temp != null) {
            newList.addLast(temp.data);
            temp = temp.next;
        }

        return newList;
    }

    public boolean contains(Object data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(Object data) {
        Node temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.data.equals(data)) {
                return index;
            }
            temp = temp.next;
            index++;
        }

        return -1;
    }
}
