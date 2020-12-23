package ch02;

public class Ch02_16 {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add("String 1");
        q.add("String 2");
        q.add("String 3");
        q.remove();
        q.remove();
        q.remove();
        q.remove();
        q.add("String 4");
        q.remove();
    }

}

class Queue {
    public class Node{
        private Node next;
        private String text;

        private Node(String text) {
            this.text = text;
        }
    }

    private Node firstNode;
    private Node lastNode;

    public void add(String text) {
        Node newNode = new Node(text);
        if (lastNode == null) {
            firstNode = lastNode = newNode;
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
        System.out.println("New node added to the end of the queue.\nIt has text: " + lastNode.text);
    }

    public void remove() {
        if (firstNode != null) {
            System.out.println("First node removed from queue.\nIt had text: " + firstNode.text);
            firstNode = firstNode.next;
            if (firstNode == null) {
                lastNode = null;
            }
        } else {
            System.out.println("Nothing to remove.");
        }
    }
}
