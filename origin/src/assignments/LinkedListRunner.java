package assignments;

public class LinkedListRunner {
    public static void main(String[] args) {
        System.out.println("Example #1");
        LinkedList linkedList = new LinkedList();
        linkedList.addNewNodes(new String[]{"A", "B", "C", "D", "E"});
        linkedList.printList();
        linkedList.addLoop("D");
        linkedList.printList();

        System.out.println("Example #2");
        LinkedList linkedList1 = new LinkedList();
        linkedList1.addNewNodes(new String[]{"A", "B", "C", "D", "E"});
        linkedList1.printList();
        linkedList1.addLoop("A");
        linkedList1.printList();

        System.out.println("Example #3");
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addLoop("A");
        linkedList2.printList();

    }
}
