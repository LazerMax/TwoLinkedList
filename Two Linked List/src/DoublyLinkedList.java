public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    public void addAfter(T data, T afterData) {
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;

        while (current != null && !current.getData().equals(afterData)) {
            current = current.getNext();
        }

        if (current != null) {
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            newNode.setPrev(current);
            if (newNode.getNext() != null) {
                newNode.getNext().setPrev(newNode);
            } else {
                tail = newNode;
            }
            size++;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        size--;
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("Список пуст!");
        } else {
            if (isEmpty()) {
                return;
            }

            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.getPrev();
                tail.setNext(null);
            }
            size--;
        }
    }

    public void remove(T data) {
        Node<T> current = head;

        if (size == 0) {
            System.out.println("Список пуст!");
        } else {
            while (current != null && !current.getData().equals(data)) {
                current = current.getNext();
            }

            if (current != null) {
                if (current == head) {
                    removeFirst();
                } else if (current == tail) {
                    removeLast();
                } else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                    size--;
                }
            }
        }
    }

    public void edit(T data, T newData) {
        if (size == 0) {
            System.out.println("Список пуст!");
        }
        
        Node<T> current = head;

        System.out.println(size);
        while (current != null && !current.getData().equals(data)) {
            current = current.getNext();
        }

        if (current != null) {
            current.setData(newData);
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void printList() {
        Node<T> current = head;

        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }

        System.out.println();
    }
}