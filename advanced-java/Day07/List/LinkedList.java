public class LinkedList implements List {
    // iner class
    private class Node {
        int value;
        Node prev;
        Node next;

        // 생성자
        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    // 리스트의 size
    private int size;
    // 가장 처음 인덱스 node
    private Node head;
    // 가장 마지막 인덱스 node
    private Node tail;

    // 생성자
    public LinkedList() {
        this.size = 0; // 리스트의 size 초기화
        this.head = null; // 처음 인덱스의 노드 초기화
        this.tail = null; // 마지막 인덱스의 노드 초기화
    }

    // size getter
    public int getSize() {
        return size; // 리스트의 size 반환
    }

    // List interface의 add 함수 재정의
    @Override
    public void add(int value) {
        // size가 0인 경우 처음 인덱스 노드와 마지막 인덱스 노드를 생성한 노드로 지정
        if (size == 0) {
            head = new Node(value, null, null);
            tail = head;
        } else { // size가 0이 아닌 경우 마지막 인덱스 노드의 다음 노드로 새로 생성한 노드로 지정한 후 지정한 노드를 마지막 인덱스 노드로 변경
            tail.next = new Node(value, tail, null);
            tail = tail.next;
        }
        // 리스트의 size 증가
        ++size;
    }

    @Override
    public void remove(int idx) {
        // 인덱스가 범위 밖이라면 UnCheckedException인 ArrayIndexOutOfBoundsException를 던짐
        if (idx < 0 || idx >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of range");
        }

        if (size == 1) { // size가 1이라면 다음 또는 이전의 노드가 null 이기 때문에 처음 인덱스 노드와 마지막 인덱스 노드를 null로 변경
            head = null;
            tail = null;
        } else if (idx == 0) {
            // 삭제하는 node index가 0인 경우 처음 인덱스 노드의 다음 인덱스 노드로 변경하고 unAccess하도록 이전 노드를 null로 변경
            head = head.next;
            head.prev = null;
        } else if (idx == size - 1) {
            // 삭제하는 node index가 마지막인 경우 마지막 인덱스 노드의 이전 인덱스 노드로 변경하고 unAccess하도록 다음 노드를 null로
            // 변경
            tail = tail.prev;
            tail.next = null;
        } else {
            /*
             * 위의 모든 경우가 아니라면 해당 인덱스의 노드 까지 찾아감
             * 0-0-0
             * 삭제할 노드의 이전 노드의 다음 인덱스 노드를 삭제할 노드의 다음 인덱스 노드로 변경
             * |---|
             * | v
             * 0 0 0
             * 삭제할 노드의 다음 노드의 이전 인덱스 노드를 삭제할 노드의 이전 인덱스 노드로 변경
             * |---|
             * v |
             * 0 0 0
             * 삭제할 노드는 unAccess하므로 가비지 컬랙터가 가져갈 꺼임
             */
            Node removeNode = head;

            for (int i = 0; i < idx; ++i) {
                removeNode = removeNode.next;
            }
            removeNode.prev.next = removeNode.next;
            removeNode.next.prev = removeNode.prev;
        }
        // 리스트의 size 감소
        --size;
    }

    @Override
    public int get(int idx) {
        // 인덱스가 범위 밖이라면 UnCheckedException인 ArrayIndexOutOfBoundsException를 던짐
        if (idx < 0 || idx >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of range");
        }
        // 주어진 index의 노드까지 찾아간 후 값을 반환
        Node node = head;

        for (int i = 0; i < idx; ++i) {
            node = node.next;
        }
        return node.value;
    }

    // 출력 메소드 재정의
    @Override
    public String toString() {
        Node node = head;
        StringBuilder sb = new StringBuilder("(");

        for (int i = 0; i < size; ++i) {
            sb.append(node.value).append(", ");
            node = node.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }
}
