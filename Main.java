public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.out.println("Creating MyLinkedList...");
        MyLinkedTest myList = new MyLinkedTest(10);

        myList.add(20);
        myList.addFirst(5);
        myList.addLast(30);

        System.out.println("Original List:");
        myList.printList();

        System.out.println("Removing element at index 1...");
        myList.remove(1);
        myList.printList();

        System.out.println("Removing element 30...");
        myList.remove(30);
        myList.printList();

        System.out.println("Getting element at index 1: " + myList.get(1));

        System.out.println("Cloning the list...");
        MyLinkedTest clonedList = myList.clone();
        System.out.println("Cloned List:");
        clonedList.printList();

        System.out.println("Checking if the list contains 20: " + myList.contains(20));
    }
}