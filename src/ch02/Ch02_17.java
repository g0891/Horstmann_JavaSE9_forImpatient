package ch02;

public class Ch02_17 {
    public static void main(String[] args) {
        Queue17 q = new Queue17();
        q.add("String 1");
        q.add("String 2");
        q.add("String 3");
        q.add("String 4");
        q.add("String 5");

        Queue17.Iterator itr = q.iterator();
        while (itr.hasNext()) {
            System.out.println("Node text: " + itr.next().getText());
        }
    }

}

class Queue17 {
    public class Node{
        private Node next;
        private String text;

        private Node(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    public class Iterator {
        private Node currentNode = firstNode;

        private Iterator(){}

        public Node next() {
            Node current = currentNode;
            if (currentNode != null) {
                currentNode = currentNode.next;
            }
            return current;
        }
        public boolean hasNext() {
            return currentNode != null;
        }
    }

    public Iterator iterator() {
        return new Iterator();
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
