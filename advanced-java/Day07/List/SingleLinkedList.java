public class SingleLinkedList implements List {
    private Node head;
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // 마지막에 삽입
    @Override
    public void add(int value) {
        if (this.size == 0) {
            this.head.setNextNode(new Node(value));
        } else {
            Node currentNode = this.head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(new Node(value));
        }
    }

    @Override
    public void remove(int idx) { // 첫번째 노드 지우기 = 0번 인덱스 지우기
        if (size == 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (idx == 0) {
            head = head.getNextNode();
        } else {
            Node deleteNode = head;
            for (int i = 0; i < idx - 1; i++) {
                deleteNode = deleteNode.getNextNode();
            }
            deleteNode.setNextNode(deleteNode.getNextNode().getNextNode());
        }
    }

    @Override
    public int get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node currentNode = this.head;
        for (int i = 0; i < idx; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getData();
    }

}

class Node {
    private int data;
    private Node nextNode;

    public Node(int i) {
        this.data = i;
    }

    public int getData() {
        return this.data;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node node) {
        this.nextNode = node;
    }
}