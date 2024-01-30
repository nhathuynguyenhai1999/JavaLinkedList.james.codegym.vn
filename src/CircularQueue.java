public class CircularQueue {
    private Node front;
    private Node rear;

    public CircularQueue() {
        this.front = null;
        this.rear = null;
    }
    public void enQueue(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            front = rear = newNode;
            rear.next = front; // Liên kết rear với front trong trường hợp hàng đợi chỉ có một phần tử
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front; // Liên kết rear với front trong trường hợp hàng đợi có nhiều phần tử
        }
    }

    // Phương thức lấy ra một phần tử từ đầu hàng đợi
    public Integer deQueue() {
        if (isEmpty()) {
            System.out.println("Hàng đợi trống.");
            return null;
        }

        int removedValue = (int) front.data;

        if (front == rear) {
            // Nếu chỉ còn một phần tử, reset front và rear về null
            front = rear = null;
        } else {
            // Nếu có nhiều hơn một phần tử, di chuyển front đến phần tử tiếp theo
            front = front.next;
            rear.next = front; // Liên kết rear với front trong trường hợp hàng đợi có nhiều phần tử
        }

        return removedValue;
    }

    // Phương thức kiểm tra hàng đợi có trống hay không
    public boolean isEmpty() {
        return front == null;
    }

    // Phương thức hiển thị các phần tử trong hàng đợi
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Hàng đợi trống.");
            return;
        }

        Node temp = front;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }
}
