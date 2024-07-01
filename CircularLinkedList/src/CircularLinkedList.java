public class CircularLinkedList<T> {
    private Node<T> head;
    private Node<T> prev;

    CircularLinkedList() {
        head = null;
        prev = null;
    }

    public void add(T data) {
        final Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            prev = newNode;
            head.next = head;
            head.prev = head;
        } else {
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = head;
            head.prev = newNode;
            prev = newNode;
        }
    }

    public void display() {
        if (head == null) {
            return;
        }
        Node<T> current = head;
        System.out.println("List: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public T get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty.");
        }

        Node<T> current = head;
        int count = 0;

        do {
            if (count == index) {
                return current.data;
            }
            current = current.next;
            count++;
        } while (current != head);

        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
    }

    public int search(T data) {
        int index = -1;
        if (head == null) {
            return index;
        }

        Node<T> current = head;

        do {
            if (current.data.equals(data)) {
                return index;
            }
            index++;
            current = current.next;
        } while (current != head);

        return index;
    }

    public void remove(T data) {
        if (head == null) {
            return; // List is empty
        }

        Node<T> current = head;

        do {
            if (current.data.equals(data)) {
                if (current == head) {
                    if (head == prev) {
                        // Only one element
                        head = null;
                        prev = null;
                    } else {
                        head = head.next;
                        head.prev = prev;
                        prev.next = head;
                    }
                } else if (current == prev) {
                    prev = prev.prev;
                    prev.next = head;
                    head.prev = prev;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        } while (current != head);
    }
}
